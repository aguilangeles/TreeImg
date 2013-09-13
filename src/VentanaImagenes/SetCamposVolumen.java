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
public class SetCamposVolumen {

  private String camposVolumen;
  private int img,
          an,
          rev,
          papeles,
          ppV,
          ppI,
          cm,
          cmV,
          cmI,
          cmIB;
  private float validosPorcentaje;

  public SetCamposVolumen(String camposVolumen, int img, int an, int rev, int papeles, int ppV, int ppI, int cm, int cmV, int cmI, int cmIB, float validosPorcentaje, int totalImgInFileSystem) {
    this.camposVolumen = camposVolumen;
    this.img = img;
    this.an = an;
    this.rev = rev;
    this.papeles = papeles;
    this.ppV = ppV;
    this.ppI = ppI;
    this.cm = cm;
    this.cmV = cmV;
    this.cmI = cmI;
    this.cmIB = cmIB;
    this.validosPorcentaje = validosPorcentaje;
    setCamposVolumen(totalImgInFileSystem);
  }

  private void setCamposVolumen(int totalImgInFileSystem) {
    Porcentaje validos = new Porcentaje(cmV, cm);
    Porcentaje invalido = new Porcentaje(cmI, cm);
    Porcentaje invalidoDB = new Porcentaje(cmIB, cm);
    camposVolumen = img
            + ", " + totalImgInFileSystem
            + ", " + an
            + ", " + rev
            + ", " + papeles
            + ", " + ppV
            + ", " + ppI
            + ", " + validosPorcentaje
            + ", " + cm
            + ", " + cmV
            + ", " + cmI
            + ", " + cmIB
            + ", " + validos
            + ", " + invalido
            + ", " + invalidoDB
            + "\n";
  }
}
