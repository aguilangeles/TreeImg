/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Meta.xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Administrador
 */
public class ReporteXMLMetas {

  private List<Meta> metas = new ArrayList<>();
  private List<String> nombresCampos;
  private List<String> statuses;

  public ReporteXMLMetas() {
  }

  public ReporteXMLMetas(List<Meta> metas) {
    this.metas = metas;
  }

  public ReporteXMLMetas(NamedNodeMap metaNodes) {
    for (int i = 0; i < metaNodes.getLength(); i++)
      {
      Node metaNode = metaNodes.item(i);
      NodeList metaChildren = metaNode.getChildNodes();
      Meta meta = new Meta(metaChildren);
      metas.add(meta);
      }
  }

  public List<Meta> getMetas() {
    return metas;
  }

  public void setMetas(List<Meta> metas) {
    this.metas = metas;
  }

  public int getCampoStatus(String estado) {
    int ret = 0;
    Image image;
    Iterator<Meta> it = metas.iterator();
    while (it.hasNext())
      {
      Meta meta = it.next();
      image = meta.getImage();
      if (image != null)
        {
        for (int i = 0; i < image.getCampos().getLength(); i++)
          {
          Campo campo = (Campo) image.getCampoByIndex(i);
          String nombreStatus = campo.getStatus();
          if (nombreStatus.equalsIgnoreCase(estado))
            {
            ret++;
            }
          }
        }
      }
    return ret;
  }

  public int getCampoStatusPorIDC(String estado, String idc) {
    int ret = 0;
    Image image;
    Iterator<Meta> it = metas.iterator();
    while (it.hasNext())
      {
      Meta meta = it.next();
      String getIdc = meta.getIdIDC();
      if (getIdc.equalsIgnoreCase(idc))
        {
        image = meta.getImage();
        if (image != null)
          {
          for (int i = 0; i < image.getCampos().getLength(); i++)
            {
            Campo campo = (Campo) image.getCampoByIndex(i);
            String nombreStatus = campo.getStatus();
            if (nombreStatus.equalsIgnoreCase(estado))
              {
              ret++;
              }
            }
          }
        }
      }
    return ret;
  }

  public int getCantidadCampos() {
    int ret = 0;
    Iterator<Meta> i = metas.iterator();
    while (i.hasNext())
      {
      Meta meta = i.next();
      Image image = meta.getImage();
      if (image != null)
        {
        ret += image.getCantidadDeCampos();
        }
      }
    return ret;
  }

  public int getCantidadCamposXIDC(String idc) {
    int ret = 0;
    Iterator<Meta> i = metas.iterator();
    while (i.hasNext())
      {
      Meta meta = i.next();
      String getidc = meta.getIdIDC();
      if (getidc.equalsIgnoreCase(idc))
        {
        Image image = meta.getImage();
        if (image != null)
          {
          ret += image.getCantidadDeCampos();
          }
        }
      }
    return ret;
  }

  public String getCamposByFilename(String filename) {
    String ret = "";
    String status = "";
    Image image;
    Iterator<Meta> it = metas.iterator();
    while (it.hasNext())
      {
      Meta meta = it.next();
      image = meta.getImage();
      if (image != null)
        {
        for (int i = 0; i < image.getCampos().getLength(); i++)
          {
          Campo campo = (Campo) image.getCampoByIndex(i);
          if (image.getCampoByName("Id Imagen").getValue().equals(filename))
            {
            status = meta.getStatus();
            ret += campo.toString();
              System.out.println(ret);
            }
          }
        }
      }
    String retEstado = "";
    retEstado = (!status.equals("")) ? "Estado; " + status + "; " : "";
    return retEstado + "\n" + ret;
  }

  public List<String> getNombresCampos() {
    return nombresCampos;
  }

  public int getCantidadValidMeta() {
    int ret = 0;
    Iterator<Meta> it = metas.iterator();
    while (it.hasNext())
      {
      Meta meta = it.next();
      if (meta != null)
        {
        boolean valido = meta.isMetaValid();
        if (valido)
          {
          ret++;
          }
        }
      }
    return ret;
  }

  public int getCantidadInvalidMeta() {
    int ret = 0;
    Iterator<Meta> it = metas.iterator();
    while (it.hasNext())
      {
      Meta meta = it.next();
      if (meta != null)
        {
        boolean invalido = meta.isMetaInvalid();
        if (invalido)
          {
          ret++;
          }
        }
      }
    return ret;
  }
}