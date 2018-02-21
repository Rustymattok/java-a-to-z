package sqltask.jdbc;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * Class include info for XML parsing files.
 */
@XmlRootElement(name = "entry")
@XmlAccessorType(XmlAccessType.FIELD)

public class Entry {
    /**
     * @param field - parameter of XML parsing value.
     */
    String field;

    public Entry() {
    }

    public Entry(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
