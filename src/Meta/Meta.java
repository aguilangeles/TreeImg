package Meta;

import org.enhydra.xml.XmlHelper;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Replica del Meta.xml
 * Date: 10/14/12 Time: 8:58 PM
 */
public class Meta {

  private String idIDC;
  private Date creationDate;
  private String status;
  private NamedNodeMap campos;
  private Image image;
  private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

  public String getIdIDC() {
    return idIDC;
  }

  public NamedNodeMap getCampos() {
    return campos;
  }

  public void setCampos(NamedNodeMap campos) {
    this.campos = campos;
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

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
  }

  public Meta() {
  }

  public boolean isMetaValid() {
    return this.status.equalsIgnoreCase("Valid");
  }

  public boolean isMetaInvalid() {
    return this.status.equalsIgnoreCase("Invalid");
  }

  public Meta(String idIDC, Date creationDate, String status, Image image) {
    this.idIDC = idIDC;
    this.creationDate = creationDate;
    this.status = status;
    this.image = image;
  }

  public Meta(NodeList nodes) {
    //
    String idIDC = XmlHelper.getNodeValue("IdIDC", nodes);
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
    Node imageNode = XmlHelper.getNode("Image", nodes);
    Image image = null;
    if (imageNode != null)
      {
      this.campos = XmlHelper.getNodesByName("Campo", imageNode.getChildNodes());
      image = new Image(campos);
      } else
      {
//Todo : modificar para que deje los espacios vacios?

      image = null;
      }

    this.idIDC = idIDC;
    this.creationDate = date;
    this.status = status;
    this.image = image;
  }

  @Override
  public String toString() {
    return "idIDC=" + idIDC
            + "\n creationDate=" + creationDate
            + "\n status=" + status
            + "\n image=" + image;
  }
}
