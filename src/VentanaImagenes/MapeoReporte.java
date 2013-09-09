/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaImagenes;

import Entidades.XmlMapeo;
import Parser.MapeoList;
import Parser.ReporteXMLMapeo;
import Parser.XmlMapeoParser;
import Recursos.FilesNames;
import Recursos.IDCNombre;
import helper.RutaParaImagenes;
import java.io.IOException;
import java.util.ArrayList;
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
public final class MapeoReporte {

    private boolean isDirectorio;
    private boolean isEjercicio;
    private DefaultMutableTreeNode nodo;
    private String ruta;
    private String campoString = "";
    private String totalesVolumen = "";
    private String estadoMeta;
    private String datosCampos = "";
    private int imagFileSystem;
    private IDCNombre idcnombre;

    public MapeoReporte(boolean isDirectorio, String ruta, DefaultMutableTreeNode nodo, boolean isEjercicio,  int imagFileSystem) throws IOException {
        this.isDirectorio = isDirectorio;
        this.ruta = ruta;
        this.nodo = nodo;
        this.isEjercicio = isEjercicio;
        this.imagFileSystem=imagFileSystem;
        setReporte();

    }

    public void setReporte()  {
        ArrayList<FilesNames> listaFiles = new ArrayList<>();
        try {
            DefaultMutableTreeNode nodoFileName = null;
            String reemplazo = ruta.replace("Carat.xml", "Mapeo.xml");
            XmlMapeoParser mapeoParser = new XmlMapeoParser(reemplazo);
            NodeList xmlMapeoNodeChildren = mapeoParser.getXmlMapeoNode().getChildNodes();
            XmlMapeo xmlMapeo = new XmlMapeo(xmlMapeoNodeChildren);
            xmlMapeo.setMapeoLists(mapeoParser.getMapeoLists());
            NamedNodeMap mapeoNamedNode = mapeoParser.getMapeoLists();
            ReporteXMLMapeo reporteMapeo = mapeoParser.getReporte();
            FaceMapeo getFaces = new FaceMapeo(reporteMapeo);

            for (int e = 0; e < mapeoNamedNode.getLength(); e++) {
                Node mapeoListNode = mapeoNamedNode.item(e);
                NodeList mapeoChildren = mapeoListNode.getChildNodes();
                MapeoList mapeoList = new MapeoList(mapeoChildren);
                String idc = xmlMapeo.getIdIDC();
                String filename = mapeoList.getFileName();
                int orden = mapeoList.getOrder();
                String tipoFace = mapeoList.getFace();
                obtenerMetadato(xmlMapeo,  getFaces,  idc, filename);
                RutaParaImagenes rutaImagen = new RutaParaImagenes(isDirectorio, filename, nodo.getPath());

                String tablaMetadata = "Orden, " +orden + "\n" + "Face, " +tipoFace + ", \n" + estadoMeta;
                FilesNames files = new FilesNames(filename, orden, tipoFace, estadoMeta);
                listaFiles.add(files);
                idcnombre = new IDCNombre(idc, listaFiles);
                Tif tif = new Tif(rutaImagen.getRuta(), filename, tablaMetadata, campoString);
                nodoFileName = new DefaultMutableTreeNode(tif, false);
                nodo.add(nodoFileName);
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + "\n MAPEO REPORT");
        } catch (SAXException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        totalesVolumen += datosCampos;
    }

    private void obtenerMetadato(XmlMapeo xmlMapeo, FaceMapeo faceMapeo,
            String idc, String filename)
            throws SAXException, IOException {
        String status = xmlMapeo.getStatus();
        int imagenes = xmlMapeo.getCantidadImagenes();
        String faces = faceMapeo.toString();
        int totalPapeles = (!isEjercicio) ? xmlMapeo.cantidadPapeles() : 0;
        System.out.println(totalPapeles);
        try {
            Metadata metadata = new Metadata(ruta, status, imagenes, imagFileSystem, faces, totalPapeles, idc);
            campoString = metadata.getEstadisticasPapelesyCampos();
            estadoMeta = metadata.getEstadoyMetadata(filename);
            String campos = metadata.getDatos_Campos_Meta();
            datosCampos = totalPapeles + ", " + imagenes + ", " + faces + ", " + campos;

        } catch (IOException em) {
            //System.out.println("algo");
            //TODO colocar algo
        }
    }

    public String getCampoString() {
        return campoString;
    }

    @Override
    public String toString() {
        return totalesVolumen;
    }

    public IDCNombre getIdcnombre() {
        return idcnombre;
    }
}