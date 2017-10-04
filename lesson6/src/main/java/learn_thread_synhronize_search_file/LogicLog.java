package learn_thread_synhronize_search_file;
/**
 * This class describe of logic for looking needed file.
 */
public class LogicLog {

    private String text;
    private int calc = 0;

    public LogicLog(String text) {
        this.text = text;
    }
    /**
     * This method take list of files, and parsing for text.
     * If during parsing found key word , this file will add to log list.
     */
    public void actionSearch(){
        SeachLogic seachlogic = new SeachLogic(text);
        FileLog fileLog = new FileLog();
        for(String fileName : TakeFile.getList()){
            if(seachlogic.searchText(fileName)){
                fileLog.saveLog(fileName);
            }
        }
    }

    public int getCalc() {
        return calc;
    }
}
