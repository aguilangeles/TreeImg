/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolporimagenes;

import InternalFrame.InputRuta;

/**
 *
 * @author MUTNPROD003
 */
public class ArbolPorImagenes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           java.awt.EventQueue.invokeLater(new Runnable() {
               @Override
            public void run() {
                new InputRuta().setVisible(true);
            }
        });
    }
}
