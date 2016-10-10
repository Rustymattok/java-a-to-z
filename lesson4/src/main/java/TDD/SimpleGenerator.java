package TDD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class describe logic.
 */
public class SimpleGenerator implements Template {
    /**
     * This method allow to modify text using key - value.
     * @param text
     * @param values
     * @return text
     */
    public String generate(String text, Pair[] values) {
        text.trim();
        int flag = 0;
        for (int i = 0; i < values.length ; i++) {
            if(validate(text)) {
                text = text.replace(values[i].getKey(), values[i].getValue());
                flag ++;
            }
        }
        if(validate(text)){
            text = "error";
        }else if(flag != values.length) {
            text = "error";
        }
        return text;
    }
    /**
     * This method check condition for validate text true or false.
     * @param text
     * @return
     */
    public boolean validate(String text) {
        boolean flag = false;
        Pattern p = Pattern.compile("[$][{].+?[}]");
        Matcher m = p.matcher(text);
        if(m.find()){
            flag = true;
        }
        return flag;
    }
}