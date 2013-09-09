/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.File;
import java.io.FileFilter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MUTNPROD003
 */
public class DirectorioOrdenado {

    private SortedMap sortedMap;
    private String ruta;
    private File folder;
    private FileFilter fileFilter;
    private int sede;

    public DirectorioOrdenado(String ruta, File folder, FileFilter fileFilter) throws UnsupportedEncodingException {
        this.ruta = ruta;
        this.folder = folder;
        this.fileFilter = fileFilter;
        directorio();
    }

    public DirectorioOrdenado(String ruta) throws UnsupportedEncodingException {
        this.ruta = ruta;
        directorio();
    }

    private SortedMap directorio()  {
        sortedMap = new TreeMap();
        int ultimo = 0;
        folder = new File(ruta);
        FileFilter filefilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory();
            }
        };
        if (folder.exists()) {
            File[] listOfFiles = folder.listFiles(filefilter);
            for (File f : listOfFiles) {
                try {
                    String procesar = ruta + "/" + URLEncoder.encode(f.getName(), "UTF-8") + "/" + "Carat.xml";
                    String[] spl = f.getName().split("#");
                    String finCadena = spl[3];
                    if (f.getName().contains("OSN")) {
                        ultimo = Integer.parseInt(finCadena);
                        this.sede = 2;
                    } else if (f.getName().contains("GND")) {
                        String sinSl = finCadena.substring(2);
                        ultimo = Integer.parseInt(sinSl);
                        this.sede = 1;
                    }
                    sortedMap.put(ultimo, procesar);
                } catch (UnsupportedEncodingException ex) {
                    System.out.println(ex.getMessage());
                    Logger.getLogger(DirectorioOrdenado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return (SortedMap) sortedMap;
    }

    public SortedMap getSortedMap() {
        return sortedMap;
    }

    public int getSede() {
        return sede;
    }
}
