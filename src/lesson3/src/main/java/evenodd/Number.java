package evenodd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * This class describe number's parametres.
 */
public class Number {
    /**
     * @param Integer number - value.
     * @param Discribe discribe - the enumeration of two position.
     */
    private Integer number;
    private Discribe discribe;
    /**
     * Constructor - initialization of parameters using console.
     */
    public Number() {
        boolean flag = false;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (!flag) {
            try {
                System.out.println("Введите число: ");
                number = Integer.valueOf(bufferedReader.readLine());
                flag = true;
            } catch (Exception e) {
                System.out.println("Не корректный ввод числа");
                flag = false;
            }
        }
    }

    public Number(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Discribe getDiscribe() {
        return discribe;
    }

    public void setDiscribe(Discribe discribe) {
        this.discribe = discribe;
    }
}
