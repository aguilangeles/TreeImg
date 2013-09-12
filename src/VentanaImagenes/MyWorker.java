/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaImagenes;

import InternalFrame.LoginRuta;
import InternalFrame.VentanaPrincipal;
import Entidades.FilesNames;
import Entidades.IDCNombre;
import helper.GetQuantityImagesInFileSystem;
import helper.DirectorioOrdenado;
import helper.WriteMessage;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author MUTNPROD003
 */
public class MyWorker extends SwingWorker<Void, Integer> {

  private LoginRuta logRuta;
  private JLabel informacion;
  private VentanaPrincipal principal2;
  private JFrame principal;
  private DefaultMutableTreeNode raizArbol;
  private boolean isDirectorio;
  //
  private static boolean escribioTXT;
  private static String noFilename;
  private static WriteMessage mensaje;
  private static SetTotalArbol setTotalArbol;
  private static String camposVolumen;
  private static DirectorioOrdenado directorio;
  private static int totalEnFileSys;
  private static ImagenesTree imagenesTree;

  public MyWorker(LoginRuta logRuta, JLabel informacion, VentanaPrincipal principal, DefaultMutableTreeNode root, boolean idrectorio, String path) {
    this.isDirectorio = idrectorio;
    this.principal2 = principal;
    this.logRuta = logRuta;
    this.raizArbol = root;
    this.informacion = informacion;
    directorio = new DirectorioOrdenado(path);
  }
  public MyWorker(boolean idrectorio, JFrame principal, LoginRuta logRuta, DefaultMutableTreeNode root, String path, JLabel informacion) {
    this.isDirectorio = idrectorio;
    this.principal = principal;
    this.logRuta = logRuta;
    this.raizArbol = root;
    this.informacion = informacion;
    directorio = new DirectorioOrdenado(path);
  }

  public MyWorker() {
  }

  @Override
  protected Void doInBackground() throws Exception {
    int imgFileSys = 0;
    int totalImgInFileSystem = 0;
    int idSede = directorio.getSede();
    SortedMap mapa = directorio.getSortedMap();
    Iterator it = mapa.keySet().iterator();
    while (it.hasNext())
      {
      Object key = it.next();
      String newPath = (String) mapa.get(key);
      informacion.setText(newPath);
      int rutaKey = (Integer) key;
      GetQuantityImagesInFileSystem quantity = new GetQuantityImagesInFileSystem(newPath, rutaKey);
      for (Map.Entry map : quantity.getListaFileSystem().entrySet())
        {
        imgFileSys = (Integer) map.getValue();
        totalEnFileSys += imgFileSys;
        }
      imagenesTree = new ImagenesTree(isDirectorio, raizArbol, newPath, escribioTXT, idSede, imgFileSys);
      setListaFiles(quantity, newPath);
      setTotalesArbol(newPath);
      }
    setCamposVolumen(getTotalEnFileSys());
    return null;
  }

  public static int getTotalEnFileSys() {
    return totalEnFileSys;
  }

  public String getCampos() {
    return camposVolumen;
  }

  @Override
  protected void done() {
    if (!isCancelled())
      {
      escribioTXT = imagenesTree.isEscrituraErrores();
      //botonVolumen.setEnabled(true);
      String finalizo = "La construcción del Arbol ha finalizado";
      String aceptar = "Aceptar para mostrar la Ventana Principal\n";
      String advertencia = (escribioTXT) ? "Datos de errores en: \n" + mensaje.getUbicacion() : "";
      JOptionPane.showMessageDialog(null, finalizo + "\n" + advertencia + "\n" + aceptar, "Proceso finalizado", JOptionPane.INFORMATION_MESSAGE);
      //TODO cambiar por un : version 1.0.03
//            JOptionPane.showConfirmDialog(principal, flag);
      logRuta.dispose();
      principal.setVisible(true);
      }
  }

  private void setTotalesArbol(String rutaProcesada) {
    setTotalArbol = new SetTotalArbol(imagenesTree, rutaProcesada);
  }

  private void setCamposVolumen(int total) {
    camposVolumen = (setTotalArbol.setCamposVolumen(total));
  }

  private void setListaFiles(GetQuantityImagesInFileSystem cantidadImg, String rutaProcesada) {
    IDCNombre idcnombre = imagenesTree.getIdcnombre();
    List<FilesNames> listaFiles = idcnombre.getListaFiles();
    List<String> listaFilenames = cantidadImg.getFilenameList();
    for (FilesNames flm : listaFiles)
      {
      String nombrefln = flm.toString();
      if (!listaFilenames.contains(nombrefln))
        {
        noFilename = (nombrefln);
        imagenesTree.setEscrituraErrores(true);
        String ruta = rutaProcesada.replace("Carat.xml", "Imagenes") + "/" + noFilename;
        mensaje = new WriteMessage(ruta, "El sistema no puede encontrar el archivo");
        }
      }
  }
}
