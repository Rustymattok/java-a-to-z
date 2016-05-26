package calculiator;

public class CalcInt{
	public static void main(String[] args){
		double first = 4;
		double second = 2;
		Calculator calc = new Calculator();
		calc.add(first,second);
		System.out.println(calc.getRezult());
		calc.substruct(first, second);
		System.out.println(calc.getRezult());
		calc.div(first, second);
		System.out.println(calc.getRezult());
		calc.multiple(first, second);
		System.out.println(calc.getRezult());
	}
}