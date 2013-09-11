/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaImagenes;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.*;

public final class ImageComponent extends JPanel {

  private final BufferedImage img;
  private Dimension dim;

  public ImageComponent() {
    img = null;
  }

  public ImageComponent(Image image) {
    img = (BufferedImage) image;
  }

  public ImageComponent(String location, double zoom, JScrollPane scrollPane)
          throws IOException, Exception {
    img = (BufferedImage) new ReadImageTif().getImagen(location);
    setZoom(zoom, scrollPane);
  }

  @Override
  protected void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    int w_75 = (int) (img.getWidth()/4 );
    int y_75 = (int) (img.getHeight() /4);
    setPreferredSize(new Dimension(w_75, y_75));

    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.setBackground(Color.gray);

    g2.clearRect(0, 0, getWidth(), getHeight());
    g2.drawImage(img,
            0, 0, w_75, y_75, /* src area of image */
            null);
    scrollRectToVisible(new Rectangle(getPreferredSize()));
    img.flush();
    revalidate();
    repaint();
  }

  public void setZoom(double zoom, JScrollPane sp) {
    int w = (int) (1 * img.getWidth());
    int h = (int) (1 * img.getHeight());
    setPreferredSize(new Dimension(w, h));
    revalidate();
    repaint();
    sp.getViewport().revalidate();
  }
}
