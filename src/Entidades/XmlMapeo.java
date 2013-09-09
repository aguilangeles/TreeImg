package Entidades;

import helper.XmlHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import Parser.MapeoList;


/**

 */
public class XmlMapeo {
    private String idIDC;
    private Date creationDate;
    private String status;
    private List<MapeoList> mapeoListCollection = new ArrayList();
    private NodeList mapeoNodeList;
    private NamedNodeMap mapeoLists;

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public String getIdIDC() {
        return idIDC;
    }

    public void setIdIDC(String idIDC) {
        this.idIDC = idIDC;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public NamedNodeMap getMapeoLists() {
        return mapeoLists;
    }

    public void setMapeoLists(NamedNodeMap mapeoLists) {
        this.mapeoLists = mapeoLists;
    }



    public int getCantidadImagenes() {
        return this.mapeoListCollection.size();
    }

     public int cantidadPapeles() {
        int ret = 0;
        int idPapel = 0;
        for (MapeoList ml : this.mapeoListCollection) {
            if (ml instanceof MapeoList && (idPapel != ml.getIdPapel()) && ml.getFace().equalsIgnoreCase("anverso")) {
                idPapel = ml.getIdPapel();
                ret++;
            }
        }
        return ret - isCarat();
    }
    public int isCarat(){
        int ret=0;
        int idPapel=0;
        for (MapeoList ml : this.mapeoListCollection) {
            if (ml instanceof MapeoList  && ml.getCarat()) {
                ret++;
            }
        }
        return ret;
    }


    public XmlMapeo() {
    }

    public XmlMapeo(String idIDC, Date creationDate, String status, NamedNodeMap mapeoLists) {
        this.idIDC = idIDC;
        this.creationDate = creationDate;
        this.status = status;
        this.mapeoLists = mapeoLists;
    }

    public XmlMapeo(NodeList nodes) {
        this.idIDC = XmlHelper.getNodeValue("IdIDC", nodes);
        String date = XmlHelper.getNodeValue("CreationDate", nodes);
        Date creationDate = null;
        try {
            creationDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.creationDate = creationDate;
        this.status = XmlHelper.getNodeValue("Status", nodes);
        this.mapeoLists= XmlHelper.getNodesByName("MapeoList", nodes) ;
        for( int i = 0; i<mapeoLists.getLength(); i++){
            Node nodeMapeo = mapeoLists.item(i);
            mapeoNodeList = nodeMapeo.getChildNodes();
            MapeoList mapeoList = new MapeoList(mapeoNodeList);
            this.mapeoListCollection.add(mapeoList);
        }
    }

    @Override
    public String toString() {
        String ret = "";
        for( int i = 0 ; i<mapeoListCollection.size(); i++){
            ret += mapeoListCollection.get(i).toString();
        }
        return "XmlMapeo{" +
                "idIDC='" + idIDC + '\'' +
                ", creationDate=" + creationDate +
                ", status='" + status + '\'' +
                ", mapeoLists=" +  ret+
                '}';
    }
}
