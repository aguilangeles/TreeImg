/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaImagenes;

import InternalFrame.InputRuta;
import InternalFrame.VentanaPrincipal;
import Recursos.FilesNames;
import Recursos.IDCNombre;
import helper.GetQuantityImagesInFileSystem;
import helper.DirectorioOrdenado;
import helper.Mensajes;
import helper.Porcentaje;
import java.io.File;
import java.io.FileFilter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author MUTNPROD003
 */
public class MyWorker extends SwingWorker<Void, Integer> {

  private boolean escribioTXT;
  private DefaultMutableTreeNode raizArbol;
  private boolean isDirectorio;
  private VentanaPrincipal principal;
  private InputRuta frameInput;
  private JButton botonVolumen;
  private String camposVolumen;
  private Porcentaje porcentaje;
  private String noImagen;
  private File file;
  private FileFilter fileFilter;
  private int img = 0, papeles = 0, ppV = 0, ppI = 0, an = 0, rev = 0, cm = 0,
          cmV = 0, cmI = 0, cmIB = 0;
  private float validosPorcentaje;
  private String noFilename;
  private ImagenesTree imagenes;
  private IDCNombre idcnombre;
  private Mensajes mensaje;
  private String txtUbicacion;
  private JLabel informacion;
  private static DirectorioOrdenado directorio;

  public MyWorker(boolean valor, VentanaPrincipal principal, InputRuta input, DefaultMutableTreeNode root, String rutaInput, File dir, FileFilter fileFilter, JButton botonVolumen, String noImagen, javax.swing.JLabel informacion) {
    this.isDirectorio = valor;
    this.principal = principal;
    this.frameInput = input;
    this.raizArbol = root;
    this.file = dir;
    this.fileFilter = fileFilter;
    this.botonVolumen = botonVolumen;
    this.noImagen = noImagen;
    this.informacion = informacion;
    directorio = new DirectorioOrdenado(rutaInput);
  }

  public MyWorker() {
  }

  @Override
  protected Void doInBackground() throws Exception {
    int p = 0;
    int totFS = 0;
    int sede = directorio.getSede();
    SortedMap mapa = directorio.getSortedMap();
    Iterator it = mapa.keySet().iterator();
    while (it.hasNext())
      {
      Object key = it.next();
      String rutaProcesada = (String) mapa.get(key);
      informacion.setText(rutaProcesada);
      int r = (Integer) key;
      GetQuantityImagesInFileSystem ci = new GetQuantityImagesInFileSystem(rutaProcesada, r);
      for (Map.Entry l : ci.getListaFileSystem().entrySet())
        {
        p = (Integer) l.getValue();
        totFS += p;
        }

      imagenes = new ImagenesTree(isDirectorio, raizArbol, rutaProcesada, escribioTXT, sede, p);
      idcnombre = imagenes.getIdcnombre();
      List<FilesNames> lista = idcnombre.getListaFiles();
      List<String> listaF = ci.getFilenameList();
      for (FilesNames flm : lista)
        {
        String nombrefln = flm.toString();
        if (!listaF.contains(nombrefln))
          {
          noFilename = (nombrefln);
          imagenes.setEscrituraErrores(true);
          String ruta = rutaProcesada.replace("Carat.xml", "Imagenes") + "/" + noFilename;
          mensaje = new Mensajes(ruta, "El sistema no puede encontrar el archivo");
          }
        }

      try
        {
        for (TotalArbol l : imagenes.getLista())
          {
          papeles += l.getPapeles();
          ppV += l.getP_validos();
          ppI += l.getP_invalidos();
          float porcentajeVlidos = 0;
          porcentajeVlidos += (float) ppV * 100 / (float) papeles;
          boolean isNan = Float.isNaN(porcentajeVlidos);
          validosPorcentaje = (!isNan) ? porcentajeVlidos : 0;
          an += l.getAnversos();
          rev += l.getReversos();
          img += l.getImagenes();
          cm += l.getCampos();
          cmV += l.getC_valid();
          cmI += l.getC_invalid();
          cmIB += l.getC_invalidDB();
          }
        } catch (Exception l)
        {
        String ruta = rutaProcesada.replace("/Carat.xml", "");
        mensaje = new Mensajes(ruta, "El xml 'Meta' no se encuentra");
        }
      }

    Porcentaje validos = new Porcentaje(cmV, cm);
    Porcentaje invalido = new Porcentaje(cmI, cm);
    Porcentaje invalidoDB = new Porcentaje(cmIB, cm);
    camposVolumen = img
            + ", " + totFS
            + ", " + an
            + ", " + rev
            + ", " + papeles
            + ", " + ppV
            + ", " + ppI
            + ", " + validosPorcentaje
            + ", " + cm
            + ", " + cmV
            + ", " + cmI
            + ", " + cmIB
            + ", " + validos
            + ", " + invalido
            + ", " + invalidoDB
            + "\n";
    return null;

  }

  public String getCampos() {
    return camposVolumen;
  }

//  private String fecha() {
//    String fecha = "";
//    SimpleDateFormat format = new SimpleDateFormat("dd'-'MM'-'yyyy HH:mm", Locale.ENGLISH);
//    Date date = new Date();
//    fecha = format.format(date);
//    return fecha;
//  }
  @Override
  protected void done() {
    if (!isCancelled())
      {
      escribioTXT = imagenes.isEscrituraErrores();
      botonVolumen.setEnabled(true);

      String finalizo = "La construcción del Arbol ha finalizado";
      String aceptar = "Aceptar para mostrar la Ventana Principal\n";
      String advertencia = (escribioTXT) ? "Datos de errores en: \n" + mensaje.getUbicacion() : "";
      JOptionPane.showMessageDialog(null, finalizo + "\n" + advertencia + "\n" + aceptar, "Proceso finalizado", JOptionPane.INFORMATION_MESSAGE);
      //TODO cambiar por un : version 1.0.03
//            JOptionPane.showConfirmDialog(principal, flag);
      frameInput.dispose();
      principal.setVisible(true);
      }
  }
}
