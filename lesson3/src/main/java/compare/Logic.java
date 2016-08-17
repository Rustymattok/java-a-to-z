package compare;
/**
 * This class describe logic of this application.
 */
public class Logic {
    /**
     * @param Number number - application's logic work with this parameter.
     */
    private Number number;

    public Logic() {
    }
    /**
     * method compare three numbers and choose minimum.
     */
    public Number compare(Number number1, Number number2, Number number3){
        number = minimum(number1, minimum(number2, number3));
        return number;
    }
    /**
     * method compare two numbers and choose minimum.
     */
    public Number minimum(Number number1, Number number2){
        int a = Math.abs(number1.getNumber());
        int b = Math.abs(number2.getNumber());
        if (a < b){
            number = number1;
        }else {
            number = number2;
        }
        return  number;
    }
    /**
     * show result in console.
     */
    public void show(){
        System.out.println("Минимальное число равно :" + number.getNumber());
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }
}
