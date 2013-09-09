/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import txt.Escritor;

/**
 *
 * @author MUTNPROD003
 */
public class Mensajes {

  private Escritor informe = new Escritor("Informe_Errores.txt");
  private String ruta;
  private String mensaje;
  private String ubicacion;

  public Mensajes(String ruta, String mensaje) {
    this.ruta = ruta;
    this.mensaje = mensaje;
    resultado();
  }

  private void resultado() {
    try
      {
      informe.salida(ruta + "\t" + mensaje + "\t" + fecha() + "\n");
      ubicacion = informe.getUbicacion();

      } catch (IOException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en la escritura del informe", JOptionPane.ERROR_MESSAGE);
//            Logger.getLogger(Mensajes.class.getName()).log(Level.SEVERE, null, ex);
      }

  }

  private String fecha() {
    String fecha = "";
    SimpleDateFormat format = new SimpleDateFormat("dd'-'MM'-'yyyy HH:mm", Locale.ENGLISH);
    Date date = new Date();
    fecha = format.format(date);
    return fecha;
  }

  public String getUbicacion() {
    return ubicacion;
  }
}
