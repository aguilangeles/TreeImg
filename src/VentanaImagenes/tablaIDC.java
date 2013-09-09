/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaImagenes;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maria
 */
public class tablaIDC extends JFrame {

    private JTable tablaIDC;
    private String campos;

    public tablaIDC(JTable tablaIDC, String campos) {
        this.tablaIDC = tablaIDC;
        this.campos = campos;
        crearTabla();
    }

    public tablaIDC() {
    }


    private void crearTabla() {
        DefaultTableModel modeloTabla = modeloDeTabla();
        tablaIDC.setModel(modeloTabla);

    }

    private DefaultTableModel modeloDeTabla() {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        modelo.addColumn("Nombre");
        modelo.addColumn("Valor");
        cargarInfo(modelo);
        return modelo;
    }

    private void cargarInfo(DefaultTableModel modelo) {
        String titulos = "Estado, Im�genes, Im�genes File System, "
                + "Anversos, Reversos, Papeles, Pp V�lidos, Pp Inv�lidos, % Pp V�lidos, Campos, "
                + "Cmp Valid, Cmp Invalid, Cmp InvalidDB, "
                + "% cmp Valid, % cmp Invalid, % cmp InvalidDB\n ";

        String[] titulo = titulos.split(", ");
        for (int t = 0; t < titulo.length; t++) {
            modelo.addRow(new Object[]{titulo[t], 0});
        }
        String[] campo = campos.split(", ");
        for (int i = 0; i < campo.length; i++) {
            modelo.setValueAt(campo[i], i, 1);
        }
    }
}
