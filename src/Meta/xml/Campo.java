package Meta.xml;

import org.enhydra.xml.XmlHelper;
import org.w3c.dom.Node;

/**

 */
public class Campo {
    private String name;
    private String value;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Campo() {
    }
    public Campo(String name, String value, String status) {
        this.name = name;
        this.value = value;
        this.status = status;
    }

    public Campo(Node campo){
        this.name = XmlHelper.getNodeAttr("Name", campo);
        this.value = XmlHelper.getNodeAttr("Value", campo);
        this.status = XmlHelper.getNodeAttr("Status", campo);
    }

    @Override
    public String toString() {
        return name +"; "+ value + "; "+
                ((!"".equals(status))? status:' ') +"\n";
    }
}
