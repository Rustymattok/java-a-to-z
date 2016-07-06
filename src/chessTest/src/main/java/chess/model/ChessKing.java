package chess.model;

import chess.ChessBoard;
import chess.Position;
import chess.fabrica.ChessFigure;

public class ChessKing extends ChessFigure {

    public ChessKing(Position position) {
        super(position);
    }

    @Override
    public void show() {
        System.out.println("Король");
    }

    @Override
    public boolean moveRules(ChessBoard board, Position position, Position movePosition) {
        //todo написать логику проверки
        return false;
    }
}
