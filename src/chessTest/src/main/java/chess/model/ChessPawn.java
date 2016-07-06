package chess.model;

import chess.ChessBoard;
import chess.fabrica.ChessFigure;
import chess.Position;

public class ChessPawn extends ChessFigure {

    public ChessPawn(Position position){
        super(position);
    }

    public boolean moveRules(ChessBoard board,Position position, Position movePosition) {
        boolean flag = false;

            if (position.getY() == movePosition.getY())
                if (board.getBorder()[position.getX()+1][position.getY()] == 0 || board.getBorder()[position.getX()- 1][position.getY()] == 0) {
                    if (movePosition.getX()- position.getX() == 1 || position.getX() - movePosition.getX() == 1) {
                        System.out.println("test");
                        flag = true;
                    }
                }
        System.out.println(flag);
        return flag;
    }

    public void show(){
        System.out.println("пешка!!!!");
    }


}
