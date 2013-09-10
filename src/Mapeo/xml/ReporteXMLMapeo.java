/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeo.xml;

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
public class ReporteXMLMapeo {

  private List<MapeoList> listaMapeoLists = new ArrayList<>();
  private List<String> nombresFaces;
  private List<String> tagC1List;
  private List<String> tagC2List;
  private List<String> tagC3List;
  private List<String> tagC4List;

  public ReporteXMLMapeo(NamedNodeMap mapeoLists) {
    for (int i = 0; i < mapeoLists.getLength(); i++)
      {
      Node mapeoListNode = mapeoLists.item(i);
      NodeList mapeoChildren = mapeoListNode.getChildNodes();
      MapeoList mapeoList = new MapeoList(mapeoChildren);
      listaMapeoLists.add(mapeoList);
      }
    setValoresC();
    setNombresFaces();
  }

  private void setValoresC() {
    tagC1List = new ArrayList<>();
    tagC2List = new ArrayList<>();
    tagC3List = new ArrayList<>();
    tagC4List = new ArrayList<>();
    Iterator<MapeoList> it = listaMapeoLists.iterator();
    while (it.hasNext())
      {
      MapeoList mapeoList = it.next();
      boolean isCaratula = mapeoList.getCarat();
      if (isCaratula)
        {
        String c1 = mapeoList.getC1();
        String c2 = mapeoList.getC2();
        String c3 = mapeoList.getC3();
        String c4 = mapeoList.getC4();
        if (!c1.equals(""))
          {
          tagC1List.add(c1);
          } else if (!c2.equals(""))
          {
          tagC2List.add(c2);
          } else if (!c3.equals(""))
          {
          tagC3List.add(c3);
          } else if (!c4.equals(""))
          {
          tagC4List.add(c4);
          }
        }
      }
  }

  private void setNombresFaces() {
    nombresFaces = new ArrayList<>();
    nombresFaces.add("anverso");
    nombresFaces.add("reverso");

  }

  public List<String> getNombresFaces() {
    return nombresFaces;
  }

  public List<String> getListTagC1() {
    return tagC1List;
  }

  public List<String> getListTagC2() {
    return tagC2List;
  }

  public List<String> getListTagC3() {
    return tagC3List;
  }

  public List<String> getListTagC4() {
    return tagC4List;
  }

  public int getCantidadPorFace(String face) {
    int ret = 0;
    Iterator<MapeoList> it = this.listaMapeoLists.iterator();
    while (it.hasNext())
      {
      MapeoList mapeoList = it.next();
      ret += mapeoList.getCantidadPorFace(face);
      }
    return ret;
  }
}
