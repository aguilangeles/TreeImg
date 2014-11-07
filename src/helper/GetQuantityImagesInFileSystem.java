/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 * cuenta la cantidad de imagenes en el filesystem y devuelve una lista de las
 * imagenes
 *
 * @author MUTNPROD003
 */
public class GetQuantityImagesInFileSystem {

  private List<String> filenameList;
  private String nRuta;
  private Map<Integer, Integer> imageFileSystList;

  public GetQuantityImagesInFileSystem(String ruta, int key) {
    this.nRuta = newRuta(ruta);
    this.imageFileSystList = cuentaFileSystem(key, nRuta);
  }

  public GetQuantityImagesInFileSystem() {
  }

  private Map<Integer, Integer> cuentaFileSystem(Integer key, String aRuta) {
    Map<Integer, Integer> imgInFileSys = new HashMap<>();
    File carpeta = new File(nRuta);
    FileFilter fileFilter = new FileFilter() {
      @Override
      public boolean accept(File pathname) {
        return pathname.isFile();
      }
    };
    if (carpeta.exists())
      {
      filenameList = new ArrayList<>();
      int contadorImages = 0;
      File[] fileList = carpeta.listFiles(fileFilter);
      for (File f : fileList)
        {
        contadorImages++;
        filenameList.add(f.getName());
        }
      imgInFileSys.put(key, contadorImages);
      } else
      {
      JOptionPane.showMessageDialog(null, "GetImageInFileSystem");
      }
    return imgInFileSys;
  }

  public Map<Integer, Integer> getListaFileSystem() {
    return imageFileSystList;
  }

  private String newRuta(String aString) {
    String sinNumeral = aString.replace("%23", "#");
    String newCarpeta = sinNumeral.replace("Carat.xml", "Imagenes");
    return newCarpeta;
  }

  public List<String> getFilenameList() {
    return filenameList;
  }
}
