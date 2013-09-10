/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaImagenes;

import Entidades.XmlMapeo;
import Meta.MetaParser;
import Entidades.ReporteXMLMapeo;
import Meta.ReporteXMLMetas;
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

  public Metadata(XmlMapeo xmlMapeo, ReporteXMLMapeo reporteMapeo, String nombre,
          int imagenesFileSystem, String idce, boolean isEjercicio) throws SAXException, IOException {
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
      this.datos_Campos_Meta =
              new GetCamposFromMetadata(camposSize, getStatusValid,
              getStatusInvalid, getStatusInvalidDB, validMeta, invalidMeta,
              totalPapeles, imagenes, faces).toString();
      } else
      {
      this.reporteMeta = null;
      }
    this.estadisticasPapelesyCampos = new GetEstadisticasPapelesYCampos(reporteMeta, status,
            imagenes, imagenesFileSystem, faces, totalPapeles, idce).toString();
  }

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
