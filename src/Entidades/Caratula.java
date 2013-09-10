package Entidades;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//import Meta.Metadato;
import Meta.Image;
import org.enhydra.xml.XmlHelper;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author MUTNPROD003
 */
public class Caratula {

  private String idIDC;
  private Date creationDate;
  private String status;
  private String docType;
  private String crtType;
  private int secuencial;
  private int subTypeCode;
  private String level;
  private String user;
  private Image image;
  private NamedNodeMap campos;

  public NamedNodeMap getCampos() {
    return campos;
  }

  public void setCampos(NamedNodeMap campos) {
    this.campos = campos;
  }
  private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

  public String getIdIDC() {
    return idIDC;
  }

  public void setIdIDC(String idIDC) {
    this.idIDC = idIDC;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getDocType() {
    return docType;
  }

  public void setDocType(String docType) {
    this.docType = docType;
  }

  public String getCrtType() {
    return crtType;
  }

  public void setCrtType(String crtType) {
    this.crtType = crtType;
  }

  public int getSecuencial() {
    return secuencial;
  }

  public void setSecuencial(int secuencial) {
    this.secuencial = secuencial;
  }

  public int getSubTypeCode() {
    return subTypeCode;
  }

  public void setSubTypeCode(int subTypeCode) {
    this.subTypeCode = subTypeCode;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public void setImage(Image image) {
    this.image = image;
  }

  public Image getImage() {
    return image;
  }

  public boolean isEjercicio() {
    return this.docType.equalsIgnoreCase("EJER");
  }

  public boolean isGasto() {
    return this.docType.equalsIgnoreCase("GAST");
  }

  public boolean isRecibo() {
    return this.docType.equalsIgnoreCase("REC");
  }

  public Caratula() {
  }

  public Caratula(String idIDC, Date creationDate, String status, String docType, String crtType, int secuencial, int subTypeCode, String level, String user, Image image) {
    this.idIDC = idIDC;
    this.creationDate = creationDate;
    this.status = status;
    this.docType = docType;
    this.crtType = crtType;
    this.secuencial = secuencial;
    this.subTypeCode = subTypeCode;
    this.level = level;
    this.user = user;
    this.image = image;
  }

  public Caratula(NodeList nodes) {
    //contenido de caratula
    String idIDC = XmlHelper.getNodeValue("idIDC", nodes);
    String creationDate = XmlHelper.getNodeValue("CreationDate", nodes);
    Date date = null;
    try
      {
      date = dateFormat.parse(creationDate);
      } catch (Exception e)
      {
      e.printStackTrace();
      }
    String status = XmlHelper.getNodeValue("Status", nodes);
    String docType = XmlHelper.getNodeValue("DocType", nodes);
    String crtType = XmlHelper.getNodeValue("CrtType", nodes);
    int secuencial = Integer.parseInt(XmlHelper.getNodeValue("Secuencial", nodes));
    int subTypeCode = Integer.parseInt(XmlHelper.getNodeValue("SubTypeCode", nodes));
    String level = XmlHelper.getNodeValue("Level", nodes);
    String user = XmlHelper.getNodeValue("User", nodes);
    //fin contenido caratula.
    Node caratulaNode = XmlHelper.getNode("Metadato", nodes);
    this.campos = XmlHelper.getNodesByName("Campo", caratulaNode.getChildNodes());
    Image image = new Image(campos);
    this.idIDC = idIDC;
    this.creationDate = date;
    this.status = status;
    this.docType = docType;
    this.crtType = crtType;
    this.secuencial = secuencial;
    this.subTypeCode = subTypeCode;
    this.level = level;
    this.user = user;
    this.image = image;
  }

  public String toString() {
    return "Caratula "
            //                + "\nCantidad de Campos= " + campos.getLength()
            + "\nidIDC= " + idIDC
            + "\ncreationDate= " + creationDate
            + "\nstatus= " + status
            + "\ndocType= " + docType
            + "\ncrtType= " + crtType
            + "\nsecuencial= " + secuencial
            + "\nsubTypeCode= " + subTypeCode
            + "\nlevel= " + level
            + "\nuser= " + user
            + "\nimage= " + image;
  }
}
