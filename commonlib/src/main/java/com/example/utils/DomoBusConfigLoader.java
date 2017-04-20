package com.example.utils;


import java.io.File;
import java.util.List;

import com.example.utils.domain.HomeConfigEntity;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import static com.example.utils.HouseConfigConstants.DEVICE_CLASS;
import static com.example.utils.HouseConfigConstants.DEVICE_CLASS_LIST;
import static com.example.utils.HouseConfigConstants.ID;
import static com.example.utils.HouseConfigConstants.NAME;

/**
 * Created by isabelcosta on 18/03/2017.
 */
public class DomoBusConfigLoader {

    private static DomoBusConfigLoader _ourInstance = new DomoBusConfigLoader();
    private String _configFilesPackage = "./commonlib/src/main/java/com/example/utils/configs";
    private HomeConfigEntity _homeConfig;

    public DomoBusConfigLoader(){}

    // Structures

    public DomoBusConfigLoader(String configFileName){

        try {

            File directoryFiles = new File(_configFilesPackage); // your folder path
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

    public static DomoBusConfigLoader getInstance() {
        return _ourInstance;
    }

    private void createStructures(Document document){

        // Parse xml into structures
        HomeConfigEntity homeConfigInConstruction = new HomeConfigEntity();

        System.out.println("Root element :" + document.getRootElement().getName());

        // Root class is DomoBusSystem
        Element classElement = document.getRootElement();

        List<Node> nodes = classElement.selectNodes(DEVICE_CLASS_LIST + "/" + DEVICE_CLASS);
        System.out.println("----------------------------\n");
        for (Node node : nodes) {
            System.out.println("Current Element :" + node.getName());
            System.out.println("ID : " + node.valueOf(getAttribute(ID)));
            System.out.println("Name : " + node.valueOf(getAttribute(NAME)));
        }

        _homeConfig = homeConfigInConstruction;
    }

    public HomeConfigEntity getHomeConfig(){
        return _homeConfig;
    }

    private String getAttribute(String attr){
        return "@" + attr;
    }
    public static void main(String[] args) {

        DomoBusConfigLoader configLoader = new DomoBusConfigLoader("basic-config-1.xml");

    }
}
