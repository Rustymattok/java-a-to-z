package sortBubble;

public class Massive
{
    private int[] value;

    public Massive(int[] value){
        this.value = value;
    }

    public void sortBubble(int[] value){
        for (int i = 0; i < value.length; i++) {
            int min = value[i];
            int min_i = i;

            for (int j = i+1; j < value.length; j++) {
                if (value[j] < min) {
                    min = value[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                int tmp = value[i];
                value[i] = value[min_i];
                value[min_i] = tmp;
            }
        }
    }

    public void showMassive(int[] value){
        for (int i = 0; i < value.length ; i++)
        {
            System.out.print(" " + value[i]);
        }
    }

    public int[] getValue()
    {
        return value;
    }

    public void setValue(int[] value)
    {
        this.value = value;
    }
}
