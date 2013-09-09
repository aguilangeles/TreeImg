/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InternalFrame;

import java.io.File;
import java.io.FileFilter;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class InputRuta extends javax.swing.JFrame {

  private VentanaPrincipal principal;
  private SoloIDCFrame secundario;
  private boolean isFile;

  /**
   * Creates new form InputRuta
   */
  public InputRuta() {
    initComponents();
    jButton1.setEnabled(true);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jTextField1 = new javax.swing.JTextField();
    jButton1 = new javax.swing.JButton();
    checkIDC = new javax.swing.JCheckBox();
    informacion = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Arbol de Imagenes");

    jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Ingrese Ruta del Volumen");

    jTextField1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
    jTextField1.setText("C:\\Angeles\\201111L06V02\\GND#201111L06V02#GEN_00000002#SL000187");

    jButton1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
    jButton1.setText("Mostrar");
    jButton1.setEnabled(false);
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    checkIDC.setText("Es un IDC");

    informacion.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
    informacion.setBorder(javax.swing.BorderFactory.createTitledBorder("Informaci�n de proceso"));

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addComponent(checkIDC)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(20, 20, 20))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(informacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
            .addContainerGap())))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(22, 22, 22)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(checkIDC)
          .addComponent(jButton1))
        .addGap(18, 18, 18)
        .addComponent(informacion, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      isVolumenorIDC();
    }//GEN-LAST:event_jButton1ActionPerformed
  private void volumen(String ruta) {
    File file = new File(ruta);
    FileFilter fileFilter = new FileFilter() {
      @Override
      public boolean accept(File file) {
        return file.isDirectory();
      }
    };
    if (file.exists())
      {
      isFile = true;
      principal = new VentanaPrincipal(isFile, this, ruta, file, fileFilter, informacion);
      jButton1.setEnabled(false);
      } else
      {
      String mensaje = "La ruta especificada no es v�lida.\nVerifique la escritura de la misma";
      JOptionPane.showMessageDialog(null, mensaje, "Error en la escritura de la ruta", JOptionPane.ERROR_MESSAGE);
      jTextField1.setText("");
      }
  }

  private void idc(String ruta) {
    File folder = new File(ruta);
    FileFilter filefilter = new FileFilter() {
      @Override
      public boolean accept(File file) {
        return file.isFile();
      }
    };
    if (folder.exists())
      {
      secundario = new SoloIDCFrame(isFile, this, ruta, folder, filefilter, informacion);
      //encontrar que mostrar aca
      jTextField1.setText("El proceso puede demorarse unos minutos");
      jButton1.setEnabled(false);
      isFile = false;
      } else
      {
      String mensaje = "La ruta especificada no es v�lida.\nVerifique la escritura de la misma";
      JOptionPane.showMessageDialog(null, mensaje, "Error en la escritura de la ruta", JOptionPane.ERROR_MESSAGE);
      jTextField1.setText("");
      }

  }

  private void isVolumenorIDC() {
    if (isRutaVolumen() && !checkIDC.isSelected())
      {
      volumen(getRuta());
      } else if (!isRutaVolumen() && checkIDC.isSelected())
      {
      idc(getRuta());
      } else
      {
      JOptionPane.showMessageDialog(null, "Modifique la ruta o habilite/deshabilite "
              + "el checkbox\n para para que coincida con la opci�n seleccionada",
              "Incongruencias entre la ruta y la opci�n", JOptionPane.ERROR_MESSAGE);
      jTextField1.setText("");
      }
  }

  private boolean isRutaVolumen() {
    return !jTextField1.getText().toString().contains("#");
  }

  private String getRuta() {
    //me aseguro de que no haya espacios en blanco
    return jTextField1.getText().trim();
  }
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
//            java.util.logging.Logger.getLogger(InputRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(InputRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(InputRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(InputRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new InputRuta().setVisible(true);
//            }
//        });
//    }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JCheckBox checkIDC;
  private javax.swing.JLabel informacion;
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JTextField jTextField1;
  // End of variables declaration//GEN-END:variables
}
