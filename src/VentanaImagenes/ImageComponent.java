/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaImagenes;

import helper.MensajeTxt;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import txt.Escritor;

public final class ImageComponent extends JPanel {

  private BufferedImage img;
  private Dimension dim;
  private int zomm;
  private int opIndex;

  public ImageComponent() {
    img = null;
  }

  public void setOpIndex(int opIndex) {
    this.opIndex = opIndex;
  }

  public void cargarImagen(String location, final JComboBox combo, JScrollPane scrollPane) {
    try
      {
      img = (BufferedImage) new ReadImageTif().getImagen(location);
      combo.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          setOpIndex(combo.getSelectedIndex());
        }
      });
      } catch (FileNotFoundException ex)
      {
      String descripcion = "(El sistema no puede encontrar el archivo especificado)";
      if (ex.getMessage().contains(descripcion))
        {
        GetFileNotFoundEx fileNotFoundEx = new GetFileNotFoundEx(ex.getMessage(), descripcion);
        img = fileNotFoundEx.fileNotFoundImage();
        } else
        {
        JOptionPane.showMessageDialog(scrollPane, ex.getMessage(), "Error en lectura imagen ", JOptionPane.ERROR_MESSAGE);
        }
      } catch (IOException ex)
      {
      JOptionPane.showMessageDialog(scrollPane, ex.getMessage(), "Error en lectura IO imagen ", JOptionPane.ERROR_MESSAGE);
      }
  }

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
