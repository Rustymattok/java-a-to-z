package learn_thried_part1;
/**
 * The class which describe thread of calculation spaces.
 */
public class ThreadSpace implements Runnable,Calculation{
    /**
     * @param text - the text that should be parsed.
     * @param count - numbers of spaces.
     */
    private String text;
    private int count = 0;

    public ThreadSpace(String text) {
        this.text = text;
    }
    /**
     *This method start thread .
     */
    @Override
    public void run() {
        System.out.println("Calculation of spaces");
        calulate();
        System.out.println(getCount());
    }
    /**
     * This method calculate quantity of spaces.
     */
    @Override
    public void calulate() {
        char[] symbol;
        symbol = text.toCharArray();
        for (int i = 0; i < symbol.length; i++) {
            if(symbol[i] == ' '){
                count ++;
            }
        }
    }
    public int getCount() {
        return count;
    }
}
