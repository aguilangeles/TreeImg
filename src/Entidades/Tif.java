/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author maria
 */
public class Tif {
    private String ruta;
    private String fileName;
    private String metadata;
    private String campos;

    public Tif(String ruta, String fileName, String metadata, String campos) {
        this.ruta = ruta;
        this.fileName = fileName;
        this.metadata = metadata;
        this.campos=campos;

    }

    public Tif(String ruta, String fileName) {
        this.ruta = ruta;
        this.fileName = fileName;
    }

    public String getRuta() {
        return ruta;
    }

    public String getFileName() {
        return fileName;
    }

    public String getMetadata() {
        return metadata;
    }

    public String getCampos() {
        return campos;
    }

    @Override
    public String toString() {
        return fileName;
    }

}