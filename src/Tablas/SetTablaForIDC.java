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
public class SetTablaForIDC extends JFrame {

  private JTable tablaIDC;
  private String campos;

  public SetTablaForIDC(JTable tablaIDC, String campos) {
    this.tablaIDC = tablaIDC;
    this.campos = campos;
    crearTabla();
  }

  public SetTablaForIDC() {
  }

  private void crearTabla() {
    DefaultTableModel modeloTabla = modeloDeTabla();
    tablaIDC.setModel(modeloTabla);
    tablaIDC.getColumnModel().getColumn(0).setPreferredWidth(150);
    tablaIDC.getColumnModel().getColumn(1).setPreferredWidth(150);


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
    //cambiar los titulos , ahora pueden ser mas extensos
    String titulos = "Estado, Imágenes, Imágenes File System, "
            + "Anversos, Reversos, Papeles, Pp Válidos, Pp Inválidos, % Pp Válidos, Campos, "
            + "Cmp Valid, Cmp Invalid, Cmp InvalidDB, "
            + "% cmp Valid, % cmp Invalid, % cmp InvalidDB\n ";

    String[] titulo = titulos.split(", ");
    for (int t = 0; t < titulo.length; t++)
      {
      modelo.addRow(new Object[]
        {
        titulo[t], 0
        });
      }
    String[] campo = campos.split(", ");
    for (int i = 0; i < campo.length; i++)
      {
      modelo.setValueAt(campo[i], i, 1);
      }
  }
}
