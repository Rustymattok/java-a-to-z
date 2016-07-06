package chess.model;

import chess.ChessBoard;
import chess.Position;
import chess.fabrica.ChessFigure;

public class ChessHorse extends ChessFigure{

    public ChessHorse(Position position) {
        super(position);
    }

    @Override
    public void show() {
        System.out.println("Конь");
    }

    @Override
    public boolean moveRules(ChessBoard board, Position position, Position movePosition) {
        //todo написать логику проверки
        return false;
    }
}
