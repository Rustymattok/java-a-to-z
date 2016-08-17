package chess.model;

import chess.ChessBoard;
import chess.fabrica.ChessFigure;
import chess.Position;

public class ChessPawn extends ChessFigure {
    private Position position;

    public ChessPawn(Position position){
        super(position);
        this.position = position;
    }

    @Override
    public void show() {
        System.out.println("пешка!!!!");
    }

    @Override
    public boolean move(ChessBoard board, Position movePosition) {
        boolean flag = false;
        if (board.getBorder()[position.getX()][position.getY()] != 1) {
            if (position.getY() == movePosition.getY()) {
                flag = true;
            } else if (movePosition.getX() - position.getX() == 1 || movePosition.getY() - position.getY() == 1) {
                if (board.getBorder()[movePosition.getX()][movePosition.getY()] == 0) {
                    flag = true;
                }
            }
        }
            return flag;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }
}
