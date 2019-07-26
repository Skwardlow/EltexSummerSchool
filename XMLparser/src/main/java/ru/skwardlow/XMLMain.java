package ru.skwardlow;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XMLMain {
    private static ArrayList<Spaceship> listOfShips = new ArrayList<>();
    public static void main(String[] args)throws IOException, SAXException, ParserConfigurationException {

        File anXML = new File("src/main/resources/new.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(anXML);
        NodeList shipElems = doc.getElementsByTagName("shipID");
        for (int i=0;i<shipElems.getLength();i++){
            Node currShip = shipElems.item(i);
            Element innerData = (Element) currShip;
            NamedNodeMap attributes = currShip.getAttributes();
            Spaceship buff = new Spaceship(innerData.getElementsByTagName("weight").toString(),
                    attributes.getNamedItem("name").toString(),
                    innerData.getElementsByTagName("shipclass").toString());
            System.out.println(buff.toString());
        }

    }
}
