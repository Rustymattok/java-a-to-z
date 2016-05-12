package trianglearea;

public class AreaCalc
{
	public static void main(String[] args){
		Point pointA = new Point(7,1);
		Point pointB = new Point(2,3);
		Point pointC = new Point(3,1);
		Triangle triangle = new Triangle(pointA,pointB,pointC);
		System.out.println(triangle.area());
		MaxSide maxSide = new MaxSide(triangle);
		System.out.println(maxSide.getMaxSide());
	}
}