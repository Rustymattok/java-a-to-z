package sqltask.jdbc;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * SAX pareser by pattern.
 */
public class SaxParser extends DefaultHandler {
    private List<Entry> empList = null;
    private Entry emp = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("entry")) {
            //create a new Employee and put it in Map
            String field = attributes.getValue("field");
            //initialize Employee object and set id attribute
            emp = new Entry();
            emp.setField(field);
            //initialize list
            if (empList == null)
                empList = new ArrayList<Entry>();
        }
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("entry")) {
            //add Employee object to list
            empList.add(emp);
        }
    }
    /**
     * Method for calculation middle value.
     * @return middle value.
     */
    public Double calculate() {
        Double sum = 0.0;
        int i = 0;
        Iterator iterator = empList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            sum = sum + Integer.parseInt(empList.get(i).getField());
            i++;
        }
//        System.out.println(sum);
//        System.out.println(i);
        return sum / i;
    }

    public List<Entry> getEmpList() {
        return empList;
    }
}
