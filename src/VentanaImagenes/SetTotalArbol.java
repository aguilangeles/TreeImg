/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaImagenes;

import helper.WriteMessage;
import helper.Porcentaje;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class SetTotalArbol {

  private static int papeles,
          papValidos,
          papInvalidos,
          anversos,
          reversos,
          imagenes,
          campos,
          camposValidos,
          camposInvalidos,
          camposIB;
  private static float validosPorcentaje;
  private String rutaProcesada;
//  private static String camposVolumen;

  public SetTotalArbol(ImagenesTree imagen, String rutaString) {
    setTotalArbol(imagen, rutaString);
  }

  private void setTotalArbol(ImagenesTree imagen, String rutaProcesada) {
    try
      {
      for (TotalesArbol l : imagen.getLista())
        {
        papeles += l.getPapeles();
        papValidos += l.getP_validos();
        papInvalidos += l.getP_invalidos();
        float porcentajeVlidos = 0;
        porcentajeVlidos += (float) papValidos * 100 / (float) papeles;
        boolean isNan = Float.isNaN(porcentajeVlidos);
        validosPorcentaje = (!isNan) ? porcentajeVlidos : 0;
        anversos += l.getAnversos();
        reversos += l.getReversos();
        imagenes += l.getImagenes();
        campos += l.getCampos();
        camposValidos += l.getC_valid();
        camposInvalidos += l.getC_invalid();
        camposIB += l.getC_invalidDB();
        }//fin for total arbol
      } catch (Exception l)
      {
      String ruta = rutaProcesada.replace("/Carat.xml", "");
      WriteMessage mensaje = new WriteMessage(ruta, "El xml 'Meta' no se encuentra");
      }//fin try catch
  }

  public SetTotalArbol() {
  }

  public String setCamposVolumen(int totalImgInFileSystem) {
    Porcentaje validos = new Porcentaje(camposValidos, campos);
    Porcentaje invalido = new Porcentaje(camposInvalidos, campos);
    Porcentaje invalidoDB = new Porcentaje(camposIB, campos);
    String ret = imagenes
            + ", " + totalImgInFileSystem
            + ", " + anversos
            + ", " + reversos
            + ", " + papeles
            + ", " + papValidos
            + ", " + papInvalidos
            + ", " + validosPorcentaje
            + ", " + campos
            + ", " + camposValidos
            + ", " + camposInvalidos
            + ", " + camposIB
            + ", " + validos
            + ", " + invalido
            + ", " + invalidoDB
            + "\n";
    return ret;
  }



}
