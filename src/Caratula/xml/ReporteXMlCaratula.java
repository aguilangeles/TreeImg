/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Caratula.xml;

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
public class ReporteXMlCaratula {

  private List<Caratula> caratulaList = new ArrayList<>();

  public ReporteXMlCaratula() {
  }

  public ReporteXMlCaratula(NamedNodeMap caratulasNodeMap) {
    for (int i = 0; i < caratulasNodeMap.getLength(); i++)
      {
      Node caratulaNode = caratulasNodeMap.item(i);
      NodeList caratulaChildren = caratulaNode.getChildNodes();
      Caratula caratula = new Caratula(caratulaChildren);
      caratulaList.add(caratula);
      }
  }

  public boolean isEjercicio() {
    Iterator<Caratula> it = caratulaList.iterator();
    while (it.hasNext())
      {
      Caratula caratula = it.next();
      if (caratula.getDocType().equalsIgnoreCase("EJER"))
        {
        return true;
        }
      }
    return false;
  }
}
