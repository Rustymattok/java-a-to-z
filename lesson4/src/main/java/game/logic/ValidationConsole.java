package game.logic;

import game.guiconsole.FieldConsole;
import game.interfaces.Condition;
import game.interfaces.Person;
import game.interfaces.Validation;
import game.models.Point;
import game.models.Vision;

/**
 * Class for validation in concsole game.
 */
public class ValidationConsole implements Validation,Condition {
    private FieldConsole field;

    public ValidationConsole(FieldConsole field) {
        this.field = field;
    }
    /**
     * Allow to check point in Field.
     * @param point -for check.
     * @return true/false.
     */
    public boolean isEmptyField(Point point) {
        boolean flag = false;
        int index = 0;
        for (int i = 0; i < field.getSIZE(); i++) {
            for (int j = 0; j < field.getSIZE(); j++) {
                if (point.getX() == field.getListPoint().get(index).getX() && point.getY() == field.getListPoint().get(index).getY() ){
                    if (field.getListPoint().get(index).getRes() == Vision.EMPTY){
                        flag = true;
                        break;
                    }
                }
                index++;
            }
        }
        return flag;
    }
//todo проверить на унивресальность проверку полейпри помощи тестов..
    /**
     * Allow to check win position in logic game.
     * @param person - for check his parameter.
     * @return true/false
     */
    public boolean isFullField(Person person) {
        boolean flag = false;
        if(checkHorizontal(person)){
            flag = true;
            person.takeFlag();
        }else if (checkVertical(person)){
            flag = true;
            person.takeFlag();
        }else if (checkRight(person)){
            flag = true;
            person.takeFlag();
        }else if (checkLeft(person)){
            flag = true;
            person.takeFlag();
        }
        return flag;
    }
    /**
     * To check vertical - win or not.
     * @param person - player/computer
     * @return true/false.
     */
    public boolean checkVertical(Person person) {
        boolean flag = false;
        int index;
        for (int i = 0; i < field.getSIZE(); i++) {
            index = 0;
            for (int j = 0; j < field.getSIZE(); j++) {
                if(field.getListPoint().get(j*field.getSIZE() + i).getRes() == person.getVision() ){
                    index ++;
                }
                if(index == field.getSIZE()){
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
    /**
     * To check horizontal - win or not.
     * @param person - player/computer
     * @return true/false.
     */
    public boolean checkHorizontal(Person person) {
        boolean flag = false;
        int index;
        for (int i = 0; i < field.getSIZE(); i++) {
            index = 0;
            for (int j = 0; j < field.getSIZE(); j++) {
                if(field.getListPoint().get((i*field.getSIZE()) + j).getRes() == person.getVision() ){
                    index ++;
                }
                if(index == field.getSIZE()){
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
    /**
     * To check right diagonal - win or not.
     * @param person - player/computer
     * @return true/false.
     */
    public boolean checkRight(Person person) {
        boolean flag = false;
        int index;
        for (int i = 0; i < field.getSIZE(); i++) {
            index = 0;
            for (int j = 0; j < field.getSIZE(); j++) {
                if(field.getListPoint().get((field.getSIZE() + 1) * j).getRes() == person.getVision() ){
                    index ++;
                }
                if(index == 3){
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
    /**
     * To check left diagonal - win or not.
     * @param person - player/computer
     * @return true/false.
     */
    public boolean checkLeft(Person person) {
        boolean flag = false;
        int index;
        for (int i = 0; i < field.getSIZE(); i++) {
            index = 0;
            for (int j = 0; j < field.getSIZE(); j++) {
                if(field.getListPoint().get((field.getSIZE()-1) * (j + 1)).getRes() == person.getVision() ){
                    index ++;
                }
                if(index == 3){
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
}

