/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaImagenes;

/**
 *
 * @author maria
 */
public class ContenidoTablaIDC {
    private String ruta;
    private String idc ;
    private String campos;

    public ContenidoTablaIDC(String ruta, String idc) {
        this.ruta = ruta;
        this.idc  = idc;
    }
    public String getRuta() {
        return ruta;
    }

    public String getCampos() {
        return campos;
    }

    public void setCampos(String campos) {
        this.campos = campos;
    }
    @Override
    public String toString() {
        return idc ;
    }
}