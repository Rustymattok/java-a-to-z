package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * This class describe logic of parsing xml files.
 */
public class LogicParser {

    private HashMap<Integer,Order> listFromParser = new HashMap<Integer, Order>();
    private HashMap<Integer,Order> listSorted = new HashMap<Integer, Order>();
    private Order order;
    /**
     * Method of parsing common files.
     */
    void bufferFile(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home") + "\\temp\\orders.xml"));
            String line;
            int i = 0;
                while ((line = br.readLine()) != null) {
                        i++;
                        if (line.startsWith("<A")) {
                            order = parser(line);
                            listFromParser.put(i, order);
                        } else if (line.startsWith("<D")) {
                            listFromParser.remove(parserDelete(line));
                        }
                }
            checkCondition();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * Method calculate id order, which have TAG DELETE.
     * @param text - text of line.
     * @return id of order to delete.
     */
    public Integer parserDelete(String text){
        boolean start = false;
        int current = 0;
        int pos = -1;
        String[] values = new String[2];
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '\"') {
                if (start) {
                    values[current++] = text.substring(pos + 1, i);
                    start = false;
                } else {
                    start = true;
                }
                pos = i;
            }
        }
        int id = Integer.parseInt(values[1]);
        return id;
    }
    /**
     * This method make parsing for TAG ADD.
     * @param text - text of line.
     * @return new order to collection.
     */
    public Order parser(String text){
        boolean start = false;
        int current = 0;
        int pos = -1;
        String[] values = new String[5];
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '\"') {
                if (start) {
                    values[current++] = text.substring(pos + 1, i);
                    start = false;
                } else {
                    start = true;
                }
                pos = i;
            }
        }
        return  new Order(values[0],values[1],values[2],values[3],Integer.parseInt(values[4]));
    }

    public void checkCondition() {
        MyIterator<Order> it = new MyIterator(listFromParser);
        while (it.hasNext()) {
            Order orderCompare = it.next();
            if(order != null && orderCompare != null) {
                if (order.getOperation().equals("BUY")) {
                    if (order.getName().equals(orderCompare.getName())) {
                        if (order.getVolume().equals(orderCompare.getVolume())) {
                            if (Double.parseDouble(order.getPrice()) > Double.parseDouble(orderCompare.getPrice())) {
                                listFromParser.remove(orderCompare);
                                listSorted.put(orderCompare.getId(),orderCompare);
                            }
                        }
                    }
                }
            }
        }

        }

    public HashMap<Integer, Order> getListFromParser() {
        return listFromParser;
    }

    public HashMap<Integer, Order> getListSorted() {
        return listSorted;
    }
}
