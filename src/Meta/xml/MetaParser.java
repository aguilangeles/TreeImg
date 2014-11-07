package Meta.xml;

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
 * Date: 10/15/12 Time: 11:50 AM
 */
public class MetaParser {

  private DOMParser parser = new DOMParser();
  private String fileLocation = "";
  private Document doc;
  private NodeList root;
  private Node xmlMeta;
  private NamedNodeMap metas;
  private ReporteXMLMetas reporte;

  public MetaParser(String fileLocation) throws SAXException, IOException {

    this.fileLocation = fileLocation;
    parser.parse(this.fileLocation);
    this.doc = parser.getDocument();
    this.root = doc.getChildNodes();
    this.xmlMeta = XmlHelper.getNode("XmlMetas", root);
    this.metas = XmlHelper.getNodesByName("Meta", xmlMeta.getChildNodes());
    this.reporte = new ReporteXMLMetas(this.metas);
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

  public Node getXmlMeta() {
    return xmlMeta;
  }

  public NamedNodeMap getMetas() {
    return metas;
  }

  public ReporteXMLMetas getReporte() {
    return reporte;
  }

  public void setReporte(ReporteXMLMetas reporte) {
    this.reporte = reporte;
  }

  public void parse() {
    for (int i = 0; i < metas.getLength(); i++)
      {
      Node metaNode = metas.item(i);
      NodeList metaChildren = metaNode.getChildNodes();
      Meta meta = new Meta(metaChildren);
      System.out.println(meta.toString());
      }
  }
}
