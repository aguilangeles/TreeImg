/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maria
 */
public class TablaVolumen extends JFrame {

    private JTable tablaIDC;
    private String volumenes;

    public TablaVolumen(JTable tablaIDC, String volumenes) {
        this.tablaIDC = tablaIDC;
        this.volumenes = volumenes;
        crearTabla();
    }

    public TablaVolumen() {

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
        modelo.addColumn("Valores Totales");
        cargarInfo(modelo);
        return modelo;
    }

    private void cargarInfo(DefaultTableModel modelo) {
        String titulos = "Estado, Imagenes, Imágenes FS, Papeles, Papeles Validos, Papeles Invalidos, Anversos, Reversos, Total Campos, "
                + "Campos Valid, Campos Invalid, Campos InvalidDB,"
                + " % Valid, % Invalid, % InvalidDB, ";

        String[] titulo = titulos.split(", ");
        for (int t = 0; t < titulo.length; t++) {
            modelo.addRow(new Object[]{titulo[t], 0});
        }

        String[] split = volumenes.split(", ");
        for (int i = 0; i < split.length; i++) {
            modelo.setValueAt(split[i], i, 1);
        }
    }
}
