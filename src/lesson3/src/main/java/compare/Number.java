package compare;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Number {
    private Integer number;

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
