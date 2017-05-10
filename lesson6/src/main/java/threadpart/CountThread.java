package threadpart;
/**
 * Class describe Thread logic.
 */
public class CountThread implements Runnable{
    /**
     * @param String - name of thread.
     * @param Text - text wich we need parsing.
     * @param int  - count value of calculating symbels word/space.
     */
    private String name;
    private Text text;
    private int count ;

    public CountThread(String name,Text text) {
        this.name = name;
        this.text = text;
    }
    /**
     * Method wich describe mail logic of thead.
     * It depends of two values. word and space - diference logic.
     */
    @Override
    public void run() {
        char[] symbol;
        count = 0;
        int i = 0;
        symbol = text.getText().toCharArray();
        while(i < symbol.length) {
            if(!Thread.interrupted()) {
                if (name.equals("space")) {
                    if (symbol[i] == ' ') {
                        count++;
                        showThread();
                    }
                } else if (name.equals("word")) {
                    if (symbol[i] == ' ' || (i + 1) >= text.getText().length()) {
                        count++;
                        showThread();
                    }
                }
                i++;
            }
            else {
                System.out.println(name + " поток прерван ");
                show();
                return;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(name + " поток прерван ");
                show();
                return;
            }
        }
        show();
    }

    public int getCount() {
        return count;
    }

    public void show(){
        System.out.println(name + " " +  getCount());
    }

    public void showThread(){
        System.out.printf("%s  --- поток работает ---> %s", name, getCount());
        System.out.println();
    }
}
