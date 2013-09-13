/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.List;

/**
 *
 * @author MUTNPROD003
 */
public class IDCNombre {
    private String nombre;//nombre idc
    private List<FilesNames> listaFiles;

    public IDCNombre(String nombre, List<FilesNames> listaFiles) {
        this.nombre = nombre;
        this.listaFiles = listaFiles;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<FilesNames> getListaFiles() {
        return listaFiles;
    }


    @Override
    public String toString() {
        return  nombre;
    }



}
