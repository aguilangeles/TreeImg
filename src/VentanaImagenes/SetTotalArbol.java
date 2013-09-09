/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaImagenes;

import helper.Mensajes;
import helper.Porcentaje;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class SetTotalArbol {

  private ImagenesTree imagenesTree;
  private int papeles,
          papValidos,
          papInvalidos,
          anversos,
          reversos,
          imagenes,
          campos,
          camposValidos,
          camposInvalidos,
          camposIB;
  private float validosPorcentaje;
  private String rutaProcesada, camposVolumen;

  public SetTotalArbol(ImagenesTree imagenesTree, int papeles, int papValidos, int papInvalidos, int anversos, int reversos, int imagenes, int campos, int camposValidos, int camposInvalidos, int camposIB, float validosPorcentaje, String rutaProcesada) {
    this.imagenesTree = imagenesTree;
    this.papeles = papeles;
    this.papValidos = papValidos;
    this.papInvalidos = papInvalidos;
    this.anversos = anversos;
    this.reversos = reversos;
    this.imagenes = imagenes;
    this.campos = campos;
    this.camposValidos = camposValidos;
    this.camposInvalidos = camposInvalidos;
    this.camposIB = camposIB;
    this.validosPorcentaje = validosPorcentaje;
    this.rutaProcesada = rutaProcesada;
    setTotalArbol(rutaProcesada);
//    setCamposVolumen(totalImgInFileSystem);
  }

  private void setTotalArbol(String rutaProcesada) {
    try
      {
      for (TotalArbol l : imagenesTree.getLista())
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
      Mensajes mensaje = new Mensajes(ruta, "El xml 'Meta' no se encuentra");
      }//fin try catch
  }

  public void setCamposVolumen(int totalImgInFileSystem) {
    Porcentaje validos = new Porcentaje(camposValidos, campos);
    Porcentaje invalido = new Porcentaje(camposInvalidos, campos);
    Porcentaje invalidoDB = new Porcentaje(camposIB, campos);
    camposVolumen = imagenes
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
  }

  public String getCamposVolumen() {
    return camposVolumen;
  }
}
