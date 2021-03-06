/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaImagenes;

import Mapeo.xml.MapeoReporte;
import Entidades.ContenidoTablaIDC;
import Caratula.xml.Caratula;
import Caratula.xml.CaratulaParser;
import Caratula.xml.ReporteXMlCaratula;
import Entidades.IDCNombre;
import Entidades.RutaParaIDC;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author MUTNPROD003
 */
public final class ImagenesTree extends JFrame {

  private DefaultMutableTreeNode raiz;
  private MapeoReporte mapeo;
  private IDCNombre idcnombre;
  //
  private boolean isDirectorio;
  private boolean escrituraErrores;
  private boolean ejercicio;
//
  private String rutaProcesada;
  private String idc;
  //
  private int sede;
  private int imgFileSystem;
  private List<TotalesArbol> listaTotales = new ArrayList<>();

  public ImagenesTree(boolean directorio, DefaultMutableTreeNode root,
          String rutaProcesada, boolean escribio, int sede, int imagFileSystem) {
    this.isDirectorio = directorio;
    this.raiz = root;
    this.rutaProcesada = rutaProcesada;
    this.escrituraErrores = escribio;
    this.sede = sede;
    this.imgFileSystem = imagFileSystem;
    mostrarIDC(rutaProcesada);
  }

  public ImagenesTree(boolean directorio, DefaultMutableTreeNode raiz, String rutaProcesada, int imgFileSystem) {
    this.isDirectorio = directorio;
    this.raiz = raiz;
    this.imgFileSystem = imgFileSystem;
    mostrarIDC(rutaProcesada);
  }

  private List<TotalesArbol> mostrarIDC(String rutaProcesada) {
    try
      {
      setParser(rutaProcesada);
      RutaParaIDC rutaIdc = new RutaParaIDC(isDirectorio, idc, raiz.toString());//ok
      ContenidoTablaIDC contenidoIDC = new ContenidoTablaIDC(rutaIdc.getRutaIdc(), idc);//ok
      DefaultMutableTreeNode idece = new DefaultMutableTreeNode(contenidoIDC, true);
      raiz.add(idece);
      // TODO refactor this

      mapeo = new MapeoReporte(isDirectorio, rutaProcesada, idece, isEjercicio(), imgFileSystem);//primer refactor
      contenidoIDC.setCampos(mapeo.getCampoString());
      idcnombre = mapeo.getIdcnombre();
      //TODO refactor this 2
      TotalesArbol totales = new TotalesArbol(mapeo.toString());
      listaTotales.add(totales);

      } catch (SAXException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en imagenesTree", JOptionPane.ERROR_MESSAGE);
      } catch (IOException ex)
      {
      String mensaje = ex.getMessage();
      if (mensaje.contains("unknown protocol: c"))
        {
        JOptionPane.showMessageDialog(null, "La ruta especificada no corresponde a un Volumen\n"
                + "El programa se cerrar�", "Error en la escritura de la ruta", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
        } else
        {
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en imagenesTree", JOptionPane.ERROR_MESSAGE);
        }
      }
    return listaTotales;
  }

  public List<TotalesArbol> getLista() {
    return listaTotales;
  }

  public boolean isEscrituraErrores() {
    return escrituraErrores;
  }

  public void setEscrituraErrores(boolean escrituraErrores) {
    this.escrituraErrores = escrituraErrores;
  }

  public IDCNombre getIdcnombre() {
    return idcnombre;
  }

  private void setEjercicio(ReporteXMlCaratula reporte) {
    SetEjercicio setEjercicio =
            new SetEjercicio(reporte, sede, ejercicio, escrituraErrores,
            rutaProcesada);
    setIsEjercicio(setEjercicio.isEjercicio());

  }

  public boolean isEjercicio() {
    return ejercicio;
  }

  public void setIsEjercicio(boolean isEjercicio) {
    this.ejercicio = isEjercicio;
  }

  private void setParser(String rutaProcesada) throws IOException, SAXException {
    CaratulaParser caratulaParser = new CaratulaParser(rutaProcesada);
    ReporteXMlCaratula reporte = caratulaParser.getReporte();
    NamedNodeMap caratulaNodeMap = caratulaParser.getCaratulas();
    for (int a = 0; a < caratulaNodeMap.getLength(); a++)
      {
      Node caratulaNode = caratulaNodeMap.item(a);
      NodeList caratulaChildren = caratulaNode.getChildNodes();
      Caratula caratula = new Caratula(caratulaChildren);
      idc = caratula.getIdIDC();
      setEjercicio(reporte);
      }
  }
}
