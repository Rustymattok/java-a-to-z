package trianglearea;

public class Triangle {
	private Point a;
	private Point b;
	private Point c;

	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double area() {
		double area;
		double p;

		if(!checkArea(a,b,c)){
			return -1;
		}else
		{
			p = (a.distanceTo(b) + b.distanceTo(c) + a.distanceTo(c))/2;
			area = Math.sqrt((p * (p - a.distanceTo(b)) * (p - b.distanceTo(c)) * (p - a.distanceTo(c))));
			area = Math.rint(100.0 * area) / 100.0;
			return area;
		}
	}

	public boolean checkArea(Point a, Point b, Point c){
		return ((b.getX() - a.getX()) * (c.getY() - a.getY()) - ((c.getX() - a.getX()) * (b.getY() - a.getY()))) != 0 ;
	}

	public Point getA()
	{
		return a;
	}

	public Point getB()
	{
		return b;
	}

	public Point getC()
	{
		return c;
	}

}