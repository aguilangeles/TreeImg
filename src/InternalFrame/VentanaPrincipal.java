/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InternalFrame;

import VentanaImagenes.ContenidoTablaIDC;
import VentanaImagenes.ImageComponent;
import VentanaImagenes.MyWorker;
import VentanaImagenes.Tif;
import VentanaImagenes.tablaIDC;
import VentanaImagenes.tablaMetadata;
import helper.ImagenNoEncontrada;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileFilter;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author MUTNPROD003
 */
public class VentanaPrincipal extends javax.swing.JFrame {

  private InputRuta input;
  private MyWorker nuevoMapa;
  private DefaultMutableTreeNode root;
  private DefaultTreeModel model;
  private String rutaInput;
  private File file;
  private FileFilter fileFilter;
  private boolean isDirectorio;
  private int zoomImage;
  private JLabel informacion;

  ;

    /**
     * Creates new form VentanaPrincipal
     * @param isDirectorio
     * @param in
     * @param rutaInput
     * @param file
     * @param fileFilter
     */
    public VentanaPrincipal(boolean isDirectorio, InputRuta in, String rutaInput, File file, FileFilter fileFilter, JLabel informacion) {
    this.isDirectorio = isDirectorio;
    this.input = in;
    this.rutaInput = rutaInput;
    this.file = file;
    this.fileFilter = fileFilter;
    this.zoomImage = 50;
    this.informacion = informacion;
    initComponents();
    crearElArbol();
  }

  public VentanaPrincipal() {
    initComponents();
  }

  private void crearElArbol() {
    root = new DefaultMutableTreeNode(rutaInput, true);
    model = new DefaultTreeModel(root);
    jTree1.setModel(model);
    this.nuevoMapa = new MyWorker(isDirectorio, this, this.input, this.root,
            this.rutaInput, this.file, this.fileFilter, this.volumen, null, informacion);
    this.nuevoMapa.execute();

    KeyListener kl = new KeyAdapter() {
      @Override
      public void keyTyped(KeyEvent e) {
        myKeyEvt(e, "keyTyped");
      }

      @Override
      public void keyReleased(KeyEvent e) {
        myKeyEvt(e, "keyReleased");
      }

      @Override
      public void keyPressed(KeyEvent e) {
        myKeyEvt(e, "keyPressed");
      }

      private void myKeyEvt(KeyEvent e, String text) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_KP_DOWN || key == KeyEvent.VK_DOWN)
          {
          mostrarInformacion();
          } else if (key == KeyEvent.VK_KP_UP || key == KeyEvent.VK_UP)
          {
          mostrarInformacion();
          }
      }
    };
    jTree1.addKeyListener(kl);
    MouseListener ml = new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        mostrarInformacion();
      }
    };
    jTree1.addMouseListener(ml);
  }

  private void mostrarInformacion() {
    TreePath selpath = jTree1.getSelectionPath();
    if (selpath != null)
      {
      DefaultMutableTreeNode nodoSeleccionado = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
      if (nodoSeleccionado.toString().contains("#"))
        {
        ContenidoTablaIDC contenido = (ContenidoTablaIDC) nodoSeleccionado.getUserObject();
        tablaIDC tableIDC = new tablaIDC(tablaIDC, contenido.getCampos());
        tablaMetadata tablaM = new tablaMetadata(tablaMetadata1, "");
        } else if (nodoSeleccionado.toString().endsWith(".tif"))
        {
        Tif tif = (Tif) nodoSeleccionado.getUserObject();
        String imagen = tif.getRuta();
        if (imagen != null)
          {
          try
            {
            final ImageComponent imageCmp = new ImageComponent(imagen, 2. * getZoomImage() / jSlider1.getMaximum(), scrollImage);
            scrollImage.getViewport().add(imageCmp);
            jSlider1.setValue(zoomImage);
            jSlider1.addChangeListener(new ChangeListener() {
              @Override
              public void stateChanged(ChangeEvent e) {
                setZoomImage(jSlider1.getValue());
                imageCmp.setZoom(2. * getZoomImage() / jSlider1.getMaximum(), scrollImage);
              }
            });
            } catch (Exception ex)
            {
            String mensaje = ex.getMessage().toString();
            ImagenNoEncontrada imagenNoEncontrada = new ImagenNoEncontrada(mensaje, scrollImage, jSlider1, zoomImage, tablaMetadata1);

            }
          }//
        tablaMetadata tablaM = new tablaMetadata(tablaMetadata1, tif.getMetadata());

        }
      }
  }

  public int getZoomImage() {
    return zoomImage;
  }

  public void setZoomImage(int zoomImage) {
    this.zoomImage = zoomImage;
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        tablaVolumen1 = new javax.swing.JTable();
        PanelPrincipal = new javax.swing.JPanel();
        panelArbol = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jButton1 = new javax.swing.JButton();
        panelImagen = new javax.swing.JPanel();
        jSlider1 = new javax.swing.JSlider();
        scrollImage = new javax.swing.JScrollPane();
        panelTablas = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        scrollIDC = new javax.swing.JScrollPane();
        tablaIDC = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tablaMetadata = new javax.swing.JScrollPane();
        tablaMetadata1 = new javax.swing.JTable();
        volumen = new javax.swing.JButton();

        tablaVolumen1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tablaVolumen1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jScrollPane4.setViewportView(tablaVolumen1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("�rbol de Im�genes V_1.0.06");

        PanelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        panelArbol.setBorder(javax.swing.BorderFactory.createTitledBorder("�rbol de Im�genes"));

        jScrollPane1.setViewportView(jTree1);

        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelArbolLayout = new javax.swing.GroupLayout(panelArbol);
        panelArbol.setLayout(panelArbolLayout);
        panelArbolLayout.setHorizontalGroup(
            panelArbolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(panelArbolLayout.createSequentialGroup()
                .addGap(0, 185, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelArbolLayout.setVerticalGroup(
            panelArbolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArbolLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1))
        );

        panelImagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jSlider1.setMajorTickSpacing(5);
        jSlider1.setPaintTicks(true);
        jSlider1.setToolTipText("");
        jSlider1.setAutoscrolls(true);

        javax.swing.GroupLayout panelImagenLayout = new javax.swing.GroupLayout(panelImagen);
        panelImagen.setLayout(panelImagenLayout);
        panelImagenLayout.setHorizontalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImagenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollImage, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelImagenLayout.setVerticalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImagenLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollImage)
                .addContainerGap())
        );

        panelTablas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Informaci�n del IDC");

        scrollIDC.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollIDC.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tablaIDC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Estado", null},
                {"Im�genes", null},
                {"Im�genes FileSystem", null},
                {"Anversos", null},
                {"Reversos", null},
                {"Papeles", null},
                {"Pp V�lidos", null},
                {"Pp Inv�lidos", null},
                {"% Pp V�lidos", null},
                {"Campos", null},
                {"Cmp Valid", null},
                {"Cmp Invalid", null},
                {"Cmp InvalidDB", null},
                {"% cmp Valid", null},
                {"% cmp Invalid", null},
                {"% cmp InvalidDB", null},
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
        scrollIDC.setViewportView(tablaIDC);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(jTable2);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Informaci�n de la Im�gen");

        tablaMetadata.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        tablaMetadata.setAutoscrolls(true);

        tablaMetadata1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
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
        tablaMetadata.setViewportView(tablaMetadata1);

        volumen.setText("Ver Informacion del Volumen");
        volumen.setEnabled(false);
        volumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volumenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTablasLayout = new javax.swing.GroupLayout(panelTablas);
        panelTablas.setLayout(panelTablasLayout);
        panelTablasLayout.setHorizontalGroup(
            panelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollIDC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablasLayout.createSequentialGroup()
                        .addGap(0, 5, Short.MAX_VALUE)
                        .addGroup(panelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tablaMetadata, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(volumen, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelTablasLayout.setVerticalGroup(
            panelTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablasLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tablaMetadata, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(volumen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollIDC, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelArbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelTablas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTablas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelImagen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelArbol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void volumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volumenActionPerformed
      String campos = nuevoMapa.getCampos();
      new Volumenes(campos).setVisible(true);
    }//GEN-LAST:event_volumenActionPerformed
  /**
   * @param args the command line arguments
   */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VentanaPrincipal().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTree jTree1;
    private javax.swing.JPanel panelArbol;
    private javax.swing.JPanel panelImagen;
    private javax.swing.JPanel panelTablas;
    private javax.swing.JScrollPane scrollIDC;
    private javax.swing.JScrollPane scrollImage;
    private javax.swing.JTable tablaIDC;
    private javax.swing.JScrollPane tablaMetadata;
    private javax.swing.JTable tablaMetadata1;
    private javax.swing.JTable tablaVolumen1;
    private javax.swing.JButton volumen;
    // End of variables declaration//GEN-END:variables
}
