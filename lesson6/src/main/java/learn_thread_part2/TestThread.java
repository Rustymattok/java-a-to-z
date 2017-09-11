package learn_thread_part2;

public class TestThread {
    public static void main(String[] args) {
        String  text = "This is my Test programm";
        System.out.println(text);
        Thread ups = new Thread(new ThreadWord(text));
        Thread ups2 = new Thread(new ThreadSpace(text));
        ups.start();
        ups2.start();
        try {
            ups.join();
            ups2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Programm is done");
    }
}
