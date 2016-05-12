package calculiator;

public class Calculator
{
	private double rezult;
	
	public void add(double first,double second){
		rezult = first + second;
	}
	
	public void  substruct(double first,double second){
		rezult = first - second;
	}
	
	public void div(double first,double second){
		rezult = first / second;
	}
	
	public void multiple(double first,double second){
		rezult = first *  second;
	}

	public double getRezult()
	{
		return rezult;
	}
}