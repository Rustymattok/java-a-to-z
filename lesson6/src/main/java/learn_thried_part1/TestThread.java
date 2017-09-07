package learn_thried_part1;

public class TestThread {
    public static void main(String[] args) {
        String  text = "This is my Test programm";
        Thread ups = new Thread(new ThreadWord(text));
        Thread ups2 = new Thread(new ThreadSpace(text));
        ups.start();
        ups2.start();
    }
}
