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
        DataBase dataBase = new DataBase("jdbc:postgresql://localhost:5432","nametest2","postgres","admin");
        dataBase.setN(1000000);
        ParseToXML parseToXML = new ParseToXML(dataBase,FilesWayForTest.fileXmlWay);
        parseToXML.takeList();
        dataBase.closeData();
        dataBase.closeData();
    }
}