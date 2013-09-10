/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Entidades.Caratula;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.enhydra.xml.XmlHelper;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



/**
 *
 * @author MUTNPROD003
 */

public class CaratulaParser {
    private DOMParser parser = new DOMParser();
    private String fileLocation = "";
    private Document doc;
    private NodeList root;
    private Node xmlCaratula;
    private NamedNodeMap caratulasNodeMap;
    private ReporteXMlCaratula reporte;

    public CaratulaParser(String fileLocation) throws SAXException, IOException {
        this.fileLocation = fileLocation;
        parser.parse(this.fileLocation);
        this.doc = parser.getDocument();
        this.root = doc.getChildNodes();
        this.xmlCaratula = XmlHelper.getNode("XmlCarat", root);
        this.caratulasNodeMap = XmlHelper.getNodesByName("Caratula", xmlCaratula.getChildNodes());
        this.reporte = new ReporteXMlCaratula(this.caratulasNodeMap);
    }

    public CaratulaParser() {
    }

    public ReporteXMlCaratula getReporte() {
        return reporte;
    }

    public DOMParser getParser() {
        return parser;
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

    public Node getXmlCaratula() {
        return xmlCaratula;
    }

    public NamedNodeMap getCaratulas() {
        return caratulasNodeMap;
    }

    public void parse() {

        for (int i = 0; i < caratulasNodeMap.getLength(); i++) {
            Node caratulaNode = caratulasNodeMap.item(i);
            NodeList caratulaChildren = caratulaNode.getChildNodes();
            Caratula caratula = new Caratula(caratulaChildren);
        }
    }
}
