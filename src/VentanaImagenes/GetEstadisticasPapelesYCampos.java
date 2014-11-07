/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaImagenes;

import Meta.xml.ReporteXMLMetas;
import helper.Porcentaje;

/**
 *
 * @author aguilangeles@gmail.com
 */
class GetEstadisticasPapelesYCampos {

  private String estadisticas;

  public GetEstadisticasPapelesYCampos(ReporteXMLMetas reporteMeta, String statusMap,
          int imagenes, int imagenesFileSystem, String face, int papeles, String idce) {
    this.estadisticas = estadisticaPapelesYCampos(reporteMeta, statusMap, imagenes,
            imagenesFileSystem, face, papeles, idce);
  }

  private String estadisticaPapelesYCampos(ReporteXMLMetas reporteMeta, String statusMap,
          int imagenes, int imagenesFileSystem, String face, int papeles, String idce) {
    int papelesValidos = reporteMeta.getCantidadValidMeta();
    int size = reporteMeta.getCantidadCamposXIDC(idce);
    int validos = reporteMeta.getCampoStatusPorIDC("Valid", idce);
    int INvalidos = reporteMeta.getCampoStatusPorIDC("Invalid", idce);
    int InvalidDB = reporteMeta.getCampoStatusPorIDC("InvalidDB", idce);
    Porcentaje pValidos = new Porcentaje(validos, size);
    Porcentaje pInvalidos = new Porcentaje(INvalidos, size);
    Porcentaje pInvalidosDB = new Porcentaje(InvalidDB, size);
    Porcentaje porValidos = new Porcentaje(papelesValidos, papeles);
    String ret = statusMap
            + ", " + imagenes
            + ", " + imagenesFileSystem
            + ", " + face
            + ", " + papeles
            + ", " + papelesValidos
            + ", " + reporteMeta.getCantidadInvalidMeta()
            + ", " + porValidos
            + ", " + size
            + ", " + validos
            + ", " + INvalidos
            + ", " + InvalidDB
            + ", " + pValidos
            + ", " + pInvalidos
            + ", " + pInvalidosDB
            + "\n";
    return ret;
  }

  @Override
  public String toString() {
    return estadisticas;
  }
}
