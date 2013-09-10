/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaImagenes;

import helper.Porcentaje;

/**
 *
 * @author aguilangeles@gmail.com
 */
class GetCamposFromMetadata {

  private String getCampos;

  public GetCamposFromMetadata(int camposSize, int getStatusValid, int getStatusInvalid,
          int getStatusInvalidDB, int validMeta, int invalidMeta, int totalPapeles,
          int imagenes, String faces) {
    this.getCampos = datosCamposMeta(camposSize, getStatusValid, getStatusInvalid,
            getStatusInvalidDB, validMeta, invalidMeta, totalPapeles, imagenes, faces);
  }


  private String datosCamposMeta(int camposSize, int getStatusValid, int getStatusInvalid,
          int getStatusInvalidDB, int validMeta, int invalidMeta, int totalPapeles,
          int imagenes, String faces) {
    Porcentaje porcentajeValid = new Porcentaje(getStatusValid, camposSize);
    Porcentaje porcentajeINValid = new Porcentaje(getStatusInvalid, camposSize);
    Porcentaje porcentajeINValidDB = new Porcentaje(getStatusInvalidDB, camposSize);
    String ret = totalPapeles
            + ", " + imagenes
            + ", " + faces
            + ", " + validMeta
            + ", " + invalidMeta
            + ", " + camposSize
            + ", " + getStatusValid
            + ", " + getStatusInvalid
            + ", " + getStatusInvalidDB
            + ", " + porcentajeValid
            + ", " + porcentajeINValid
            + ", " + porcentajeINValidDB
            + "\n";
    return ret;
  }
  public String getGetCampos() {
    return getCampos;
  }

  @Override
  public String toString() {
    return  getCampos ;
  }


}
