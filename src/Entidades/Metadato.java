package Entidades;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import org.w3c.dom.NamedNodeMap;

/**
 *
 * @author MUTNPROD003
 */
public class Metadato {
    private NamedNodeMap campos;
    public NamedNodeMap getCampos() {
        return campos;
    }

    public void setCampos(NamedNodeMap campos) {
        this.campos = campos;
    }
    public Metadato() {
    }

    public Metadato(NamedNodeMap campos) {
        this.campos = campos;
        for(int i=0;i<campos.getLength();i++){
            Campo campo = new Campo(campos.item(i));
        }
    }


    public Campo getCampoByName(String name){
        for(int i=0;i<campos.getLength();i++){
            Campo campo = new Campo(campos.item(i));
            if(campo.getName().equalsIgnoreCase(name)){return campo;}
        }
        return null;
    }

    public Campo getCampoByValue(String value){
        for(int i=0;i<campos.getLength();i++){
            Campo campo = new Campo(campos.item(i));
            if(campo.getValue().equalsIgnoreCase(value)){return campo;}
        }
        return null;
    }
    public Campo getCampoByStatus(String status){
        for(int i=0;i<campos.getLength();i++){
            Campo campo = new Campo(campos.item(i));
            if(campo.getValue().equalsIgnoreCase(status)){return campo;}
        }
        return null;
    }

    @Override
    public String toString() {
        String ret = "";
        for(int i = 0;i<campos.getLength();i++){
            Campo campo = new Campo(campos.item(i));
            ret += campo+",";
        }
        return ret;
    }







}
