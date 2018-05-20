package tracker;

import tracker.start.ConsoleInput;
import tracker.start.LogicUI;
import tracker.start.ShowMenu;
import tracker.start.Tracker;
import tracker.start.DataBase;
import tracker.start.ParserDataXML;
import tracker.start.WorkBase;
/**
 * Start aplication.
 */
public class StartUI {
    public static void main(String[] args)  {
        try {
            ShowMenu menu = new ShowMenu();
            ParserDataXML parserDataXML = new ParserDataXML("F:\\JAVA\\java-a-to-z\\lesson7\\src\\main\\java\\tracker\\files\\data.xml");
            //WorkBase workBase = new WorkBase("jdbc:postgresql://localhost:5432","tracker","postgres","admin");
            parserDataXML.parser();
            System.out.println(parserDataXML.getUser());
            WorkBase workBase = new WorkBase(parserDataXML.getUrl(),parserDataXML.getNameData(),parserDataXML.getUser(),parserDataXML.getPassword());
            DataBase dataBase = new DataBase(workBase);
            dataBase.connectToDataBase();
            try(Tracker tracker = new Tracker(dataBase)) {
                ConsoleInput input = new ConsoleInput();
                LogicUI logicUI = new LogicUI(tracker, input, menu);
                menu.showInfo();
                logicUI.acton();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}