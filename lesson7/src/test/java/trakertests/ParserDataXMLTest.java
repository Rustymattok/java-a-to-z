package trakertests;
import org.junit.Test;
import tracker.start.ParserDataXML;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class for correct working of ParserDataXML.
 */
public class ParserDataXMLTest {
    @Test
    public void whenShouldCheckParser() throws InterruptedException {
        try {
            try(ParserDataXML parserDataXML = new ParserDataXML(FileWayTest.fileXmlWay)){
                parserDataXML.parser();
                boolean flag = true;
                if(!parserDataXML.getUrl().equals("\"jdbc:postgresql://localhost:5432\"")){
                    flag = false;
                }
                if(!parserDataXML.getNameData().equals("\"itemtrack\"")){
                    flag = false;
                }
                if(!parserDataXML.getPassword().equals("\"admin\"")){
                    flag = false;
                }
                if(!parserDataXML.getUser().equals("\"postgres\"")){
                    flag = false;
                }

                assertThat(flag, is(true));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}