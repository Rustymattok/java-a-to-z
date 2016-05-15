package trianglearea;

public class AreaCalc
{
	public static void main(String[] args){
		Point pointA = new Point(0,0);
		Point pointB = new Point(1,1);
		Point pointC = new Point(2,2);
		Triangle triangle = new Triangle(pointA,pointB,pointC);
		System.out.println(triangle.area());
		MaxSide maxSide = new MaxSide(triangle);
		System.out.println(maxSide.getMaxSide());
	}
}