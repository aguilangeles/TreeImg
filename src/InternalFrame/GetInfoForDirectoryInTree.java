/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InternalFrame;

import Entidades.ContenidoTablaIDC;
import Entidades.Tif;
import Image.ImageComponent;
import Tablas.SetTablaMetadata;
import Tablas.SetTablaForIDC;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author aguilangeles@gmail.com
 */
class GetInfoForDirectoryInTree {

  private boolean directorio;
  private ImageComponent imageComponent;
  private JScrollPane scrollImage;
  private JComboBox combo;
  private JTree arbol;
  private JTable jTable2, jTable3;

  public GetInfoForDirectoryInTree() {
  }

  public GetInfoForDirectoryInTree(ImageComponent imageComponent, JScrollPane scrollImage, JComboBox combo, JTree arbol, JTable jTable2, JTable jTable3) {
    this.imageComponent = imageComponent;
    this.scrollImage = scrollImage;
    this.combo = combo;
    this.arbol = arbol;
    this.jTable2 = jTable2;
    this.jTable3 = jTable3;
    mostrarInfoDirectorioEnArbol();
  }

  private void mostrarInfoDirectorioEnArbol() {
    TreePath treePath = arbol.getSelectionPath();
    if (treePath != null)
      {
      DefaultMutableTreeNode nodoSeleccionado = (DefaultMutableTreeNode) arbol.getLastSelectedPathComponent();
      if (nodoSeleccionado.toString().contains("#"))
        {
        ContenidoTablaIDC contenido = (ContenidoTablaIDC) nodoSeleccionado.getUserObject();
        SetTablaForIDC idcTable = new SetTablaForIDC(jTable3, contenido.getCampos());
        } else if (nodoSeleccionado.toString().endsWith(".tif"))
        {
        Tif tif = (Tif) nodoSeleccionado.getUserObject();
        String imagen = tif.getRuta();
        if (imagen != null)
          {
          setImage(imagen);
          }//
        SetTablaMetadata tablaM = new SetTablaMetadata(jTable2, tif.getMetadata());
        }
      }
  }

  private void setImage(String imagen) {
    imageComponent.cargarImagen(imagen, combo, scrollImage);
    scrollImage.getViewport().add(imageComponent);
  }
}
