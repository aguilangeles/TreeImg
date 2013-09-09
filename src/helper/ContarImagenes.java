/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * cuenta la cantidad de imagenes en el filesystem
 * @author MUTNPROD003
 */
public class ContarImagenes {
    private List<String> filenames;
    private String ruta;
    private int ret = 0;
    private int key;
    private Map<Integer, Integer> listaFileSystem;

    public ContarImagenes(String ruta, int key) {
        this.ruta = ruta.replace("%23", "#");
        this.key=key;
        cuentaFileSystem();
    }

    public ContarImagenes() {
    }

    private Map<Integer, Integer> cuentaFileSystem() {
        listaFileSystem = new HashMap<>();
        String re=ruta.replace("Carat.xml", "Imagenes");
        File carpeta = new File(re);
        FileFilter ff = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        };
        if (carpeta.exists()) {
            filenames = new ArrayList<>();

            int contador = 0;
            File[] lista = carpeta.listFiles(ff);
            for (File fl : lista) {
                String filename =(fl.getName());
                filenames.add(filename);
                contador++;
            }
            ret = (contador);
            listaFileSystem.put(key, ret);
        }else{
            System.out.println("false");
        }
        return listaFileSystem;

    }

    public Map<Integer, Integer> getListaFileSystem() {
        return listaFileSystem;
    }

    public List<String> getFilenames() {
        return filenames;
    }
    

}
