package part1lesson4task2;

import java.util.Random;

public class TestMassiv
{
    public static void main(String[] args)
    {
        int size = 2;
        int [][] value = new int[size][size];
        Random myRandom = new Random();
        for (int i = 0; i < size ; i++)
        {
            for (int j = 0; j < size ; j++)
            {
                value[i][j] =  size-1-i;
            }
        }
        Massive massive = new  Massive(value);
        massive.showMassive(value);
        System.out.println();
        massive.sortMassive(value);
        massive.showMassive(value);
        System.out.println();
    }
}
