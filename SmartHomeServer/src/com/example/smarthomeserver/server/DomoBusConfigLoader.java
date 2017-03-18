package com.example.smarthomeserver.server;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by isabelcosta on 18/03/2017.
 */
public class DomoBusConfigLoader {


    // Structures

    public DomoBusConfigLoader(String configFileName){


        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setIgnoringElementContentWhitespace(true);
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            File file = new File(configFileName);
            Document doc = builder.parse(file);

            // Do something with the document here.
            createStructures(doc);

        } catch (ParserConfigurationException e) {
        } catch (SAXException e) {
        } catch (IOException e) {
            System.out.println("There is no file with the name:" + configFileName);
        }
    }

    private void createStructures(Document document){

        // Parse xml into structures

    }

}
