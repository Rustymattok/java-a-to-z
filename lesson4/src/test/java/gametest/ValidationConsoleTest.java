package gametest;

import game.guiconsole.FieldConsole;
import game.logic.ValidationConsole;
import game.models.Computer;
import game.models.Vision;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Class for checking logic of validation.
 */
public class ValidationConsoleTest {
    private FieldConsole field = new FieldConsole(3);
    /**
     * This method check is this EMPTY field or not.
     */
    @Test
    public void whenShouldCheckisEmpty(){
        boolean rezult = false;
        ValidationConsole validate = new ValidationConsole(field);
        field.getListPoint().get(0).setRes(Vision.EMPTY);
        rezult = validate.isEmptyField(field.getListPoint().get(0));
        assertThat(rezult, is(true));
    }
    /**
     * THis method check is this COMPUTER field or not in vertical line.
     */
    @Test
    public void whenShouldCheckisVertical(){
        boolean rezult = false;
        ValidationConsole validate = new ValidationConsole(field);
        field.getListPoint().get(0).setRes(Vision.FIELDCOMP);
        field.getListPoint().get(3).setRes(Vision.FIELDCOMP);
        field.getListPoint().get(6).setRes(Vision.FIELDCOMP);
        rezult = validate.checkVertical(new Computer(field));
        assertThat(rezult, is(true));
    }
    /**
     * THis method check is this COMPUTER field or not in horizontal line.
     */
    @Test
    public void whenShouldCheckisHorizontal(){
        boolean rezult = false;
        ValidationConsole validate = new ValidationConsole(field);
        field.getListPoint().get(0).setRes(Vision.FIELDCOMP);
        field.getListPoint().get(1).setRes(Vision.FIELDCOMP);
        field.getListPoint().get(2).setRes(Vision.FIELDCOMP);
        rezult = validate.checkHorizontal(new Computer(field));
        assertThat(rezult, is(true));
    }
    @Test
    /**
     * THis method check is this COMPUTER field or not in diagonal right line.
     */
    public void whenShouldCheckRight(){
        boolean rezult = false;
        ValidationConsole validate = new ValidationConsole(field);
        field.getListPoint().get(0).setRes(Vision.FIELDCOMP);
        field.getListPoint().get(4).setRes(Vision.FIELDCOMP);
        field.getListPoint().get(8).setRes(Vision.FIELDCOMP);
        rezult = validate.checkRight(new Computer(field));
        assertThat(rezult, is(true));
    }
    /**
     * THis method check is this COMPUTER field or not in diagonal left line.
     */
    @Test
    public void whenShouldCheckLeft(){
        boolean rezult = false;
        ValidationConsole validate = new ValidationConsole(field);
        field.getListPoint().get(2).setRes(Vision.FIELDCOMP);
        field.getListPoint().get(4).setRes(Vision.FIELDCOMP);
        field.getListPoint().get(6).setRes(Vision.FIELDCOMP);
        rezult = validate.checkLeft(new Computer(field));
        assertThat(rezult, is(true));
    }
}

