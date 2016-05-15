package trianglearea;

public class Triangle {
	private Point a;
	private Point b;
	private Point c;
	private double sizeAB;
	private double sizeBC;
	private double sizeAC;

	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
		sizeAB = Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow((a.getY() - b.getY()), 2));
		sizeBC = Math.sqrt(Math.pow((b.getX() - c.getX()), 2) + Math.pow((b.getY() - c.getY()), 2));
		sizeAC = Math.sqrt(Math.pow((a.getX() - c.getX()), 2) + Math.pow((a.getY() - c.getY()), 2));
	}

	public double area() {
		double area;
		double p;

		if(!checkArea(a,b,c)){
			return -1;
		}else
		{
			p = (getSizeAB() + getSizeBC() + getSizeAC())/2;
			area = Math.sqrt((p * (p - getSizeAB()) * (p - getSizeBC()) * (p - getSizeAC())));
			area = Math.rint(100.0 * area) / 100.0;
			return area;
		}
	}

	public boolean checkArea(Point a, Point b, Point c){
		boolean flag = true;
		if(((b.getX() - a.getX()) * (c.getY() - a.getY()) - ((c.getX() - a.getX()) * (b.getY() - a.getY()))) == 0){
			flag =  false;
		}
		return flag;
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

	public double getSizeAB()
	{
		return sizeAB;
	}

	public double getSizeBC()
	{
		return sizeBC;
	}

	public double getSizeAC()
	{
		return sizeAC;
	}
}