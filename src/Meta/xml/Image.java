package Meta.xml;

import org.w3c.dom.NamedNodeMap;

/**
 *
 */
public class Image {

  private NamedNodeMap campos;

  public Image() {
  }

  public Image(NamedNodeMap campos) {
    this.campos = campos;
    for (int i = 0; i < campos.getLength(); i++)
      {
      Campo campo = new Campo(campos.item(i));
      }
  }

  public Campo getCampoByName(String name) {
    for (int i = 0; i < campos.getLength(); i++)
      {
      Campo campo = new Campo(campos.item(i));
      if (campo.getName().equalsIgnoreCase(name))
        {
        return campo;
        }
      }
    return null;
  }

  public Campo getCampoByValue(String value) {
    for (int i = 0; i < campos.getLength(); i++)
      {
      Campo campo = new Campo(campos.item(i));
      if (campo.getValue().equalsIgnoreCase(value))
        {
        return campo;
        }
      }
    return null;
  }

  public int getCantidadDeCampos() {
    // descuenta el idImagen
    return campos.getLength() - 1;
  }
  //add from metadato

  public Campo getCampoByStatus(String status) {
    for (int i = 0; i < campos.getLength(); i++)
      {
      Campo campo = new Campo(campos.item(i));
      if (campo.getValue().equalsIgnoreCase(status))
        {
        return campo;
        }
      }
    return null;
  }

  public Campo getCampoByIndex(Integer index) {
    Campo ret = new Campo(campos.item(index));
    return ret;
  }

  @Override
  public String toString() {
    String ret = "";
    for (int i = 0; i < campos.getLength(); i++)
      {
      Campo campo = new Campo(campos.item(i));
      ret += ("\n" + campo);
      // ret += campo + ",";
      }
    return ret;
  }

  public NamedNodeMap getCampos() {
    return campos;
  }

  public void setCampos(NamedNodeMap campos) {
    this.campos = campos;
  }
}
