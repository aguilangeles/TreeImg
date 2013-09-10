package Entidades;

import org.enhydra.xml.XmlHelper;
import org.w3c.dom.NodeList;

/**
 *
 */
public class MapeoList {

    private String fileName;
    private boolean isCarat;
    private int idPapel;
    private int order;
    private boolean deleted;
    private String c1;
    private String c2;
    private String c3;
    private String c4;
    private int size;
    private String face;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Boolean getCarat() {
        return isCarat;
    }

    public void setCarat(Boolean carat) {
        isCarat = carat;
    }

    public void setCarat(String carat) {
        isCarat = carat.equalsIgnoreCase("true");
    }

    public int getIdPapel() {
        return idPapel;
    }

    public void setIdPapel(int idPapel) {
        this.idPapel = idPapel;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted.equalsIgnoreCase("true");
    }

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2;
    }

    public String getC3() {
        return c3;
    }

    public void setC3(String c3) {
        this.c3 = c3;
    }

    public String getC4() {
        return c4;
    }

    public void setC4(String c4) {
        this.c4 = c4;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }


    public MapeoList() {
    }

    public MapeoList(String fileName,
                     Boolean carat,
                     int idPapel,
                     int order,
                     Boolean deleted,
                     String c1,
                     String c2,
                     String c3,
                     String c4,
                     int size,
                     String face) {
        this.fileName = fileName;
        isCarat = carat;
        this.idPapel = idPapel;
        this.order = order;
        this.deleted = deleted;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        this.size = size;
        this.face = face;
    }
    public int getCantidadPorFace(String face) {
        int ret = 0;
        int contador = 0;
        if (this.face.equalsIgnoreCase(face)) {
            ret ++;
        }
        return ret;
    }


    public MapeoList(String fileName,
                     String carat,
                     int idPapel,
                     int order,
                     String deleted,
                     String c1,
                     String c2,
                     String c3,
                     String c4,
                     int size,
                     String face) {
        this.fileName = fileName;
        setCarat(carat);
        this.idPapel = idPapel;
        this.order = order;
        setDeleted(deleted);
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        this.size = size;
        this.face = face;
    }

    public MapeoList(NodeList nodes) {


        this.fileName = XmlHelper.getNodeValue(XmlHelper.getNode("FileName",nodes));
        setCarat(XmlHelper.getNodeValue(XmlHelper.getNode("IsCarat",nodes)));
        this.idPapel =  Integer.parseInt(XmlHelper.getNodeValue(XmlHelper.getNode("IdPapel", nodes)));
        this.order =    Integer.parseInt(XmlHelper.getNodeValue(XmlHelper.getNode("Order", nodes)));
        setDeleted(XmlHelper.getNodeValue(XmlHelper.getNode("Deleted",nodes)));
        this.c1 = XmlHelper.getNodeValue(XmlHelper.getNode("C1",nodes));
        this.c2 = XmlHelper.getNodeValue(XmlHelper.getNode("C2",nodes));
        this.c3 = XmlHelper.getNodeValue(XmlHelper.getNode("C3",nodes));
        this.c4 = XmlHelper.getNodeValue(XmlHelper.getNode("C4",nodes));
        this.size = Integer.parseInt(XmlHelper.getNodeValue(XmlHelper.getNode("Size",nodes)));
        this.face = XmlHelper.getNodeValue(XmlHelper.getNode("Face", nodes));
    }

    @Override
    public String toString() {
        return "\nMapeoList{" +
                "fileName='" + fileName + '\'' +
                "\n isCarat=" + isCarat +
                "\n idPapel=" + idPapel +
                "\n order=" + order +
                "\n deleted=" + deleted +
                "\n c1='" + c1 + '\'' +
                "\n c2='" + c2 + '\'' +
                "\n c3='" + c3 + '\'' +
                "\n c4='" + c4 + '\'' +
                "\n size=" + size +
                "\n face='" + face + '\'' +
                '}';
    }
}
