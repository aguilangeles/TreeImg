/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaImagenes;

/**
 * Muestra la sumatoria de los campos del arbol
 *
 * @author MUTNPROD003
 */
public class TotalesArbol {

  private int papeles;
  private int p_validos;
  private int p_invalidos;
  private int imagenes;
  private int anversos;
  private int reversos;
  private int campos;
  private int c_valid;
  private int c_invalid;
  private int c_invalidDB;

  public TotalesArbol(String total) {
    iterarString(total);
  }

  private void iterarString(String total) {
    String[] ret = total.split(", ");
    for (int i = 0; i < ret.length; i++)
      {
      switch (i)
        {
        case 0:
          String papel = ret[0];
          papeles = Integer.parseInt(papel);
          break;
        case 1:
          String imagen = ret[1];
          imagenes = Integer.parseInt(imagen);
          break;
        case 2:
          String anverso = ret[2];
          anversos = Integer.parseInt(anverso);
          break;
        case 3:
          String reverso = ret[3];
          reversos = Integer.parseInt(reverso);
          break;
        case 4:
          String pvalid = ret[4];
          p_validos = Integer.parseInt(pvalid);
          break;
        case 5:
          String pinvalido = ret[5];
          p_invalidos = Integer.parseInt(pinvalido);
          break;
        case 6:
          String campo = ret[6];
          campos = Integer.parseInt(campo);
          break;
        case 7:
          String cvalid = ret[7];
          c_valid = Integer.parseInt(cvalid);
          break;
        case 8:
          String cinvalid = ret[8];
          c_invalid = Integer.parseInt(cinvalid);
          break;
        case 9:
          String cinvDB = ret[9];
          c_invalidDB = Integer.parseInt(cinvDB);
          break;
        }
      }
  }//fin metodo nuevo

  public int getPapeles() {
    return papeles;
  }

  public int getP_validos() {
    return p_validos;
  }

  public int getP_invalidos() {
    return p_invalidos;
  }

  public int getImagenes() {
    return imagenes;
  }

  public int getAnversos() {
    return anversos;
  }

  public int getReversos() {
    return reversos;
  }

  public int getCampos() {
    return campos;
  }

  public int getC_valid() {
    return c_valid;
  }

  public int getC_invalid() {
    return c_invalid;
  }

  public int getC_invalidDB() {
    return c_invalidDB;
  }
}
