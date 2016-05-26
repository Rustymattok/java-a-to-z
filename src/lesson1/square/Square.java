package square;

public class Square
{
    private float a;
    private float b;
    private float c;

    public Square(float a,float b,float c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public float calculate(int x){
        float rezult;
        rezult = (float) (a * Math.pow((float)x, 2) + b * (float)x + c);
        return rezult;
    }

    public void show(int x1,int x2,int step){
        for (int i = x1; i < x2 ; i = i + step)
        {
            System.out.println(calculate(i));
        }

    }
}
