/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.File;
import java.io.FileFilter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class DirectorioOrdenado {

  private SortedMap sortedMap;
  private String ruta;
  private static int sede;

  public DirectorioOrdenado(String ruta) {
    this.ruta = ruta;
    sortedMap = directorio();
  }

  private SortedMap directorio() {
    SortedMap sortedMap1 = new TreeMap();
    int numeroSublote = 0;
    File carpeta = new File(ruta);
    FileFilter filefilter = new FileFilter() {
      @Override
      public boolean accept(File file) {
        return file.isDirectory();
      }
    };
    if (carpeta.exists())
      {
      File[] listOfFiles = carpeta.listFiles(filefilter);
      for (File file : listOfFiles)
        {
        String stringSortedMap = rutaDecoder(ruta, file.getName());
        numeroSublote = setNumeroSubLote(file, numeroSublote);
        sortedMap1.put(numeroSublote, stringSortedMap);
        }
      }
    return (SortedMap) sortedMap1;
  }

  private String rutaDecoder(String aString, String bString) {
    String ret = null;
    try
      {
      ret = aString + "/" + URLEncoder.encode(bString, "UTF-8") + "/" + "Carat.xml";
      } catch (UnsupportedEncodingException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(), "Error de encoding", JOptionPane.ERROR_MESSAGE);
      }
    return ret;
  }

  public SortedMap getSortedMap() {
    return sortedMap;
  }

  public int getSede() {
    return sede;
  }

  private int setNumeroSubLote(File file, int numeroSublote) {
    //trae el numero de sublote para poder ordenar el arbol de modo ascendente.
    String getName = file.getName();
    String[] split = getName.split("#");
    String finCadena = split[3];
    if (getName.contains("OSN"))
      {
      numeroSublote = Integer.parseInt(finCadena);
      sede = 2;
      } else if (getName.contains("GND"))
      {
      String sinSl = finCadena.substring(2);
      numeroSublote = Integer.parseInt(sinSl);
      sede = 1;
      }
    return numeroSublote;
  }
}
