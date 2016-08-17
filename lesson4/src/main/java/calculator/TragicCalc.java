package calculator;
/**
 * Class describe logic of tragic calculation.
 */
public class TragicCalc extends SimpleCalc {

    public TragicCalc() {
        super();
    }
    /**
     * Method for calculate summ of sin two numbers.
     * @param number1 - first angle.
     * @param number2 - second angle.
     * @return - result of sum.
     */
    public double addSin(double number1, double number2){
        number1 = (double) Math.round(Math.sin(Math.toRadians(number1))* 100000000000L) / 100000000000L;
        number2 = (double) Math.round(Math.sin(Math.toRadians(number2))* 100000000000L) / 100000000000L;
        return number1 + number2;
    }
    /**
     * Method for start logic.
     * @param text - for choosing type of work.
     * @param showMenu - for intarface.
     */
    @Override
    public void action(String text, ShowMenu showMenu) {
        super.action(text, showMenu);
        Double result ;
        if (text.equals(ShowMenuTragicCalc.ADDSIN)) {
            result = addSin(showMenu.enterNumber(), showMenu.enterNumber());
            showMenu.result(result.toString());
        }
    }
}
