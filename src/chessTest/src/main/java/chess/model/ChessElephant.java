package chess.model;

import chess.ChessBoard;
import chess.fabrica.ChessFigure;
import chess.Position;

public class ChessElephant extends ChessFigure {

    public ChessElephant(Position position) {
        super(position);
    }

    @Override
    public void show() {
        System.out.println("слон");
    }

    @Override
   public  boolean moveRules(ChessBoard board, Position position, Position movePosition) {
        //todo написать логику проверки
        return false;
    }
}
