/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import java.io.File;
import javax.swing.tree.TreePath;

/**
 *
 * @author MUTNPROD003
 */
public class RutaParaIDC {

    private boolean valor;
    private TreePath rutaCompleta;
    private Object nodo;
    private String rutasSinTif;
    private int it;

    public RutaParaIDC(boolean valor, Object idc, String rutao) {
        this.valor = valor;
        this.nodo = idc;
        this.rutasSinTif = rutao + File.separator;
    }

    public String getRutaIdc() {
        return this.rutasSinTif + this.nodo;
    }
}
