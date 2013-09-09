/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 *
 * @author MUTNPROD003
 */
public class Porcentaje {
    private int parcial;
    private int total;
    private float ret;
    public Porcentaje(int parcial, int total) {
        this.parcial = parcial;
        this.total = total;
        getPorcentaje();
    }
    private float getPorcentaje() {
        float porcentaje = 0;
        float rett = (float) this.parcial * 100 / (float) this.total;
        boolean nan = Float.isNaN(rett);
        ret = (!nan ? rett : 0);
        return ret;
    }

    @Override
    public String toString() {
        return ret + "";
    }
}
