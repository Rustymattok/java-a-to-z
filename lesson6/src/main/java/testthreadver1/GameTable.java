package testthreadver1;

import java.util.concurrent.locks.ReentrantLock;
/**
 * Class describe game board. It consist form massive block .
 */
public class GameTable {

    private ReentrantLock [][] border;
    private int x;
    private int y;

    public GameTable(int x, int y) {
        this.x = x;
        this.y = y;
        border = new ReentrantLock[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                border[i][j]= new ReentrantLock();
            }
        }
    }
    /**
     * This method use for test block.
     * @return count.
     */
    public int checkBorder(){
        int count = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(border[i][j].isLocked()){
                    count++;
                }
            }
        }
        return count;
    }
    /**
     * Take person to the board using coordinates xP and yP.
     * @param xP
     * @param yP
     */
    public void initPerson(int xP,int yP){
        border[xP][yP].lock();
    }
    /**
     * This method using for showing result.
     */
    public synchronized void showBorder(){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (border[i][j].isLocked()) {
                    System.out.print(" X ");
                } else {
                    System.out.print(" 0 ");
                }
            }
            System.out.println();
        }
    }

    public ReentrantLock[][] getBorder() {
        return border;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

