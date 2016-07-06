package chess.model;

import chess.ChessBoard;
import chess.Position;
import chess.fabrica.ChessFigure;

public class ChessQween extends ChessFigure {

    public ChessQween(Position position) {
        super(position);
    }

    @Override
    public void show() {
        System.out.println("Королева");
    }

    @Override
    public boolean moveRules(ChessBoard board, Position position, Position movePosition) {
        //todo написать логику проверки
        return false;
    }
}
