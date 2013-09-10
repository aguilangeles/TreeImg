/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import txt.Escritor;

/**
 * Escribe un mensaje general si el meta no tiene contenido.
 *
 * @author MUTNPROD003
 */
public class WriteMessage {

  private Escritor informe = new Escritor("Informe_Errores.txt");
  private String ruta;
  private String mensaje;
  private String ubicacion;

  public WriteMessage(String ruta, String mensaje) {
    this.ruta = ruta;
    this.mensaje = mensaje;
    write();
  }

  private void write() {
    MensajeTxt msg = new MensajeTxt(ruta, mensaje);
    informe.salida(msg);
    ubicacion = informe.getUbicacion();
  }

  public String getUbicacion() {
    return ubicacion;
  }
}
