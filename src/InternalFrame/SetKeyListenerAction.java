/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InternalFrame;

import Image.ImageComponent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;

/**
 *
 * @author aguilangeles@gmail.com
 */
class SetKeyListenerAction {

  private boolean directorio;
  private ImageComponent imageComponent;
  private JScrollPane scrollImage;
  private JComboBox combo;
  private JTree arbol;
  private JTable jTable2, jTable3;

  public SetKeyListenerAction() {
  }

  public SetKeyListenerAction(boolean directorio, ImageComponent imageComponent,
          JScrollPane scrollImage, JComboBox combo, JTree arbol, JTable jTable2, JTable jTable3) {
    this.directorio = directorio;
    this.imageComponent = imageComponent;
    this.scrollImage = scrollImage;
    this.combo = combo;
    this.arbol = arbol;
    this.jTable2 = jTable2;
    this.jTable3 = jTable3;

  }

  public KeyListener setKeyListener() {
    KeyListener kl = new KeyAdapter() {
      @Override
      public void keyTyped(KeyEvent e) {
        myKeyEvt(e, "keyTyped");
      }

      @Override
      public void keyReleased(KeyEvent e) {
        myKeyEvt(e, "keyReleased");
      }

      @Override
      public void keyPressed(KeyEvent e) {
        myKeyEvt(e, "keyPressed");
      }

      private void myKeyEvt(KeyEvent e, String text) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_KP_DOWN || key == KeyEvent.VK_DOWN)
          {
          llamarInfo();
          } else if (key == KeyEvent.VK_KP_UP || key == KeyEvent.VK_UP)
          {
          llamarInfo();
          }
      }
    };
    return kl;
  }

  private void llamarInfo() {
    if (directorio)
      {
      GetInfoForDirectoryInTree infoForDirectoryInTree =
              new GetInfoForDirectoryInTree(imageComponent, scrollImage, combo,
              arbol, jTable2, jTable3);
      } else
      {
      getInfoForIDCTree infoForIDCTree =
              new getInfoForIDCTree(imageComponent, scrollImage, combo,
              arbol, jTable2, jTable3);
      }
  }
}
