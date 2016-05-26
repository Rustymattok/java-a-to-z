package sortBubble;

import java.util.Random;

public class TestBubble
{
    public static void main(String[] args)
    {
        int size = 10;
        int [] value = new int[size];
        Random myRandom = new Random();
        for (int i = 0; i < size ; i++)
        {
            value[i] =  myRandom.nextInt(10);
        }
        Massive massive = new Massive(value);
        massive.showMassive(value);
        massive.sortBubble(value);
        System.out.println();
        massive.showMassive(value);
    }

}
