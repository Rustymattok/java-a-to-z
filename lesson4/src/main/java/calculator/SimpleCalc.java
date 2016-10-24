package calculator;
/**
 * Class of Logic part1iterator.bigIterator.simple logic.
 */
public class SimpleCalc {
    public SimpleCalc() {
    }
    /**
     * Method for ADD using two numbers.
     * @param number1 - first number.
     * @param number2 - second number.
     * @return result.
     */
    public double add(double number1, double number2) {
        return number1 + number2;
    }
    /**
     * Method for minus using two numbers.
     * @param number1 - first number.
     * @param number2 - second number.
     * @return result.
     */
    public double minus(double number1, double number2) {
        return number1 - number2;
    }
    /**
     * Method for devoid using two numbers.
     * @param number1 - first number.
     * @param number2 - second number.
     * @return result.
     */
    public double devoid(double number1, double number2) {
        try {
            number1 = number1 / number2;
        } catch (Exception e) {
            new ShowMenu().showErrorDevoid();
        }
        return number1;
    }
    /**
     * Method for multiply using two numbers.
     * @param number1 - first number.
     * @param number2 - second number.
     * @return result.
     */
    public double multiply(double number1, double number2) {
        return number1 * number2;
    }
    /**
     * For Start this class. Main logic of calculate.
     * @param text - for choosing type of work.
     * @param showMenu - for intarface.
     */
    public void action(String text,ShowMenu showMenu) {
        Double result ;
        if (text.equals(ShowMenu.ADD)) {
            result = add(showMenu.enterNumber(), showMenu.enterNumber());
            showMenu.result(result.toString());
        } else if (text.equals(ShowMenu.MINUS)) {
            result = minus(showMenu.enterNumber(), showMenu.enterNumber());
            showMenu.result(result.toString());
        } else if (text.equals(ShowMenu.MULTY)) {
            result = multiply(showMenu.enterNumber(), showMenu.enterNumber());
            showMenu.result(result.toString());
        } else if (text.equals(ShowMenu.DEVOID)) {
            result = devoid(showMenu.enterNumber(), showMenu.enterNumber());
            showMenu.result(result.toString());
        }
    }

}
