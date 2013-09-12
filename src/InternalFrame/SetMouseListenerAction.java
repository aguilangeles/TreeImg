/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InternalFrame;

import VentanaImagenes.ImageComponent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;

/**
 *
 * @author aguilangeles@gmail.com
 */
class SetMouseListenerAction {

  private boolean directorio;
  private ImageComponent imageComponent;
  private JScrollPane scrollImage;
  private JComboBox combo;
  private JTree arbol;
  private JTable jTable2, jTable3;

  public SetMouseListenerAction() {
  }

  public SetMouseListenerAction(boolean directorio, ImageComponent imageComponent, JScrollPane scrollImage, JComboBox combo, JTree arbol, JTable jTable2, JTable jTable3) {
    this.directorio = directorio;
    this.imageComponent = imageComponent;
    this.scrollImage = scrollImage;
    this.combo = combo;
    this.arbol = arbol;
    this.jTable2 = jTable2;
    this.jTable3 = jTable3;
    addMSL();
  }

  private void addMSL() {
    MouseListener ml = new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        llamarInfo();
      }
    };
    arbol.addMouseListener(ml);
  }

  private void llamarInfo() {
    if (directorio)
      {
      new GetInfoForDirectoryInTree(imageComponent, scrollImage, combo, arbol, jTable2, jTable3);
      //llama a la construcion de arbol directorio
      } else
      {
      // llama a
      new getInfoForIDCTree(imageComponent, scrollImage, combo, arbol, jTable2, jTable3);
      }
  }
}
