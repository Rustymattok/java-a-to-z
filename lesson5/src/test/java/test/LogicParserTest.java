package test;

import org.junit.Test;
/**
 * Class for testing class.
 */
public class LogicParserTest {
    @Test
    public void whenShouldParser() throws Exception {
        LogicParser logicParser = new LogicParser();
        long startTime = System.currentTimeMillis();
        logicParser.bufferFile();
        long totalTime = System.currentTimeMillis() - startTime;
        System.out.println(totalTime);
        System.out.println("Quantities of orders : = " + logicParser.getListNew().size());
    }

}