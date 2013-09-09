/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package txt;

import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class Escritor {

    private File file;
    private String input;
    private String ubicacion;
    private int tamanio;

    public Escritor(String salida) {
        this.input = salida;
    }

    public void salida(String info) throws IOException {
        file = new File(input);
        FileWriter out = null;
        BufferedWriter buffSalida = null;
        try {
            out = new FileWriter(file, true);
            buffSalida = new BufferedWriter(out, 3072);
            buffSalida.write(info);
            buffSalida.flush();//obliga a limpiar el buffer
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            try {
                out.close();
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            try {
                buffSalida.close();
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    public String getUbicacion() {
        return file.getAbsolutePath();
    }

    public long getTamanio() {
        return file.length();
    }

}
