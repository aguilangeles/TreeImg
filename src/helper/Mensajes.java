/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import txt.Escritor;

/**
 *
 * @author MUTNPROD003
 */
public class Mensajes {

    private Escritor informe = new Escritor("Informe_Errores.txt");
    private String ruta;
    private String mensaje;
    private String ubicacion;


    public Mensajes(String ruta, String mensaje) throws IOException {
        this.ruta = ruta;
        this.mensaje = mensaje;
        resultado();
    }

    private void resultado() {
        try {
            informe.salida(ruta + "\t" + mensaje + "\t" + fecha() + "\n");
            ubicacion=informe.getUbicacion();

        } catch (IOException ex) {
            Logger.getLogger(Mensajes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


      private String fecha() {
        String fecha = "";
        SimpleDateFormat format = new SimpleDateFormat("dd'-'MM'-'yyyy HH:mm", Locale.ENGLISH);
        Date date = new Date();
        fecha = format.format(date);
        return fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }
}
