/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaImagenes;

import helper.WriteMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
final class FindeProceso {

  private static final String FIN = "La construcción del Arbol ha finalizado";
  private boolean log;
  private WriteMessage mensaje;

  public FindeProceso() {
  }

  public FindeProceso(boolean log, WriteMessage mensaje) {
    this.log = log;
    this.mensaje = mensaje;
    joptionPane();
  }

  void joptionPane() {
    String infoLog = (log) ? "Datos de errores en: \n" + mensaje.getUbicacion() : "Sin reporte de Errores";
    JOptionPane.showMessageDialog(null, infoLog, FIN, JOptionPane.INFORMATION_MESSAGE);
  }
}
