package learn_thread_part3;
/**
 * This class calculate symbols in text.
 */
public class CountChar implements Runnable,Calculaton {
    private String text;
    private int count;
//todo ввести переменную про время
    public CountChar(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        calc();
    }

    public void calc() {
        char simbol[] = text.toCharArray();
        int i = 0;
        while (i < text.length()){
            if(!Thread.interrupted()) {
                if (simbol[i] != ' ') {
                    count++;
                    System.out.println(count);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Поток прерван из за длительного времени подсчета");
                    return;
                }
                i++;
            }
        }
    }

    public int getCount() {
        return count;
    }
}
