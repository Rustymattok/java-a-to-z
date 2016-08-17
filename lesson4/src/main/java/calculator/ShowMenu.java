package calculator;

import java.util.Scanner;
/**
 * Class for show annd enter text.
 */
public class ShowMenu {
    /**
     * Const of ShowMenu.
     */
    protected static final String ADD = "сложение";
    protected static final String MINUS = "вычитание";
    protected static final String DEVOID = "деление";
    protected static final String MULTY = "умножение";
    protected static final String EXIT = "exit";
//    protected static final String ADDSIN = "сложение синусов";
    private Scanner scanner = new Scanner(System.in);

    public void showMenu(){
        System.out.println("- сложение");
        System.out.println("- вычитание");
        System.out.println("- деление");
        System.out.println("- умножение");
        System.out.println("- exit");
    }

    public void showErrorDevoid(){
        System.out.println("Число на 0 не делится. ");
    }
    /**
     * Method for entering numbers.
     * @return numbers.
     */
    public Double enterNumber(){
        System.out.println("Введите число");
        return scanner.nextDouble();
    }

    public void result(String s){
        System.out.printf("Ответ: %s",s);
        System.out.println();
    }

    public void chooseOperation(){
        System.out.println("Выбирите операцию ");
    }
}
