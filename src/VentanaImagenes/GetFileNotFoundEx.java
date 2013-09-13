/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaImagenes;

import Image.ReadImageTif;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import helper.WriteMessage;

/**
 * Si la imagen no existe, llama a esta clase para escribir en el log y mostrar
 * una imagen recursiva
 *
 * @author aguilangeles@gmail.com
 */
public class GetFileNotFoundEx {

//  private static Escritor escritor = new Escritor("noImagen.txt");
  public GetFileNotFoundEx() {
  }

  public GetFileNotFoundEx(String mensajeException, String descripcion) {
    escribirLog(mensajeException, descripcion);
  }

  private void escribirLog(String mensajeException, String descripcion) {
    String path = mensajeException.substring(0, mensajeException.length() - descripcion.length());
    WriteMessage wm = new WriteMessage();
    wm.writeNewLog("noImagen.txt", path, descripcion);
  }

  public BufferedImage fileNotFoundImage() {
    BufferedImage image = null;
    try
      {
      image = (BufferedImage) new ReadImageTif().getImagen("ImagenNoEncontrada.tif");
      } catch (FileNotFoundException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(), "Imagen recursiva no encontrada", JOptionPane.ERROR_MESSAGE);
      Logger.getLogger(GetFileNotFoundEx.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(), "Error GetFileNotFound ", JOptionPane.ERROR_MESSAGE);
      Logger.getLogger(GetFileNotFoundEx.class.getName()).log(Level.SEVERE, null, ex);
      }
    return image;
  }
}
