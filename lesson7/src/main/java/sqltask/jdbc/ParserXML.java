package sqltask.jdbc;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
/**
 * Class for parsing XML for calculation and reciving middle of sum.
 */
public class ParserXML {
    /**
     * @param list - for data of numbers after parsing.
     * @param parserFileWay - for indicate of parsing file.
     */
    private HashSet<Integer> list = new HashSet<Integer>();
    private String parserFileWay;

    public ParserXML(String parserFileWay) {
        this.parserFileWay = parserFileWay;
    }
    /**
     * This method make parsing for all document line by line.
     * @throws IOException
     */
    public void parser() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(parserFileWay));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.startsWith("<entry field=")) {
                list.add(parserline(line));
            }
        }
        bufferedReader.close();
    }
    /**
     * This method for parsing only one line.
     * @param text -  init of line for parsing.
     * @return
     */
    public Integer parserline(String text){
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))){
                result = new StringBuilder().append(result).append(text.charAt(i)).toString();
            }
        }
        return Integer.parseInt(result);
    }
    /**
     * This method for calculation regarding task.
     * @return
     */
    public Double calculate() {
        Double sum = 0.0;
        int i = 0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            sum = sum + Integer.parseInt(iterator.next().toString());
            i++;
        }
        System.out.println(sum);
        System.out.println(i);
        return sum / i;
    }

    public void show(){
        System.out.println(calculate());
    }


}
