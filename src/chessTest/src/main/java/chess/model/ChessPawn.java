package chess.model;

import chess.ChessBoard;
import chess.fabrica.ChessFigure;
import chess.Position;

public class ChessPawn extends ChessFigure {

    public ChessPawn(Position position){
        super(position);
    }

    @Override
    public boolean isNormalMove(ChessBoard board,Position position, Position movePosition) {
        boolean flag = false;
        if (position.getY() == movePosition.getY())
            if (board.getBorder()[position.getX()+1][position.getY()] == 0 || board.getBorder()[position.getX()- 1][position.getY()] == 0) {
                if (movePosition.getX()- position.getX() == 1 || position.getX() - movePosition.getX() == 1) {
                    flag = true;
                }
            }
        return flag;
    }

    @Override
    public boolean isEmptyField(ChessBoard board, Position position) {
        boolean flag = false;
        if (board.getBorder()[position.getX()][position.getY()] != 1) {
            flag = true;
        }
        return flag;
    }

    public void show(){
        System.out.println("пешка!!!!");
    }

    @Override
    public boolean isCurvMove(ChessBoard board, Position position, Position movePosition) {
        boolean flag = false;
        if (position.getY() == movePosition.getY())
            if (    board.getBorder()[position.getX()+1][position.getY()-1] == 1 || board.getBorder()[position.getX()- 1][position.getY()-1] == 1 ||
                    board.getBorder()[position.getX()+1][position.getY()+1] == 1 || board.getBorder()[position.getX()- 1][position.getY()-1] == 1 ) {
                if (movePosition.getX()- position.getX() == 1 || position.getX() - movePosition.getX() == 1) {
                    flag = true;
                }
            }
        return flag;
    }
}
