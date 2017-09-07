package learn_thried_part1;

public class ThreadWord implements Runnable,Calculation{
    /**
     * @param text - the text that should be parsed.
     * @param count - numbers of spaces.
     */
    private String text;
    private int count = 0;

    public ThreadWord(String text) {
        this.text = text;
    }
    /**
     *This method start thread .
     */
    @Override
    public void run() {
        System.out.println("Calculation of word");
        calulate();
        //todo
        System.out.println(getCount());
    }
    /**
     * This method calculate quantity of word.
     */
    @Override
    public void calulate() {
        char[] symbol;
        symbol = text.toCharArray();
        int i = 1;
        while (i < text.length()){
            if (symbol[i - 1] == ' ' && symbol[i] == ' '){
                count = getCount();
            } else
                if(symbol[i] == ' '){
                count++;
            }
            i++;
        }
        if (symbol[text.length()-1] != ' '){
            count++;
        }
    }
    public int getCount() {
        return count;
    }
}
