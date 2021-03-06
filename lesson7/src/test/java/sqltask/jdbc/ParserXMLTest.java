package sqltask.jdbc;
import org.junit.Test;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * Class for test all aplication.
 * Elements for test:
 * - time of work full aplication.
 * - parsing to second XML file.
 */
public class ParserXMLTest {
    @Test
    public void whenShouldCheckAction() throws InterruptedException{
        WorkBase workBase = new WorkBase("jdbc:postgresql://localhost:5432","nametest2","postgres","admin",10);
        DataBase dataBase = new DataBase(workBase);
        ParseToXML parseToXML = new ParseToXML(dataBase,FilesWayForTest.fileXmlWay);
        parseToXML.takeList();
        XslTransformer xslTransformer = new XslTransformer();
        try {
            xslTransformer.process(new File(FilesWayForTest.fileXmlWay),new File(FilesWayForTest.fileXslWay),new FileOutputStream(new File(FilesWayForTest.fileParserWay)));
            ParserXML parserXML = new ParserXML(FilesWayForTest.fileParserWay);
            parserXML.parser();
            parserXML.show();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataBase.closeData();
    }

}