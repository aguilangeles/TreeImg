/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import VentanaImagenes.ImageComponent;
import VentanaImagenes.tablaMetadata;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import txt.Escritor;

/**
 *
 * @author MUTNPROD003
 */
public final class ImagenNoEncontrada {

  private JScrollPane scrollImage;
  private JSlider jSlider1;
  private int zoomImage;
  private JTable tablaMetadata1;
  private MensajeTxt mensaje;

  public ImagenNoEncontrada(MensajeTxt mstxt, final JScrollPane scrollImage, final JSlider jSlider1, int zoomImage, JTable tablaMetadata1) {
    this.mensaje = mstxt;
    this.jSlider1 = jSlider1;
    this.zoomImage = zoomImage;
    this.scrollImage = scrollImage;
    this.tablaMetadata1 = tablaMetadata1;
    try
      {
      final ImageComponent imageCmp = new ImageComponent("ImagenNoEncontrada.tif", 2. * getZoomImage() / jSlider1.getMaximum(), scrollImage);
      scrollImage.getViewport().add(imageCmp);
      jSlider1.setValue(zoomImage);
      jSlider1.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
          setZoomImage(jSlider1.getValue());
          imageCmp.setZoom(2. * getZoomImage() / jSlider1.getMaximum(), scrollImage);
        }
      });
      tablaMetadata tablaM = new tablaMetadata(tablaMetadata1, "");
      } catch (IOException ex)
      {
      Logger.getLogger(ImagenNoEncontrada.class.getName()).log(Level.SEVERE, null, ex);
      } catch (Exception ex)
      {
      Logger.getLogger(ImagenNoEncontrada.class.getName()).log(Level.SEVERE, null, ex);
      }
    escribirLog();
  }

  private void escribirLog() {
    try
      {
      Escritor escritor = new Escritor("noImagen.txt");
      escritor.salida(mensaje);
      } catch (IOException ex)
      {
      Logger.getLogger(ImagenNoEncontrada.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

  public int getZoomImage() {
    return zoomImage;
  }

  public void setZoomImage(int zoomImage) {
    this.zoomImage = zoomImage;
  }
}
