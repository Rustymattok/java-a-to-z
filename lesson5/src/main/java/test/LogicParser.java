package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.Iterator;

/**
 * This class describe logic of parsing xml file.
 */
public class LogicParser {
    private BufferedReader br;
    private TreeMap<Integer,Order> listNew = new TreeMap<Integer, Order>();
    private Order order;
    /**
     * Method of parsing common file.
     */
    void bufferFile(){
        try {
            br = new BufferedReader(new FileReader(System.getProperty("user.home") + "\\temp\\orders.xml"));
            String line;
            int i = 0;
                while ((line = br.readLine()) != null) {
                        i++;
                        if (line.startsWith("<A")) {
                            order = parser(line);
                            listNew.put(i, order);
                            checkCondition();
                        } else if (line.startsWith("<D")) {
                            listNew.remove(parserDelete(line));
                        }
                }
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
        MyIterator<Order> it = new MyIterator(listNew);
        while (it.hasNext()) {
            Order orderCompare = it.next();
            if(order != null && orderCompare != null) {
                if (order.getOperation().equals("BUY")) {
                    if (order.getName().equals(orderCompare.getName())) {
                        if (order.getVolume().equals(orderCompare.getVolume())) {
                            if (Double.parseDouble(order.getPrice()) > Double.parseDouble(orderCompare.getPrice())) {
                                it.remove();
                            }
                        }
                    }
                }
            }
        }

//        for (Map.Entry<Integer, Order> entry : getListNew().entrySet()) {
//        if (order.getOperation().equals("BUY")) {
//            if (order.getName().equals(entry.getValue().getName())) {
//                if (order.getVolume().equals(entry.getValue().getVolume())) {
//                    if (Double.parseDouble(order.getPrice()) > Double.parseDouble(entry.getValue().getPrice())) {
//                        listNew.remove(entry.getKey());
//                    }
//                }
//            }
//        }
//    }


//            if(order.getOperation().equals("SELL")){
//                if(order.getName().equals(entry.getValue().getName())){
//                    if(order.getVolume().equals(entry.getValue().getVolume())){
//                        if(Double.parseDouble(order.getPrice()) < Double.parseDouble(entry.getValue().getPrice())){
//                            listNew.remove(entry.getKey());
//                        }
//                    }
//                }
//            }
        }

    public TreeMap<Integer, Order> getListNew() {
        return listNew;
    }
}
