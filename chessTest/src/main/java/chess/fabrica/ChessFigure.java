package chess.fabrica;

import chess.ChessBoard;
import chess.Position;

public  abstract class ChessFigure {
    private Position position;

    public ChessFigure(Position position){
        this.position = position;
    }

    public abstract void show();
    public abstract boolean move(ChessBoard board,Position position);

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
