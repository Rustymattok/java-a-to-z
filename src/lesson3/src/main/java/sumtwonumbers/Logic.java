package sumtwonumbers;
/**
 * This class describe logic of this application.
 */
public class Logic {

    public Logic() {
    }
    /**
     * add(Number number1, Number number2) - for calculate sum between two numbers.
     * @param number1 - Number first number.
     * @param number2 - Number second number.
     * @return result of sum.
     */
    public Integer add(Number number1, Number number2){
        return number1.getNumber() + number2.getNumber();
    }
    /**
     * show(Number number1, Number number2) - show result of sum.
     * @param number1 - Number first number.
     * @param number2 - Number second number.
     */
    public void show(Number number1, Number number2){
        System.out.println("Сумма двух чисел равна : " + add(number1,number2));
    }
}
