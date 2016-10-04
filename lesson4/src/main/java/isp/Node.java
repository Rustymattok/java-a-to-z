package isp;

import java.util.ArrayList;
/**
 * Class describe node.
 */
public class Node implements Execute,Information {
    private String name;
    private String keyName;
    private ArrayList<Node> nodeList = new ArrayList<Node>();
    private boolean position ;

    public Node(String name, String keyName) {
        this.position = false;
        this.name = name;
        this.keyName = keyName;
    }

    public Node(String name, String keyName,boolean position) {
        this.position = position;
        this.name = name;
        this.keyName = keyName;
    }

    public void add(Node node){
        nodeList.add(node);
    }
    /**
     * This method allow to choose command in mneu.
     * We have preliery code here .
     * @param node
     */
    public void execute(Node node) {
        System.out.printf("You choose the next node  %s.%s",node.getName(),node.getKeyName());
    }
    /**
     * Method for show info.
     */
    public void info() {
        int flag = 0;
        for(Node node:nodeList){
            if (flag == 0){
                System.out.printf("--%s.%s", node.getName(), node.getKeyName());
            }else if(node.isPosition()) {
                System.out.printf("--%s.%s", node.getName(), node.getKeyName());
            }
            else {
                System.out.printf("------%s.%s", node.getName(), node.getKeyName());
            }
            flag++;
            System.out.println();
        }
    }

    public String getName() {
        return name;
    }

    public String getKeyName() {
        return keyName;
    }

    public ArrayList<Node> getNodeList() {
        return nodeList;
    }

    public boolean isPosition() {
        return  position;
    }
}
