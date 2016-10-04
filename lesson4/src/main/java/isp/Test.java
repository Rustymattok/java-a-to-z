package isp;

public class Test {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Node node1 = new Node("Task","1");
        node1.add(new Node("read", "1.1"));
        node1.add(new Node("read", "1.1.1"));
        node1.add(new Node("read", "1.1.2"));
        node1.add(new Node("read", "1.2",true));
        Node node2 = new Node("Task","2");
        node2.add(new Node("read","2.1"));
        node2.add(new Node("read","2.1.1"));
        node2.add(new Node("read", "2.1.2"));
        menu.add(node1);
        menu.add(node2);
        menu.info();
    }
}