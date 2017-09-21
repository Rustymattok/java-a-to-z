package learn_thread_part3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rustymattok on 15.09.2017.
 */
public class CountCharTest {
    private String text;
    private CountChar number;

    @Test
    public void whenShouldCheckCalc(){
        text = "dsfsdf fdsf dfsf";
        number = new CountChar(text);
        number.calc();
        System.out.println(number.getCount());
    }

}