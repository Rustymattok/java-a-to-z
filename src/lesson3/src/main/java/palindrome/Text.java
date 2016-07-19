package palindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * This class describe text's parametres.
 */
public class Text {
    /**
     * @param text - String parameter (entered text)
     */
    private String text;

    /**
     * Constructor - initialization of parameters using console.
     */
    public Text() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            text = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
