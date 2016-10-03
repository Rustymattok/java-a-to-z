package isp;
/**
 * Class wich describe menu.
 */
public class Menu implements MainMenu,Chapter,UnderChapter {

    public void chapter(String text) {
        System.out.printf("--%s",text);
        System.out.println();
    }

    public void commonChapter(String text) {
        System.out.printf("%s",text);
        System.out.println();
    }

    public void undershupter(String text) {
        System.out.printf("----%s",text);
        System.out.println();
    }
}
