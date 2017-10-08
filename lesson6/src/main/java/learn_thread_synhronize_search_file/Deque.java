package learn_thread_synhronize_search_file;
import java.util.ArrayDeque;
/**
 * Class deque for save information.
 */
final class Deque {
   private ArrayDeque<String> states = new ArrayDeque<String>();

   final synchronized void addFile(String fileName){
       states.add(fileName);
   }
    /**
     *
     * @return -  element of beggining Deque with removing it.
     */
    final synchronized String getStatesPeek() {
        return states.peek();
    }

    final synchronized  String getStatesPop(){
        return states.pop();
    }

    final synchronized int getSize(){
        return states.size();
    }
}
