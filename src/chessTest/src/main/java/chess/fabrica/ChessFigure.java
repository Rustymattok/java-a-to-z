package chess.fabrica;

import chess.ChessBoard;
import chess.Position;

public  abstract class ChessFigure {
    private Position position;

    public ChessFigure(Position position){
        this.position = position;
    }

    public abstract void show();
    public abstract boolean moveRules(ChessBoard board, Position position, Position movePosition);

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
