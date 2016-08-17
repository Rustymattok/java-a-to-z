package trianglearea;

public class MaxSide
{
    private double maxSide;

    public MaxSide (Triangle triangle){

        double a = triangle.getA().distanceTo(triangle.getB());
        double b = triangle.getB().distanceTo(triangle.getC());
        double c = triangle.getA().distanceTo(triangle.getC());

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
