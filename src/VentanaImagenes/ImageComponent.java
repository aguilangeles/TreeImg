/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaImagenes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.*;

public final class ImageComponent extends JPanel {

  private  BufferedImage img;
  private Dimension dim;
  private int zomm;
  private int opIndex;

  public ImageComponent() {
    img = null;
  }

  public ImageComponent(Image image) {
    img = (BufferedImage) image;
  }

  public ImageComponent(BufferedImage img) {
    this.img = img;
  }

  public ImageComponent(String location, double zoom, JScrollPane scrollPane)
          throws IOException, Exception {
    img = (BufferedImage) new ReadImageTif().getImagen(location);
    //setZoom(zoom, scrollPane);
  }

  public void setOpIndex(int opIndex) {
    this.opIndex = opIndex;
  }

//  public ImageComponent(String location, int zoom, JScrollPane scrollPane)
//          throws IOException, Exception {
//    this.zomm = zoom;
//    img = (BufferedImage) new ReadImageTif().getImagen(location);
//    //setZoom(zoom, scrollPane);
//  }



  public void cargarImagen(String location, final JComboBox combo, JScrollPane scrollPane)
          throws IOException, Exception {
    img = (BufferedImage) new ReadImageTif().getImagen(location);
    combo.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setOpIndex(combo.getSelectedIndex());
      }
    });
  }
//  public ImageComponent(String location, final JComboBox combo, JScrollPane scrollPane)
//          throws IOException, Exception {
//    combo.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        setOpIndex(combo.getSelectedIndex());
//      }
//    });
//    img = (BufferedImage) new ReadImageTif().getImagen(location);
//    //setZoom(zoom, scrollPane);
//  }

  @Override
  protected void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    switch (opIndex)
      {
      case 0:
        setImageOrininal(g2);
        break;
      case 1:
        setImageVisibleInScroll(g2);
        break;
      case 2:
        setImageHalfSize(g2);
        break;
      default:
        setImageFourthSize(g2);
        break;
      }
  }
//  @Override
//  protected void paintComponent(Graphics g) {
//    Graphics2D g2 = (Graphics2D) g;
//    int w_75 = (int) (img.getWidth() / zomm);
//    int y_75 = (int) (img.getHeight() / zomm);
//    setPreferredSize(new Dimension(w_75, y_75));
//    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
//            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//    g2.setBackground(Color.gray);
//
//    g2.clearRect(0, 0, getWidth(), getHeight());
//    g2.drawImage(img,
//            0, 0, w_75, y_75, /* src area of image */
//            null);
//    scrollRectToVisible(new Rectangle(getPreferredSize()));
//    img.flush();
//    revalidate();
//    repaint();
//  }

  public void setZoom(double zoom, JScrollPane sp) {
    int w = (int) (1 * img.getWidth());
    int h = (int) (1 * img.getHeight());
    setPreferredSize(new Dimension(w, h));
    revalidate();
    repaint();
    sp.getViewport().revalidate();
  }

  private void setImageOrininal(Graphics2D g2) {
    int Woriginal = (int) (img.getWidth());
    int Horiginal = (int) (img.getHeight());
    setPreferredSize(new Dimension(Woriginal, Horiginal));
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.setBackground(Color.gray);

    g2.clearRect(0, 0, getWidth(), getHeight());
    g2.drawImage(img,
            0, 0, Woriginal, Horiginal, /* src area of image */
            null);
    scrollRectToVisible(new Rectangle(getPreferredSize()));
    img.flush();
    revalidate();
    repaint();
  }

  private void setImageVisibleInScroll(Graphics2D g2) {
    int WScroll = (int) (img.getWidth() / 2);
    int hScroll = (int) (img.getHeight() / 2);
    setPreferredSize(new Dimension(WScroll, hScroll));
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.setBackground(Color.gray);

    g2.clearRect(0, 0, getWidth(), getHeight());
    g2.drawImage(img,
            0, 0, WScroll, hScroll, /* src area of image */
            null);
    scrollRectToVisible(new Rectangle(getPreferredSize()));
    img.flush();
    revalidate();
    repaint();

  }

  private void setImageHalfSize(Graphics2D g2) {
    int wHalf = (int) (img.getWidth() / 4);
    int hHalf = (int) (img.getHeight() / 4);
    setPreferredSize(new Dimension(wHalf, hHalf));
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.setBackground(Color.gray);

    g2.clearRect(0, 0, getWidth(), getHeight());
    g2.drawImage(img,
            0, 0, wHalf, hHalf, /* src area of image */
            null);
    scrollRectToVisible(new Rectangle(getPreferredSize()));
    img.flush();
    revalidate();
    repaint();
  }

  private void setImageFourthSize(Graphics2D g2) {
 int wHalf = (int) (img.getWidth() / 6);
    int hHalf = (int) (img.getHeight() / 6);
    setPreferredSize(new Dimension(wHalf, hHalf));
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.setBackground(Color.gray);

    g2.clearRect(0, 0, getWidth(), getHeight());
    g2.drawImage(img,
            0, 0, wHalf, hHalf, /* src area of image */
            null);
    scrollRectToVisible(new Rectangle(getPreferredSize()));
    img.flush();
    revalidate();
    repaint();
  }
}
