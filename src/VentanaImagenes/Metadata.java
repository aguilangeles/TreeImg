/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaImagenes;

import Parser.MetaParser;
import Parser.ReporteXMLMetas;
import helper.Porcentaje;
import java.io.IOException;
import org.xml.sax.SAXException;

/**
 *
 * @author MUTNPROD003
 */
public class Metadata {
    //

    private String estadisticasPapelesyCampos = "";
    private String ruta;
    private MetaParser metaParser;
    private ReporteXMLMetas reporteMeta;
    private String datos_Campos_Meta;

    public Metadata(String nombre, String statusMap, int imagenes,
            int imagenesFileSystem, String face, int papeles, String idce) throws SAXException, IOException {
        this.ruta = nombre.replace("Carat.xml", "Meta.xml");
        this.metaParser = new MetaParser(ruta);
        if (metaParser != null) {
            this.reporteMeta = metaParser.getReporte();
            int camposSize = reporteMeta.getCantidadCampos();
            int getStatusValid = reporteMeta.getCampoStatus("Valid");
            int getStatusInvalid = reporteMeta.getCampoStatus("Invalid");
            int getStatusInvalidDB = reporteMeta.getCampoStatus("InvalidDB");
            int validMeta = reporteMeta.getCantidadValidMeta();
            int invalidMeta = reporteMeta.getCantidadInvalidMeta();
            datosCamposMeta(camposSize, getStatusValid, getStatusInvalid, getStatusInvalidDB, validMeta, invalidMeta);
        } else {
            this.reporteMeta = null;
        }
        estadisticaPapelesYCampos(reporteMeta, statusMap, imagenes, imagenesFileSystem, face, papeles, idce);
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

    private void datosCamposMeta(int camposSize, int getStatusValid, int getStatusInvalid, int getStatusInvalidDB, int validMeta, int invalidMeta) {
        Porcentaje porcentajeValid = new Porcentaje(getStatusValid, camposSize);
        Porcentaje porcentajeINValid = new Porcentaje(getStatusInvalid, camposSize);
        Porcentaje porcentajeINValidDB = new Porcentaje(getStatusInvalidDB, camposSize);
        datos_Campos_Meta = validMeta
                + ", " + invalidMeta
                + ", " + camposSize
                + ", " + getStatusValid
                + ", " + getStatusInvalid
                + ", " + getStatusInvalidDB
                + ", " + porcentajeValid
                + ", " + porcentajeINValid
                + ", " + porcentajeINValidDB
                + "\n";
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
