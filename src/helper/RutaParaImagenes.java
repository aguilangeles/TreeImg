/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import java.io.File;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author MUTNPROD003
 */
public class RutaParaImagenes {

    private boolean valor;
    private TreePath rutaCompleta;
    private Object nodo;
    private String rutasSinTif;
    private int it;

    public RutaParaImagenes(boolean valor, Object nodo, TreeNode[] treeNode) {
        this.valor = valor;
        this.nodo = nodo;
        String ruta = "";
        it = (valor ? 2 : 1);
        for (int y = 0; y < it; y++) {
            ruta += treeNode[y] + File.separator;
        }
        ruta += "Imagenes" + File.separator;
        this.rutasSinTif = ruta;
    }

    public String getRuta() {
        return this.rutasSinTif + this.nodo;
    }
}
