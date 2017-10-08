package learn_thread_synhronize_search_file;
/**
 * This class describe of logic for looking needed file.
 */
final class LogicLog {

    private String text;
    private Deque deque;

    LogicLog(Deque deque,String text) {
        this.text = text;
        this.deque = deque;
    }

    /**
     * This method take list of files, and parsing for text.
     * If during parsing found key word , this file will add to log list.
     */
    final void actionSearch(){
        SeachLogic seachlogic = new SeachLogic(text);
        FileLog fileLog = new FileLog();
        String fileName="";
        while (deque.getStatesPeek() != null){
            fileName = deque.getStatesPop();
            System.out.println(fileName);
            if(seachlogic.searchText(fileName)){
                fileLog.saveLog(fileName);
            }
        }
    }
}
