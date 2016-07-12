package sumtwonumbers;

public class StartUI {
    public static void main(String[] args) {
        Number number1 = new Number();
        Number number2 = new Number();
        System.out.println("Сумма двух чисел равна: " + StartUI.add(number1,number2));
    }

    public static Integer add(Number number1, Number number2){
        return number1.getNumber() + number2.getNumber();
    }
}
