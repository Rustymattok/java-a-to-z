package part1lesson4task2;

public class Massive
{
    private int[][] value;

    public Massive(int[][] value){
        this.value = value;
    }

    public void sortMassive(int[][] value){
        for (int i = 0; i < value.length ; i++)
        {
            for (int j = 0; j <value.length ; j++)
            {
                value[i][j] = -(value.length-2-j);
            }
        }
    }

    public void showMassive(int[][] value){
        for (int i = 0; i < value.length ; i++)
        {
            for (int j = 0; j < value.length; j++)
            {
                System.out.print(" " + value[i][j]);
            }
            System.out.println();
        }
    }

    public int[][] getValue()
    {
        return value;
    }

    public void setValue(int[][] value)
    {
        this.value = value;
    }
}
