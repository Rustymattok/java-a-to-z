package evenodd;
/**
 * This class describe logic of this application.
 */
public class Logic {
    /**
     * @param Number number - application's logic work with this parameter.
     */
    private Number number;

    public Logic(Number number) {
        this.number = number;
    }
    /**
     * evenOdd() - method determines qualification of number and set describe.
     */
    public void evenOdd() {
        if (number.getNumber() % 2 == 0) {
            number.setDiscribe(Discribe.EVEN);
        } else
            number.setDiscribe(Discribe.ODD);
    }
    /**
     * simple() - method for test number for simple.
     */
    public boolean even() {
        boolean flag = false;
        if (number.getNumber() % 2 == 0) {
            flag = true;
            number.setDiscribe(Discribe.EVEN);
        } else {
            flag = false;
            number.setDiscribe(Discribe.ODD);
        }
        return flag;
    }
    /**
     * odd() - method for test number for odd.
     */
    public boolean odd() {
        boolean flag = false;
        if (number.getNumber() % 2 != 0) {
            flag = true;
            number.setDiscribe(Discribe.ODD);
        } else {
            flag = false;
            number.setDiscribe(Discribe.EVEN);
        }
        return flag;
    }
    /**
     * show() - show result in console.
     */
    public void show(){
        if (number.getDiscribe() == Discribe.EVEN){
            System.out.println("Введенное число четное");
        }else if (number.getDiscribe() == Discribe.ODD){
            System.out.println("Введенное число не четное");
        } else {
            System.out.println("Не верный параметр");
        }
    }
}
