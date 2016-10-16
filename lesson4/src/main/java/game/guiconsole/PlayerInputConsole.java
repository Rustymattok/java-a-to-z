package game.guiconsole;
import game.interfaces.Coordinate;
import game.models.Point;
import game.models.Vision;

import java.util.Scanner;
/**
 * Class for enter point for player.
 */
public class PlayerInputConsole implements Coordinate {
    private Scanner scanner = new Scanner(System.in);
    /**
     * Enter point for player/computer.
     * @return Point.
     */
    public Point enterText(){
        String text1 = "";
        text1 = isText(text1,"X");
        String text2 = "";
        text2 = isText(text2,"Y");
        return new Point(Integer.parseInt(text1),Integer.parseInt(text2), Vision.FIELDPL);
    }

    public String enterName(){
        System.out.print("Enter your name : ");
        String text = scanner.nextLine();
        return text;
    }
    /**
     * This method validate values which were enterd. Integer - allow.
     * @param x - String for validate.
     * @return true/false.
     */
    public boolean isInt(String x){
        boolean flag = false;
        try{
            Integer.parseInt(x);
            flag = true;
        }catch (NumberFormatException e){
            System.out.println("Uncorrect entered, repeat please.");
        }
        return flag;
    }
    /**
     * This method allow to enter values with validation. Using ths method we can exit from console application.
     * Command "exit" - exit from app.
     * @param text - String parameter for value.
     * @return text - value for parserInt.
     */
    public String isText(String text,String axe){
        boolean flag = false;
        while (!flag){
            System.out.printf("Enter %s coordinate",axe);
            System.out.println();
            text = scanner.nextLine();
            if (text.equals("exit")){
                System.exit(0);
            }
            flag = isInt(text);
        }
        return text;
    }
}

