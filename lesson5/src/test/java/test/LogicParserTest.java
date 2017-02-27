package test;

import org.junit.Test;

import java.util.HashMap;

/**
 * Class for testing class.
 */
public class LogicParserTest {
    @Test
    public void whenShouldParser() throws Exception {
        LogicParser logicParser = new LogicParser();
        long startTime = System.currentTimeMillis();
        logicParser.bufferFile();
        logicParser.checkCondition();
        long totalTime = System.currentTimeMillis() - startTime;
        System.out.println(totalTime);
        System.out.println("Quantities of orders : = " + logicParser.getListNew().size());
        for (HashMap.Entry<Integer, Order> entry : logicParser.getListNew().entrySet()) {
            if(entry.getValue().getOperation().equals("SELL"))
            System.out.println(entry.getValue().getPrice() + "      " + entry.getKey() );
        }
    }
}
