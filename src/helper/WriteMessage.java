/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 * Escribe un mensaje general si el meta no tiene contenido.
 *
 * @author MUTNPROD003
 */
public class WriteMessage {
  private String ruta;
  private String mensaje;
  private String ubicacion;


  public WriteMessage(String ruta, String mensaje) {
    this.ruta = ruta;
    this.mensaje = mensaje;
    Escritor informe = new Escritor("Describe_errores.txt");
    write(informe);
  }

  public WriteMessage() {
  }


  private void write(Escritor informe) {
    MensajeTxt msg = new MensajeTxt(ruta, mensaje);
    informe.salida(msg);
    ubicacion = informe.getUbicacion();
  }

  public void writeNewLog(String pathFile,String ruta, String mensaje) {
    Escritor escritor = new Escritor(pathFile);
    MensajeTxt msg = new MensajeTxt(ruta, mensaje);
    escritor.salida(msg);
    ubicacion = escritor.getUbicacion();

  }

  public String getUbicacion() {
    return ubicacion;
  }
}
