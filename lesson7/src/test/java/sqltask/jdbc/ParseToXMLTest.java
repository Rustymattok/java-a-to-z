package sqltask.jdbc;
import org.junit.Test;
/**
 * Class for test creating XML file depends of N.
 * Test  elements:
 * - creation of database.
 * - creation of xml file regarding conditions.
 */
public class ParseToXMLTest {
    @Test
    public void whenShouldCheckAction() throws InterruptedException {
        WorkBase workBase = new WorkBase("jdbc:postgresql://localhost:5432","nametest2","postgres","admin",10);
        DataBase dataBase = new DataBase(workBase);
        ParseToXML parseToXML = new ParseToXML(dataBase,FilesWayForTest.fileXmlWay);
        parseToXML.takeList();
        dataBase.closeData();
        dataBase.closeData();
    }
}