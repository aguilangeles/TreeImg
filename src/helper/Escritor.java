/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class Escritor {

  private File file;
  private String output;

  public Escritor(String output) {
    this.output = output;
  }

  public void salida(MensajeTxt mesage)  {
    file = new File(output);

    FileWriter out = null;
    PrintWriter pw = null;
    try
      {
      out = new FileWriter(file,true);
      pw = new PrintWriter(out);
      pw.println("Fecha: " + mesage.getFecha());
      pw.println("Ruta: " + mesage.getRuta());
      pw.println("Descripcion: " + mesage.getDescripcion());
      pw.println("\n");
      pw.flush();
      } catch (IOException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage());
      } finally
      {
      if (null != out)
        {
        try
          {
          out.close();
          pw.close();
          } catch (IOException e)
          {
          JOptionPane.showMessageDialog(null, e.getMessage(), "Error al cerrar archivo txt", JOptionPane.ERROR_MESSAGE);
          }
        }
      }
  }

  public String getUbicacion() {
    return file.getAbsolutePath();
  }
}
