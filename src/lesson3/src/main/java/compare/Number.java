package compare;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * This class describe number's parametres.
 */
public class Number {
    /**
     * @param Integer number - value.
     */
    private Integer number;
    /**
     * Constructor - initialization of parameters using console.
     */
    public Number() {
        boolean flag = false;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (!flag) {
            try {
                System.out.println("Введите число : ");
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
}
