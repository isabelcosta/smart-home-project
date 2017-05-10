package com.example.utils;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.example.utils.domain.Division;
import com.example.utils.domain.DivisionType;
import com.example.utils.domain.Floor;
import com.example.utils.domain.HomeConfigEntity;
import com.example.utils.domain.User;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import static com.example.utils.HouseConfigConstants.ACCESS_LEVEL;
import static com.example.utils.HouseConfigConstants.DEVICE_CLASS;
import static com.example.utils.HouseConfigConstants.DEVICE_CLASS_LIST;
import static com.example.utils.HouseConfigConstants.DIVSION;
import static com.example.utils.HouseConfigConstants.DIVSION_LIST;
import static com.example.utils.HouseConfigConstants.DIVSION_TYPE;
import static com.example.utils.HouseConfigConstants.DIVSION_TYPE_LIST;
import static com.example.utils.HouseConfigConstants.FLOOR;
import static com.example.utils.HouseConfigConstants.FLOOR_LIST;
import static com.example.utils.HouseConfigConstants.HEIGHT_ORDER;
import static com.example.utils.HouseConfigConstants.HOUSE;
import static com.example.utils.HouseConfigConstants.ID;
import static com.example.utils.HouseConfigConstants.NAME;
import static com.example.utils.HouseConfigConstants.PASSWORD;
import static com.example.utils.HouseConfigConstants.REF_DIVISION_TYPE;
import static com.example.utils.HouseConfigConstants.REF_FLOOR;
import static com.example.utils.HouseConfigConstants.USER;
import static com.example.utils.HouseConfigConstants.USER_LIST;

/**
 * Created by isabelcosta on 18/03/2017.
 */
public class DomoBusConfigLoader {

    private String _configFilesCommonPackage = "./commonlib/src/main/java/com/example/utils/configs";
    private String _configFilesServerPackage = "./server/src/main/java/com/example/server/configs";
    private HomeConfigEntity _homeConfig;

    public DomoBusConfigLoader(){}

    // Structures

    public DomoBusConfigLoader(String configFileName, boolean isFromServer) {

        try {

            File directoryFiles = new File(isFromServer
                    ? _configFilesServerPackage
                    : _configFilesCommonPackage
            ); // config file folder path

            File[] filesList = directoryFiles.listFiles(); // It gives list of all files in the folder.

            File file = null;

            if (filesList != null) {
                for (File f: filesList) {
                    if (configFileName.equalsIgnoreCase(f.getName())) {
                        file = f;
                    }
                }
                if (file != null){
                    SAXReader reader = new SAXReader();
                    Document document = reader.read(file);

                    // Do something with the document here.
                    createStructures(document);
                } else {
                    throw new DocumentException();
                }
            } else {
                throw new DocumentException();
            }
        }
        catch (DocumentException e) {
            System.out.println("There is no file with the name: " + configFileName);
            e.printStackTrace();
        }
    }

    public DomoBusConfigLoader(Document document){
        createStructures(document);
    }
    public HomeConfigEntity getHomeConfig(){
        return _homeConfig;
    }

    private void createStructures(Document document){

        // Parse xml into structures
        _homeConfig = new HomeConfigEntity();

        System.out.println("Root element :" + document.getRootElement().getName());

        // Root class is DomoBusSystem
        Element classElement = document.getRootElement();
//
//        List<Node> nodes = classElement.selectNodes(DEVICE_CLASS_LIST + "/" + DEVICE_CLASS);
//        System.out.println("----------------------------\n");
//        for (Node node : nodes) {
//            System.out.println("Current Element : " + node.getName());
//            System.out.println("ID : " + node.valueOf(getAttribute(ID)));
//            System.out.println("Name : " + node.valueOf(getAttribute(NAME)));
//        }

        parseFloors(classElement);
        parseDivisions(classElement);
        parseDivisionsType(classElement);
        parseUsersList(classElement);
    }

    /**
     * Parsers
     */

    private void parseFloors(Element classElement) {
        // Get Floors List

        List<Node> floorListXML = classElement.selectNodes(HOUSE + "/" + FLOOR_LIST + "/" + FLOOR);
        List<Floor> floorList = new ArrayList<>();

        for (Node node : floorListXML) {
            Floor f = new Floor(
                    node.valueOf(getAttribute(ID)),
                    node.valueOf(getAttribute(NAME)),
                    node.valueOf(getAttribute(HEIGHT_ORDER))
            );
            floorList.add(f);
        }

        _homeConfig.setFloorList(floorList);
    }

    private void parseDivisions(Element classElement){
        // Get Divisions List

        List<Node> divisionListXML = classElement.selectNodes(HOUSE + "/" + DIVSION_LIST + "/" + DIVSION);
        List<Division> divisionList = new ArrayList<>();

        for (Node node : divisionListXML) {
            Division d = new Division(
                    node.valueOf(getAttribute(ID)),
                    node.valueOf(getAttribute(NAME)),
                    node.valueOf(getAttribute(REF_FLOOR)),
                    node.valueOf(getAttribute(ACCESS_LEVEL)),
                    node.valueOf(getAttribute(REF_DIVISION_TYPE))
            );
            divisionList.add(d);
        }

        _homeConfig.setDivisionList(divisionList);
    }

    private void parseDivisionsType(Element classElement){
        // Get Divisions Type List

        List<Node> divisionTypeListXML = classElement.selectNodes(DIVSION_TYPE_LIST + "/" + DIVSION_TYPE);
        List<DivisionType> divisionTypeList = new ArrayList<>();

        for (Node node : divisionTypeListXML) {
            DivisionType d = new DivisionType(
                    node.valueOf(getAttribute(ID)),
                    node.valueOf(getAttribute(NAME))
            );
            divisionTypeList.add(d);
        }

        _homeConfig.setDivisionTypeList(divisionTypeList);
    }

    private void parseUsersList(Element classElement){
        // Get Divisions Type List

        List<Node> userListXML = classElement.selectNodes(USER_LIST + "/" + USER);
        List<User> userList = new ArrayList<>();

        for (Node node : userListXML) {
            User d = new User(
                    node.valueOf(getAttribute(ID)),
                    node.valueOf(getAttribute(NAME)),
                    node.valueOf(getAttribute(PASSWORD)),
                    node.valueOf(getAttribute(ACCESS_LEVEL))

            );
            userList.add(d);
        }

        _homeConfig.setUserList(userList);
    }

    private String getAttribute(String attr){
        return "@" + attr;
    }

    public static void main(String[] args) {

        DomoBusConfigLoader configLoader = new DomoBusConfigLoader("basic_config_1.xml", false);
        for (Division d : configLoader.getHomeConfig().getDivisionList()){
            System.out.println(d.getName());
        }
    }
}
