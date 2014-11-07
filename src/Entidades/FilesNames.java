/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author MUTNPROD003
 */
public class FilesNames {

    private String filename;
    private int orden;
    private String tipoFace;
    private String  campos;

    public FilesNames(String filename, int orden, String tipoFace, String campos) {
        this.filename = filename;
        this.orden = orden;
        this.tipoFace = tipoFace;
        this.campos = campos;
    }


    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getTipoFace() {
        return tipoFace;
    }

    public void setTipoFace(String tipoFace) {
        this.tipoFace = tipoFace;
    }

    public String getCampos() {
        return campos;
    }



    @Override
    public String toString() {
        return  filename;
    }


}
