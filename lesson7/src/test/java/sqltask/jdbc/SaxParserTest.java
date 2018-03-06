package sqltask.jdbc;

import org.junit.Test;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;
/**
 * Class for test SaxParser.
 * Elements for test:
 * - parsing second XML and make calculation.
 */
public class SaxParserTest {
    @Test
    public void whenShouldCheckAction() throws InterruptedException, ParserConfigurationException, SAXException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SaxParser handler = new SaxParser();
            saxParser.parse(new File(FilesWayForTest.fileParserWay), handler);
            //Get Employees list
            List<Entry> empList = handler.getEmpList();
            System.out.println(handler.calculate());
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }
}