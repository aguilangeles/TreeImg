/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InternalFrame;

import Entidades.Tif;
import VentanaImagenes.ImageComponent;
import VentanaImagenes.MyWorker;
import VentanaImagenes.SetTablaMetadata;
import VentanaImagenes.WorkerIDC;
import VentanaImagenes.setTablaForIDC;
import helper.VersionEImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class NuevoFrame extends javax.swing.JFrame {

  private boolean isDirectorio;
  private LoginRuta input;
  private WorkerIDC idc;
  private DefaultMutableTreeNode root;
  private DefaultTreeModel model;
  private String pathIdc;
  private JLabel informacion;
  private MyWorker nuevoMapa;
  ImageComponent imageComponent = new ImageComponent();
  VersionEImageIcon vi;

  /**
   * Creates new form NuevoFrame
   */
  public NuevoFrame() {
    initComponents();
  }

  public NuevoFrame(boolean isDirectorio,
          LoginRuta input, String pathIdc,
          JLabel informacion) {
    this.isDirectorio = isDirectorio;
    this.input = input;
    this.pathIdc = pathIdc;
    this.informacion = informacion;
    initComponents();

    informaVolumen.setEnabled(false);
    setExtendedState(6);
    crearElArbol();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    infoMeta = new javax.swing.JPanel();
    combo = new javax.swing.JComboBox();
    imagenLb = new javax.swing.JLabel();
    scrollImage = new javax.swing.JScrollPane();
    panelTablas = new javax.swing.JPanel();
    cerrar = new javax.swing.JButton();
    scrollIdc = new javax.swing.JScrollPane();
    jTable3 = new javax.swing.JTable();
    infoIDC = new javax.swing.JLabel();
    scrollMetadata = new javax.swing.JScrollPane();
    jTable2 = new javax.swing.JTable();
    jLabel2 = new javax.swing.JLabel();
    informaVolumen = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    arbol = new javax.swing.JTree();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tamanio Original", "Visible en Pantalla", "50%", "25%", " " }));

    imagenLb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    imagenLb.setText("Visualizar imagen a:");

    scrollImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    panelTablas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    panelTablas.setOpaque(false);

    cerrar.setText("Finalizar");
    cerrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cerrarActionPerformed(evt);
      }
    });

    scrollIdc.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    jTable3.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Nombre", "Valor"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    scrollIdc.setViewportView(jTable3);
    jTable3.getColumnModel().getColumn(0).setResizable(false);
    jTable3.getColumnModel().getColumn(1).setResizable(false);

    infoIDC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    infoIDC.setText("Informaci�n del IDC");

    scrollMetadata.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    jTable2.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Nombre", "Valor", "Estado"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    scrollMetadata.setViewportView(jTable2);
    jTable2.getColumnModel().getColumn(0).setResizable(false);
    jTable2.getColumnModel().getColumn(1).setResizable(false);
    jTable2.getColumnModel().getColumn(2).setResizable(false);

    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel2.setText("Informaci�n Metadata");

    informaVolumen.setText("Ver Totales del Vol�men");
    informaVolumen.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(204, 255, 204)));

    javax.swing.GroupLayout panelTablasLayout = new javax.swing.GroupLayout(panelTablas);
    panelTablas.setLayout(panelTablasLayout);
    panelTablasLayout.setHorizontalGroup(
      panelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(scrollMetadata, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
      .addComponent(infoIDC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(scrollIdc, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
      .addComponent(cerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(informaVolumen, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
    );
    panelTablasLayout.setVerticalGroup(
      panelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablasLayout.createSequentialGroup()
        .addGap(15, 15, 15)
        .addComponent(jLabel2)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(scrollMetadata, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(30, 30, 30)
        .addComponent(informaVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(infoIDC)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(scrollIdc, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(cerrar)
        .addContainerGap())
    );

    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Arbol de Imagenes");

    jScrollPane1.setViewportView(arbol);

    javax.swing.GroupLayout infoMetaLayout = new javax.swing.GroupLayout(infoMeta);
    infoMeta.setLayout(infoMetaLayout);
    infoMetaLayout.setHorizontalGroup(
      infoMetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(infoMetaLayout.createSequentialGroup()
        .addGroup(infoMetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(infoMetaLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(scrollImage))
          .addGroup(infoMetaLayout.createSequentialGroup()
            .addGap(73, 73, 73)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
            .addComponent(imagenLb, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(panelTablas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    infoMetaLayout.setVerticalGroup(
      infoMetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panelTablas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addGroup(infoMetaLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(infoMetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(imagenLb)
          .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel1))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(infoMetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(scrollImage)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE))
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(infoMeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(infoMeta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
    System.exit(0);
  }//GEN-LAST:event_cerrarActionPerformed
  /**
   * @param args the command line arguments
   */
//  public static void main(String args[]) {
//    /* Set the Nimbus look and feel */
//    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//     */
//    try
//      {
//      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
//        {
//        if ("Nimbus".equals(info.getName()))
//          {
//          javax.swing.UIManager.setLookAndFeel(info.getClassName());
//          break;
//          }
//        }
//      } catch (ClassNotFoundException ex)
//      {
//      java.util.logging.Logger.getLogger(NuevoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//      } catch (InstantiationException ex)
//      {
//      java.util.logging.Logger.getLogger(NuevoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//      } catch (IllegalAccessException ex)
//      {
//      java.util.logging.Logger.getLogger(NuevoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//      } catch (javax.swing.UnsupportedLookAndFeelException ex)
//      {
//      java.util.logging.Logger.getLogger(NuevoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//      }
//    //</editor-fold>
//
//    /* Create and display the form */
//    java.awt.EventQueue.invokeLater(new Runnable() {
//      public void run() {
//        new NuevoFrame().setVisible(true);
//      }
//    });
//  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTree arbol;
  private javax.swing.JButton cerrar;
  private javax.swing.JComboBox combo;
  private javax.swing.JLabel imagenLb;
  private javax.swing.JLabel infoIDC;
  private javax.swing.JPanel infoMeta;
  private javax.swing.JButton informaVolumen;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable jTable2;
  private javax.swing.JTable jTable3;
  private javax.swing.JPanel panelTablas;
  private javax.swing.JScrollPane scrollIdc;
  private javax.swing.JScrollPane scrollImage;
  private javax.swing.JScrollPane scrollMetadata;
  // End of variables declaration//GEN-END:variables

  private void crearElArbol() {
    root = new DefaultMutableTreeNode(pathIdc, true);
    model = new DefaultTreeModel(root);
    arbol.setModel(model);
    if (isDirectorio)
      {
      vi = new VersionEImageIcon(this, "Nueva Ventata principal");
      infoMeta.setBackground(vi.newColor());
      this.nuevoMapa = new MyWorker(isDirectorio, this, input, root,
              pathIdc, informacion);
      this.nuevoMapa.execute();
      addActionToJButton();
      } else
      {
      vi = new VersionEImageIcon(this, "Solo un IDC");
      infoMeta.setBackground(vi.newColor());
      this.idc = new WorkerIDC(isDirectorio, this, input, root, pathIdc, informacion);
      this.idc.execute();

      }

    KeyListener kl = setKeyListener();
    arbol.addKeyListener(kl);
    SetMouseListenerAction setMouseListenerAction =
            new SetMouseListenerAction(isDirectorio, imageComponent,
            scrollImage, combo, arbol, jTable2, jTable3);
  }

  private void addActionToJButton() {
    informaVolumen.setEnabled(true);
    informaVolumen.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String campos = nuevoMapa.getCampos();
        new Volumenes(campos).setVisible(true);
      }
    });
  }

  private KeyListener setKeyListener() {
    KeyListener kl =
            new SetKeyListenerAction(isDirectorio, imageComponent, scrollImage,
            combo, arbol, jTable2, jTable3).setKeyListener();
    return kl;
  }
}
