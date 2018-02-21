package sqltask.jdbc;

import java.util.List;
import javax.xml.bind.annotation.*;
/**
 * Class for parsing and sorting to the list Entry.
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)

public class FullList {
    @XmlElementWrapper(name = "entries")
    @XmlElement(name = "entry")
    private List<Entry> list;

    public FullList() {
    }

    public FullList(List<Entry> list) {
        this.list = list;
    }

    public List<Entry> getList() {
        return list;
    }

    public void setList(List<Entry> list) {
        this.list = list;
    }
}
