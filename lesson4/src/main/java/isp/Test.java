package isp;
/**
 * Class to show how it works.
 */
public class Test {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.commonChapter("Задача");
        menu.chapter("Задача 1");
        menu.undershupter("Задача 1.1.1");
        menu.undershupter("Задача 1.1.2");
        Menu menu2 = new Menu();
        menu2.chapter("Задача 2");
    }

}