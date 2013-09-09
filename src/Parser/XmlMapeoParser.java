package Parser;

import Entidades.XmlMapeo;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import helper.XmlHelper;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**

 */
public class XmlMapeoParser {

    private DOMParser parser = new DOMParser();
    private String fileLocation="";
    private Document doc;
    private NodeList root;
    private Node xmlMapeoNode;
    private NamedNodeMap mapeoLists;
    private ReporteXMLMapeo reporte;


    public XmlMapeoParser(String fileLocation) throws IOException, SAXException {
        this.fileLocation = fileLocation;
        parser.parse(this.fileLocation);
        this.doc = parser.getDocument();
        this.root = doc.getChildNodes();
        this.xmlMapeoNode = XmlHelper.getNode("XmlMapeo", root);
        this.mapeoLists = XmlHelper.getNodesByName("MapeoList", xmlMapeoNode.getChildNodes());
        this.reporte = new ReporteXMLMapeo(this.mapeoLists);
    }

    public DOMParser getParser() {
        return parser;
    }

    public ReporteXMLMapeo getReporte() {
        return reporte;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public Document getDoc() {
        return doc;
    }

    public NodeList getRoot() {
        return root;
    }

    public Node getXmlMapeoNode() {
        return xmlMapeoNode;
    }

    public NamedNodeMap getMapeoLists() {
        return mapeoLists;
    }

    public void parse() {

        NodeList xmlMapeoNodeChildren = xmlMapeoNode.getChildNodes();
        XmlMapeo xmlMapeo = new XmlMapeo(xmlMapeoNode.getChildNodes());
        xmlMapeo.setMapeoLists(mapeoLists);
        for (int i = 0; i < mapeoLists.getLength(); i++) {
            Node mapeoListNode = mapeoLists.item(i);
            NodeList mapeoChildren = mapeoListNode.getChildNodes();
            MapeoList mapeoList = new MapeoList(mapeoChildren);
        }
    }
}



