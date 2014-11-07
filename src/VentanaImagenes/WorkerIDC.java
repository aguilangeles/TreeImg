/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaImagenes;

import InternalFrame.LoginRuta;
import Entidades.FilesNames;
import Entidades.IDCNombre;
import helper.GetQuantityImagesInFileSystem;
import helper.WriteMessage;
import java.io.File;
import java.io.FileFilter;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author MUTNPROD003
 */
public class WorkerIDC extends SwingWorker<Void, Integer> {

  private boolean isDirectorio;
  private LoginRuta input;
  private JLabel informacion;
  private JFrame secundario;
  private DefaultMutableTreeNode root;
  private String pathIDC;
  private static ImagenesTree imagenes;
  private static WriteMessage mensajes;
  private static String path;

  public WorkerIDC(boolean isDirectorio, JFrame secundario, LoginRuta input,
          DefaultMutableTreeNode root, String pathIdc, JLabel informacion) {
    this.isDirectorio = isDirectorio;
    this.secundario = secundario;
    this.input = input;
    this.root = root;
    this.pathIDC = pathIdc;
    this.informacion = informacion;
  }

  public WorkerIDC() {
  }

  @Override
  protected Void doInBackground() {
    int totalImagesFileSystem;
    GetQuantityImagesInFileSystem quantityFlSys;
    int contador = 0;
    File folder = new File(pathIDC);
    FileFilter filefilter = new FileFilter() {
      @Override
      public boolean accept(File file) {
        return file.isFile();
      }
    };
    File[] dirs = folder.listFiles(filefilter);
    if (dirs != null)
      {
      for (File files : dirs)
        {
        path = files.getPath();
        if (path.endsWith("Carat.xml"))
          {
          contador++;
          quantityFlSys = new GetQuantityImagesInFileSystem(path, contador);//cantidad imagenes filesystem
          String reemplazo = path.replace("#", "%23");
          totalImagesFileSystem = (quantityFlSys.getListaFileSystem().get(contador));

          imagenes = new ImagenesTree(isDirectorio, root, reemplazo, totalImagesFileSystem);//borrar todo lo de Escritor txt

          IDCNombre idcnombre = imagenes.getIdcnombre();

          List<FilesNames> lista = idcnombre.getListaFiles();
          setListaFiles(quantityFlSys, lista, reemplazo);
          }
        }
      }
    return null;
  }

  @Override
  protected void done() {
    if (!isCancelled())
      {
      boolean escribioTXT = imagenes.isEscrituraErrores();
      FindeProceso findeProceso = new FindeProceso(escribioTXT, mensajes);
      input.dispose();
      secundario.setVisible(true);
      }
  }

  private void setListaFiles(GetQuantityImagesInFileSystem quantityFlSys, List<FilesNames> lista, String reemplazo) {
    List<String> listaFiles = quantityFlSys.getFilenameList();
    for (FilesNames filesnames : lista)
      {
      String nombreFile = filesnames.toString();
      if (!listaFiles.contains(nombreFile))
        {
          {
          String fileNotFound = nombreFile;
          imagenes.setEscrituraErrores(true);
          String ruta = reemplazo.replace("Carat.xml", "Imagenes/") + fileNotFound;
          mensajes = new WriteMessage(ruta, "El sistema no encontro el archivo en el Idc ");
          }
        } else
        {
        informacion.setText(nombreFile);

        }
      }//for
  }
}
