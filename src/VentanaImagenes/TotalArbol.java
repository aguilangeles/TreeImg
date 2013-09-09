/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaImagenes;
/**
 *
 * @author MUTNPROD003
 */
public class TotalArbol {

    private final String total;
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

    public TotalArbol(String total) {
        this.total = total;
    }
    public int getPapeles() {
        String[] ret = this.total.split(", ");
        for (int i = 0; i < ret.length; i++) {
            String papel = ret[0];
            papeles = Integer.parseInt(papel);
            break;
        }
        return papeles;
    }

    public int getImagenes() {
        String[] ret = this.total.split(", ");
        for (int i = 0; i < ret.length; i++) {
            String imagen = ret[1];
            imagenes = Integer.parseInt(imagen);
            break;
        }
        return imagenes;
    }

    public int getAnversos() {
        String[] ret = this.total.split(", ");
        for (int i = 0; i < ret.length; i++) {
            String anverso = ret[2];
            anversos = Integer.parseInt(anverso);
            break;
        }

        return anversos;
    }

    public int getReversos() {
        String[] ret = this.total.split(", ");
        for (int i = 0; i < ret.length; i++) {
            String anverso = ret[3];
            reversos = Integer.parseInt(anverso);
            break;
        }
        return reversos;
    }

    public int getP_validos() {
        String[] ret = this.total.split(", ");
        for (int i = 0; i < ret.length; i++) {
            String pvalid = ret[4];
            p_validos = Integer.parseInt(pvalid);
            break;
        }

        return p_validos;
    }

    public int getP_invalidos() {
        String[] ret = this.total.split(", ");
        for (int i = 0; i < ret.length; i++) {
            String pinvalido = ret[5];
            p_invalidos = Integer.parseInt(pinvalido);
            break;
        }
        return p_invalidos;
    }

    public int getCampos() {
        String[] ret = this.total.split(", ");
        for (int i = 0; i < ret.length; i++) {
            String campo = ret[6];
            campos = Integer.parseInt(campo);
            break;
        }
        return campos;
    }

    public int getC_valid() {
        String[] ret = this.total.split(", ");
        for (int i = 0; i < ret.length; i++) {
            String cvalid = ret[7];
            c_valid = Integer.parseInt(cvalid);
            break;
        }
        return c_valid;
    }

    public int getC_invalid() {
        String[] ret = this.total.split(", ");
        for (int i = 0; i < ret.length; i++) {
            String cinvalid = ret[8];
            c_invalid = Integer.parseInt(cinvalid);
            break;
        }
        return c_invalid;
    }

    public int getC_invalidDB() {
        String[] ret = this.total.split(", ");
        for (int i = 0; i < ret.length; i++) {
            String cinvDB = ret[9];
            c_invalidDB = Integer.parseInt(cinvDB);
            break;
        }
        return c_invalidDB;
    }
}
