package evenodd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number implements Methods {

    private Integer number;

    public Number() {
        boolean flag = false;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (!flag){
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

    public void evenOdd(){
        if (number%2 == 0 ){
            System.out.println("Четное число");
        }else
        System.out.println("Нечетное число");
    }

    //test method
    public boolean even() {
        boolean flag = false;
        if (number%2 == 0 ){
           flag = true;
            System.out.println("Четное число");
        }else {
            flag = false;
            System.out.println("Нечетное число");
        }
        return flag;
    }

   //test method
    public boolean odd() {
        boolean flag = false;
        if (number%2 != 0 ){
            flag = true;
            System.out.println("Нечетное число");
        }else {
            flag = false;
            System.out.println("Четное число");
        }
        return flag;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
