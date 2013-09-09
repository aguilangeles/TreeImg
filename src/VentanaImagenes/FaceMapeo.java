/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaImagenes;

import Parser.ReporteXMLMapeo;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class FaceMapeo {
    private String faceName = "";
    public FaceMapeo(ReporteXMLMapeo reporteMapeo) {
        List<String> listaFace = reporteMapeo.getNombresFaces();
        for (int i = 0; i < listaFace.size(); i++) {
            String face = listaFace.get(i).trim();
            int cantidad = reporteMapeo.getCantidadPorFace(face);
            this.faceName += cantidad + ", ";
        }
    }

    public FaceMapeo() {
    }

    @Override
    public String toString() {
        String[] ret = faceName.split(", ");
        String anverso = "";
        String reverso = "";
        for (int i = 0; i < ret.length; i++) {
            anverso = ret[0];
            reverso = ret[1];
        }
        return anverso + ", " + reverso;
    }
}
