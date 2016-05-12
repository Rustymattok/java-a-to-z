package trianglearea;

public class MaxSide
{
    private double maxSide;

    public MaxSide (Triangle triangle){

        double a = triangle.getSizeAB();
        double b = triangle.getSizeBC();
        double c = triangle.getSizeAC();

        if (a > b && b < c){
            maxSide = a;
        }else if(b > c){
            maxSide = b;
        }else {
            maxSide = c;
        }
    }

    public double getMaxSide()
    {
        maxSide = Math.rint(100.0 * maxSide) / 100.0;
        return maxSide;
    }
}
