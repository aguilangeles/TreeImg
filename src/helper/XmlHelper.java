package helper;

/**
 * User: fabricio
 * Date: 10/14/12
 * Time: 8:49 PM
 * Taken from the Eric Bruno's article at http://www.drdobbs.com/jvm/easy-dom-parsing-in-java/231002580
 */

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.enhydra.xml.*;

import java.util.ArrayList;
import java.util.HashMap;
import org.w3c.dom.Element;

public class XmlHelper {

    public static NamedNodeMap getNodesByName(String tagName, NodeList nodes) {
        NamedNodeMap namedNodeMap = new NamedNodeMapImpl(new ArrayList());
        for (int x = 0; x < nodes.getLength(); x++){
            Node node = nodes.item(x);
            if(node.getNodeName().equalsIgnoreCase(tagName)) {
                namedNodeMap.setNamedItem(node);
            }
        }
        return namedNodeMap;
    }

    public static Node getNode(String tagName, NodeList nodes) {
        for ( int x = 0; x < nodes.getLength(); x++ ) {
            Node node = nodes.item(x);
            if (node.getNodeName().equalsIgnoreCase(tagName)) {
                return node;
            }
        }

        return null;
    }

    public static String getNodeValue( Node node ) {
        NodeList childNodes = node.getChildNodes();
        for (int x = 0; x < childNodes.getLength(); x++ ) {
            Node data = childNodes.item(x);
            if ( data.getNodeType() == Node.TEXT_NODE )
                return data.getNodeValue();
        }
        return "";
    }

    public static String getNodeValue(String tagName, NodeList nodes ) {
        for ( int x = 0; x < nodes.getLength(); x++ ) {
            Node node = nodes.item(x);
            if (node.getNodeName().equalsIgnoreCase(tagName)) {
                NodeList childNodes = node.getChildNodes();
                for (int y = 0; y < childNodes.getLength(); y++ ) {
                    Node data = childNodes.item(y);
                    if ( data.getNodeType() == Node.TEXT_NODE )
                        return data.getNodeValue();
                }
            }
        }
        return "";
    }

    public static String getNodeAttr(String attrName, Node node ) {
        NamedNodeMap attrs = node.getAttributes();
        for (int y = 0; y < attrs.getLength(); y++ ) {
            Node attr = attrs.item(y);
            if (attr.getNodeName().equalsIgnoreCase(attrName)) {
                return attr.getNodeValue();
            }
        }
        return "";
    }

    public static String getNodeAttr(String tagName, String attrName, NodeList nodes ) {
        for ( int x = 0; x < nodes.getLength(); x++ ) {
            Node node = nodes.item(x);
            if (node.getNodeName().equalsIgnoreCase(tagName)) {
                NodeList childNodes = node.getChildNodes();
                for (int y = 0; y < childNodes.getLength(); y++ ) {
                    Node data = childNodes.item(y);
                    if ( data.getNodeType() == Node.ATTRIBUTE_NODE ) {
                        if ( data.getNodeName().equalsIgnoreCase(attrName) )
                            return data.getNodeValue();
                    }
                }
            }
        }

        return "";
    }
//        private String getTagValue(String tagName, Element elemento) {
//        NodeList nodeList = elemento.getElementsByTagName(tagName).item(0).getChildNodes();
//        Node node = (Node) nodeList.item(0);
//        // if("Image".equals(tagName))getCampos(nodeList);
//        return node.getNodeValue();
//    }
//
//    private static String getAttributeValue(String nombreAtributo, Node elemento) {
//        String ret = "";
//        NamedNodeMap atributesMap = elemento.getAttributes();
//        Node atributo = atributesMap.getNamedItem(nombreAtributo);
//        if(atributo != null) ret = atributo.getNodeValue();
//
//        return ret;
//
//    }
//
//    private void getCampos(NodeList nodos){
//        for(int i=1;i<nodos.getLength();i++){
//            Node campo = nodos.item(i);
//            if  (   campo.getNodeType() == Node.ELEMENT_NODE
//                    && "Campo".equals(campo.getNodeName())
//                ){
//                String status = getAttributeValue("Status", campo);
//                String statusOutput = ("".equals(status)) ? "" : " - "+status;
//                System.out.println("\t"+getAttributeValue("Name", campo)+": "+getAttributeValue("Value", campo)+statusOutput);
//            }
//        }

    }



