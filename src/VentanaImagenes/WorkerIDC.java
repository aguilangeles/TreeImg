/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaImagenes;

import InternalFrame.InputRuta;
import InternalFrame.SoloIDCFrame;
import Recursos.FilesNames;
import Recursos.IDCNombre;
import helper.ContarImagenes;
import helper.Mensajes;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.tree.DefaultMutableTreeNode;
import txt.Escritor;

/**
 *
 * @author MUTNPROD003
 */
public class WorkerIDC extends SwingWorker<Void, Integer> {
    private boolean isDirectorio ;
    private SoloIDCFrame secundario;
    private InputRuta input;
    private String campos;
    private DefaultMutableTreeNode root;
    private String rutaInput;
    private File file;
    private FileFilter fileFilter;
    private String path;
    private ImagenesTree imagenes;
    private int sede;
    private Mensajes mensajes;

    public WorkerIDC(boolean isDirectorio, SoloIDCFrame secundario,InputRuta input,
            DefaultMutableTreeNode root, String rutaInput,File dir, FileFilter fileFilter) {
        this.isDirectorio=isDirectorio;
        this.secundario = secundario;
        this.input=input;
        this.root = root;
        this.rutaInput = rutaInput;
        this.file = dir;
        this.fileFilter = fileFilter;
    }

    public WorkerIDC() {
    }

    @Override
    protected Void doInBackground()  {
        String name = "";
        int totalImagenes;
        ContarImagenes ci;
        int contador = 0;

        File[] dirs = file.listFiles(fileFilter);

        if (dirs != null) {
            for (File d : dirs) {
                path = d.getPath();
                if (path.endsWith("Carat.xml")) {
                    contador++;
                    ci = new ContarImagenes(path, contador);
                    String reemplazo = path.replace("#", "%23");
                    totalImagenes = (ci.getListaFileSystem().get(contador));
                    imagenes = new ImagenesTree(isDirectorio, root, reemplazo, totalImagenes);//borrar todo lo de Escritor txt
                    IDCNombre idcnombre = imagenes.getIdcnombre();
                    List<FilesNames> lista = idcnombre.getListaFiles();
                    List<String> listaFiles = ci.getFilenames();
                    for (FilesNames flm : lista) {
                        String nombrefl = flm.toString();
                        if (!listaFiles.contains(nombrefl)) {
                            try {
                                String noFile = nombrefl;
                                imagenes.setEscrituraErrores(true);
                                String ruta = reemplazo.replace("Carat.xml", "Imagenes/") + noFile;
                                mensajes = new Mensajes(ruta, "El sistema no encontro el archivo en el Idc ");
                            } catch (IOException ex) {
                                Logger.getLogger(WorkerIDC.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            }
        }else{
            System.out.println("!");

        }
        return null;
    }

    public String getCampos() {
        return campos;
    }

    @Override
    protected void done() {
        if (!isCancelled()) {
           boolean escribioTXT = imagenes.isEscrituraErrores();
            String finalizo = "La construcción del Arbol ha finalizado";
            String aceptar = "Aceptar para mostrar la Ventana Principal\n";
            String advertencia = (escribioTXT) ? "Datos de errores en: \n" + mensajes.getUbicacion() : "";
            JOptionPane.showMessageDialog(null, finalizo + "\n" + advertencia + "\n" + aceptar);
            input.dispose();
            secundario.setVisible(true);
        }
    }
}

