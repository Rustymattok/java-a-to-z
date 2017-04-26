package test;

import org.junit.Test;

import java.util.HashMap;

/**
 * Class for testing class.
 */
public class LogicParserTest {
    @Test
    public void whenShouldParser() throws Exception {
        int count = 0 ;
        LogicParser logicParser = new LogicParser();
        long startTime = System.currentTimeMillis();
        logicParser.bufferFile();
        long totalTime = System.currentTimeMillis() - startTime;
        System.out.println(totalTime);
//        System.out.println("Quantities of orders : = " + logicParser.getListRemove().size());
        for (HashMap.Entry<Integer, Order> entry : logicParser.getListRemove().entrySet()) {
            if(entry.getValue().getOperation().equals("SELL")){
                count++;
                System.out.println(entry.getValue().getPrice() + "      " + entry.getKey() );
            }
        }
        System.out.printf("Quantities of orders : = %s", Integer.toString(count));
    }
}
