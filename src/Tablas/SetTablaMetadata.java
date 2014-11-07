/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maria
 */
public class SetTablaMetadata extends JFrame {
  private JTable tablaMetada;
  private String metadata;

  public SetTablaMetadata(JTable tablaMetada, String metadata) {
    this.tablaMetada = tablaMetada;
    this.metadata = metadata;
    cargarTabla();

  }

  private void setCellRenderer() {
    ArrayList<ColumnaTamanio> lista = new ArrayList<>();
//    lista.add(new ColumnaTamanio(0, 0));
    lista.add(new ColumnaTamanio(1, 0));
//    lista.add(new ColumnaTamanio(2, 0));
    cellRenderer(lista, 30);
  }

  public void cellRenderer(List<ColumnaTamanio> lista, int rowHeigth) {
    for (ColumnaTamanio cl : lista)
      {
      tablaMetada.getColumnModel().getColumn(cl.getColumna()).setCellRenderer(new TextAreaRenderer());
      }
    tablaMetada.setRowHeight(rowHeigth);
  }

  private void cargarTabla() {

    DefaultTableModel modeloTabla = modeloDeTabla();
    tablaMetada.setModel(modeloTabla);
    tablaMetada.getColumnModel().getColumn(0).setPreferredWidth(70);
    tablaMetada.getColumnModel().getColumn(1).setPreferredWidth(200);
    tablaMetada.getColumnModel().getColumn(2).setPreferredWidth(70);
    setCellRenderer();
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
    modelo.addColumn("Estado");
    cargarInformacion(modelo);
    return modelo;
  }

  private void cargarInformacion(DefaultTableModel modelo) {
    String[] filas = metadata.split("\n");
    for (int o = 0; o < filas.length; o++)
      {
      String fila = filas[o];
      String[] columnas = fila.split("; ");
      modelo.addRow(columnas);
      }
  }

  public void setMetadata(String metadata) {
    this.metadata = metadata;
  }
}
