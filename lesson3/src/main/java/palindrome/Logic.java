package palindrome;
/**
 * This class describe logic of this application.
 */
public class Logic {
    /**
     * @param Text text - application's logic work with this parameter.
     */
    private Text text;

    public Logic(Text text) {
        this.text = text;
    }
    /**
     * This method makes reverse of text.
     * @param text - parameter for reverse.
     * @return - result of this method text will be reverse.
     */
    public String  reverseText(Text text){
        StringBuffer reverseText;
        reverseText = new StringBuffer(text.getText());
        reverseText = reverseText.reverse();
        return new String(reverseText);
    }
    /**
     * This method compare text befor and after.
     * @param text - parameter before reverse.
     * @param reverseText - parameter after reverse.
     * @return - result of this method text belongs to palindrome or not (true / false).
     */
    public boolean compareString(Text text, String reverseText){
        boolean flag = false;
        if (text.getText().equals(reverseText)){
            flag = true;
        }
        return flag;
    }
    /**
     * show() - show result in console.
     */
    public void show(){
        if (compareString(text,reverseText(text))){
            System.out.println("true " + text.getText() + " --> " + reverseText(text));
        }else {
            System.out.println(text.getText() + " --> " + " не полиндром ");
        }
    }
}
