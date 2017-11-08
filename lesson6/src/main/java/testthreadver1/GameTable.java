package testthreadver1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Class describe game board. It consist form massive block .
 */
public class GameTable {

    private ReentrantLock [][] border;
    private ReentrantLock lock = new ReentrantLock();
    private int xSize;
    private int ySize;

    public GameTable(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        border = new ReentrantLock[xSize][ySize];
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
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
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
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
    public  void showBorder(){
        lock.lock();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                if (border[i][j].isLocked()) {
                    System.out.print(" X ");
                } else {
                    System.out.print(" 0 ");
                }
            }
            System.out.println();
        }
        lock.unlock();
    }

    public ReentrantLock[][] getBorder() {
        return border;
    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }
}

