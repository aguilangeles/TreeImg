/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaImagenes;

import Parser.ReporteXMLMapeo;
import java.util.List;

/**
 * Devuelve un string de los anversos y reversos con su respectiva cantidad
 * @author Administrador
 */
public class FaceMapeo {

  private String faceName = "";

  public FaceMapeo() {
  }

  public FaceMapeo(ReporteXMLMapeo reporteMapeo) {
    List<String> anversoReversoList = reporteMapeo.getNombresFaces();
    for (int i = 0; i < anversoReversoList.size(); i++)
      {
      String caras = anversoReversoList.get(i).trim();
      int cantidad = reporteMapeo.getCantidadPorFace(caras);
      this.faceName += cantidad + ", ";
      }
  }

  @Override
  public String toString() {
    String[] ret = faceName.split(", ");
    String anverso = "";
    String reverso = "";
    for (int i = 0; i < ret.length; i++)
      {
      anverso = ret[0];
      reverso = ret[1];
      }
    return anverso + ", " + reverso;
  }
}
