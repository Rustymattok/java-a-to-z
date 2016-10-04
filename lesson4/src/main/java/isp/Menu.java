package isp;

import java.util.ArrayList;
/**
 * Class creat common menu with different items.
 */
public class Menu implements Information   {
    private ArrayList<Node> nodeList = new ArrayList<Node>();

    public void add(Node node) {
        nodeList.add(node);
    }

    public void info() {
        int flag = 0;
        for (Node node : nodeList) {
            System.out.printf("%s.%s", node.getName(), node.getKeyName());
            flag++;
            System.out.println();
            node.info();
        }
    }
}
