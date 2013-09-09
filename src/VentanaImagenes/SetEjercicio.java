/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaImagenes;

import Parser.ReporteXMlCaratula;
import helper.Mensajes;

/**
 * detecta si es un ejercicio de gendarmeria,
 *
 * @author aguilangeles@gmail.com
 */
public class SetEjercicio {

  private int sede;
  boolean ejercicio, escrituraErrores;
  private String rutaProcesada;

  public SetEjercicio(ReporteXMlCaratula reporte, int sede, boolean isEjercicio,
          boolean escrituraErrores, String rutaProcesada) {
    this.sede = sede;
    this.ejercicio = isEjercicio;
    this.escrituraErrores = escrituraErrores;
    this.rutaProcesada = rutaProcesada;
    setEjercicio(reporte);
  }


  private void setEjercicio(ReporteXMlCaratula reporte)  {
    if (sede == 1)
      {
      ejercicio = reporte.isEjercicio();
      if (ejercicio)
        {
        escrituraErrores = true;
        String ruta = rutaProcesada.replace("/Carat.xml", "");
        Mensajes mensaje = new Mensajes(ruta, "Tipo de documento: EJERCICIO");
        }
      }
  }

  public boolean isEjercicio() {
    return ejercicio;
  }
  
}
