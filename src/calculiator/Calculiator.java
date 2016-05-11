package calculiator;

public class Calculiator{
	private double rezult;
	
	public void add(double first,double second){
		rezult = first + second;
		System.out.println(rezult);
	}
	
	public void  substruct(double first,double second){
		rezult = first - second;
		System.out.println(rezult);
	}
	
	public void div(double first,double second){
		rezult = first / second;
		System.out.println(rezult);
	}
	
	public void multiple(double first,double second){
		rezult = first *  second;
		System.out.println(rezult);
	}
}