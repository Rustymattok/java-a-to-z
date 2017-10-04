package learn_thread_synhronize_search_file;
/**
 * This Thread looking for text in files.
 */
public class ThreadTextSearch implements Runnable {
    /**
     * @param logicLog - parameter from LogicLog which has responsability for searching text.
     */
    private LogicLog logicLog;
    public ThreadTextSearch(LogicLog logicLog) {
        this.logicLog = logicLog;
    }

    @Override
    public void run() {
        action();
    }

    public void action(){
            logicLog.actionSearch();
    }
}
