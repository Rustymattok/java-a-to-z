package game.guiconsole;

import game.guiconsole.FieldConsole;
import game.interfaces.Person;
import game.interfaces.ShowGame;
import game.models.Vision;

/**
 * Class for show game in console
 */
public class ShowGameConsole implements ShowGame {
    private FieldConsole field;

    public ShowGameConsole(FieldConsole field) {
        this.field = field;
    }

    public void showMenu() {
        System.out.println("<------------------------>");
        System.out.println("   For exit of programm   ");
        System.out.println("   Put command 'exit'     ");
    }

    public void showField() {
        int index = 0;
        for (int i = 0; i < field.getSIZE(); i++) {
            for (int j = 0; j < field.getSIZE(); j++) {
                if (field.getListPoint().get(index).getRes() == Vision.EMPTY){
                    System.out.print("  -  ");
                } else if (field.getListPoint().get(index).getRes() == Vision.FIELDCOMP){
                    System.out.print("  0  ");
                } else if (field.getListPoint().get(index).getRes() == Vision.FIELDPL){
                    System.out.print("  x  ");
                }
                index ++;
            }
            System.out.println();
        }
    }

    public void showVictory(Person person) {
        System.out.println(person.name().concat(" win!!!"));
    }

    public void turnText(){
        System.out.println("Turn of computer");
    }

}

