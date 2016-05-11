package calculiator;

public class CalcInt{
	public static void main(String[] args){
		double first = 4;
		double second = 2;
		Calculiator calc = new Calculiator();
		calc.add(first,second);
		calc.substruct(first,second);
		calc.div(first,second);
		calc.multiple(first,second);
	}
}