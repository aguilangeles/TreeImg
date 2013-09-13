/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class MensajeTxt {

  private String ruta;
  private String descripcion;

  public MensajeTxt(String ruta, String descripcion) {
    this.ruta = ruta;
    this.descripcion = descripcion;
  }

  public String getRuta() {
    return ruta;
  }

  public void setRuta(String ruta) {
    this.ruta = ruta;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getFecha() {
    String fecha = "";
    SimpleDateFormat format = new SimpleDateFormat("dd'-'MM'-'yyyy HH:mm", Locale.ENGLISH);
    Date date = new Date();
    fecha = format.format(date);
    return fecha;
  }
}
