/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaImagenes;

import Entidades.XmlMapeo;
import Parser.MetaParser;
import Parser.ReporteXMLMapeo;
import Parser.ReporteXMLMetas;
import helper.Porcentaje;
import java.io.IOException;
import org.xml.sax.SAXException;

/**
 *
 * @author MUTNPROD003
 */
public class Metadata {

  private String estadisticasPapelesyCampos = "";
  private String ruta;
  private MetaParser metaParser;
  private ReporteXMLMetas reporteMeta;
  private String datos_Campos_Meta;

  public Metadata(String nombre, int imagenesFileSystem, String idce, XmlMapeo xmlMapeo, boolean isEjercicio, ReporteXMLMapeo reporteMapeo) throws SAXException, IOException {

    String status = xmlMapeo.getStatus();
    int imagenes = xmlMapeo.getCantidadImagenes();
    String faces = new FaceMapeo(reporteMapeo).toString();
    int totalPapeles = (!isEjercicio) ? xmlMapeo.cantidadPapeles() : 0;
    this.ruta = nombre.replace("Carat.xml", "Meta.xml");
    this.metaParser = new MetaParser(ruta);
    if (metaParser != null)
      {
      this.reporteMeta = metaParser.getReporte();
      int camposSize = reporteMeta.getCantidadCampos();
      int getStatusValid = reporteMeta.getCampoStatus("Valid");
      int getStatusInvalid = reporteMeta.getCampoStatus("Invalid");
      int getStatusInvalidDB = reporteMeta.getCampoStatus("InvalidDB");
      int validMeta = reporteMeta.getCantidadValidMeta();
      int invalidMeta = reporteMeta.getCantidadInvalidMeta();
      this.datos_Campos_Meta = datosCamposMeta(camposSize, getStatusValid, getStatusInvalid, getStatusInvalidDB, validMeta, invalidMeta, totalPapeles, imagenes, faces);
      } else
      {
      this.reporteMeta = null;
      }
    estadisticaPapelesYCampos(reporteMeta, status, imagenes, imagenesFileSystem, faces, totalPapeles, idce);
  }

  private void estadisticaPapelesYCampos(ReporteXMLMetas reporteMeta, String statusMap,
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
    estadisticasPapelesyCampos = statusMap
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

  }

  private String datosCamposMeta(int camposSize, int getStatusValid, int getStatusInvalid,
          int getStatusInvalidDB, int validMeta, int invalidMeta, int totalPapeles,
          int imagenes, String faces) {
    String campos = new GetCamposFromMetadata(camposSize, getStatusValid,
            getStatusInvalid, getStatusInvalidDB, validMeta, invalidMeta,
            totalPapeles, imagenes, faces).toString();
    return campos;
  }
//////////////////////////////////////////

  public String getEstadisticasPapelesyCampos() {
    return estadisticasPapelesyCampos;
  }

  public String getDatos_Campos_Meta() {
    return datos_Campos_Meta;
  }

  public String getEstadoyMetadata(String fileName) {
    return reporteMeta.getCamposByFilename(fileName);
  }
}
