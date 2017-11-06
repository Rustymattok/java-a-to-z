package testthreadver1;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LogicBot implements Logic{

    private GameTable gameTable;
    private int x = 0;
    private int y = 0;

    public LogicBot(GameTable gameTable) {
        this.gameTable = gameTable;
    }

    @Override
    public void initPerson() {
        gameTable.initPerson(x,y);
    }

    @Override
    public  void movePerson() {
        MoveVariation moveVariation = null;
        boolean flag = true;
        while(flag) {
            moveVariation = generateRandom();
            if (moveVariation == MoveVariation.UP) {
                int yP =  y + 1;
                if(checkBorder(x,yP) && checkLock(x,yP)) {
                    y = yP;
                    flag = false;
                }
            }
            if (moveVariation == MoveVariation.DOWN) {
                int yP =  y - 1;
                if(checkBorder(x,yP) && checkLock(x,yP)) {
                   y = yP;
                   flag = false;
                }
            }
            if (moveVariation == MoveVariation.LEFT) {
                int xP =  x - 1;
                if(checkBorder(xP,y) && checkLock(xP,y)) {
                    x = xP;
                    flag = false;
                }
            }
            if (moveVariation == MoveVariation.RIGHT) {
                int xP =  x + 1;
                if(checkBorder(xP,y) && checkLock(xP,y)) {
                    x = xP;
                    flag = false;
                }
            }
        }
    }

    @Override
    public MoveVariation generateRandom() {
        Random random = new Random();
        MoveVariation moveVariation = null;
        MoveVariation[] move = {MoveVariation.UP,MoveVariation.DOWN,MoveVariation.LEFT,MoveVariation.RIGHT};
        int pos = random.nextInt(move.length);
        if(pos == 0){
            moveVariation = MoveVariation.UP;
        }
        if(pos == 1){
            moveVariation = MoveVariation.DOWN;
        }
        if(pos == 2){
            moveVariation = MoveVariation.LEFT;
        }
        if(pos == 3){
            moveVariation = MoveVariation.RIGHT;
        }
        return moveVariation;
    }

    @Override
    public boolean checkBorder(int xP, int yP) {
        boolean flag = true;
        if (xP > gameTable.getX() || yP > gameTable.getY() || xP < 0 || yP < 0)  {
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean checkLock(int xP, int yP) {
        boolean flag = false;
        try {
            if( gameTable.getBorder()[xP][yP].tryLock(500, TimeUnit.MILLISECONDS)){
                gameTable.getBorder()[x][y].unlock();
//                System.out.println(xP + "  " + yP + "is locked");
//                System.out.println(x + "  " + y + "is unlocked");
                flag = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
