package compare;

public class StartUI {
    public static void main(String[] args) {
        Number number1 = new Number();
        Number number2 = new Number();
        Number number3 = new Number();
        compare(number1,number2,number3);
    }

    public static void compare(Number number1,Number number2,Number number3){
        if(Math.abs(number1.getNumber()) < Math.abs(number2.getNumber())) {
            if (Math.abs(number2.getNumber()) <  Math.abs(number3.getNumber())){
                System.out.println(number1.getNumber());
            }else if (Math.abs(number3.getNumber()) <  Math.abs(number1.getNumber())){
                System.out.println(number3.getNumber());
              }
        }else {
                 System.out.println(number2.getNumber());
             }
        }
    }

