package trianglearea;

public class Point{
	private double x;
	private double y;
	
	public Point (double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double distanceTo(Point point){
		return Math.sqrt(Math.pow((getX() - point.getX()), 2) + Math.pow((getY() - point.getY()), 2));
	}

	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}
}