/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InternalFrame;

import Image.ImageComponent;
import VentanaImagenes.MyWorker;
import VentanaImagenes.WorkerIDC;
import helper.VersionEImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class NuevoFrame extends javax.swing.JFrame {

  private boolean isDirectorio;
  private LoginRuta input;
  private DefaultMutableTreeNode root;
  private DefaultTreeModel model;
  private String pathIdc;
  private JLabel informacion;
  private static WorkerIDC idc;
  private static MyWorker nuevoMapa;
  private static VersionEImageIcon version;
  private static ImageComponent imageComponent = new ImageComponent();

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
    disenarArbol();
  }

  private void disenarArbol() {
    root = new DefaultMutableTreeNode(pathIdc, true);
    model = new DefaultTreeModel(root);
    arbol.setModel(model);
    if (isDirectorio)
      {
      setVentanaPrincipal();
      } else
      {
      setVentanaSecundaria();
      }

    KeyListener kl = setKeyListener();
    arbol.addKeyListener(kl);
    SetMouseListenerAction setMouseListenerAction =
            new SetMouseListenerAction(isDirectorio, imageComponent,
            scrollImage, combo, arbol, tablaMetadata, tablaIDC);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    panelCentral = new javax.swing.JPanel();
    combo = new javax.swing.JComboBox();
    imagenLb = new javax.swing.JLabel();
    scrollImage = new javax.swing.JScrollPane();
    panelTablas = new javax.swing.JPanel();
    cerrar = new javax.swing.JButton();
    infoIDC = new javax.swing.JLabel();
    scrollMetadata = new javax.swing.JScrollPane();
    tablaMetadata = new javax.swing.JTable();
    jLabel2 = new javax.swing.JLabel();
    informaVolumen = new javax.swing.JButton();
    jScrollPane2 = new javax.swing.JScrollPane();
    tablaIDC = new javax.swing.JTable();
    jLabel1 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    arbol = new javax.swing.JTree();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tamanio Original", "Visible en Pantalla", "50%", "25%" }));

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

    infoIDC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    infoIDC.setText("Informaci�n del IDC");

    scrollMetadata.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    tablaMetadata.setModel(new javax.swing.table.DefaultTableModel(
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
    scrollMetadata.setViewportView(tablaMetadata);
    tablaMetadata.getColumnModel().getColumn(0).setResizable(false);
    tablaMetadata.getColumnModel().getColumn(1).setResizable(false);
    tablaMetadata.getColumnModel().getColumn(2).setResizable(false);

    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel2.setText("Informaci�n Metadata");

    informaVolumen.setText("Ver Totales del Vol�men");
    informaVolumen.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(204, 255, 204)));

    tablaIDC.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null},
        {null, null},
        {null, null},
        {null, null},
        {null, null},
        {null, null},
        {null, null},
        {null, null},
        {null, null},
        {null, null},
        {null, null},
        {null, null},
        {null, null},
        {null, null},
        {null, null}
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
    tablaIDC.setAutoscrolls(false);
    jScrollPane2.setViewportView(tablaIDC);
    tablaIDC.getColumnModel().getColumn(1).setResizable(false);

    javax.swing.GroupLayout panelTablasLayout = new javax.swing.GroupLayout(panelTablas);
    panelTablas.setLayout(panelTablasLayout);
    panelTablasLayout.setHorizontalGroup(
      panelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(scrollMetadata, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
      .addComponent(infoIDC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(informaVolumen, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
      .addComponent(cerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
    );
    panelTablasLayout.setVerticalGroup(
      panelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablasLayout.createSequentialGroup()
        .addGap(16, 16, 16)
        .addComponent(jLabel2)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(scrollMetadata, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(informaVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(infoIDC)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Arbol de Imagenes");

    jScrollPane1.setViewportView(arbol);

    javax.swing.GroupLayout panelCentralLayout = new javax.swing.GroupLayout(panelCentral);
    panelCentral.setLayout(panelCentralLayout);
    panelCentralLayout.setHorizontalGroup(
      panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelCentralLayout.createSequentialGroup()
        .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(panelCentralLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(scrollImage))
          .addGroup(panelCentralLayout.createSequentialGroup()
            .addGap(73, 73, 73)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(imagenLb, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(panelTablas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    panelCentralLayout.setVerticalGroup(
      panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelCentralLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(imagenLb)
          .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel1))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(scrollImage)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
        .addContainerGap())
      .addComponent(panelTablas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panelCentral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
  private javax.swing.JButton informaVolumen;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JPanel panelCentral;
  private javax.swing.JPanel panelTablas;
  private javax.swing.JScrollPane scrollImage;
  private javax.swing.JScrollPane scrollMetadata;
  private javax.swing.JTable tablaIDC;
  private javax.swing.JTable tablaMetadata;
  // End of variables declaration//GEN-END:variables

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
            combo, arbol, tablaMetadata, tablaIDC).setKeyListener();
    return kl;
  }

  private void setVentanaPrincipal() {
    version = new VersionEImageIcon(this, "Nueva Ventata principal");
    panelCentral.setBackground(version.newColor());
    nuevoMapa = new MyWorker(isDirectorio, this, input, root,
            pathIdc, informacion);
    nuevoMapa.execute();
    addActionToJButton();
  }

  private void setVentanaSecundaria() {
    version = new VersionEImageIcon(this, "Solo un IDC");
    panelCentral.setBackground(version.newColor());
    idc = new WorkerIDC(isDirectorio, this, input, root, pathIdc, informacion);
    idc.execute();
  }
}
