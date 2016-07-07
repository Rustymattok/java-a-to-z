package chess.fabrica;

import chess.ChessBoard;
import chess.Position;

public  abstract class ChessFigure {
    private Position position;

    public ChessFigure(Position position){
        this.position = position;
    }

    public abstract void show();
    public abstract boolean isNormalMove(ChessBoard board,Position position, Position movePosition);
    public abstract boolean isCurvMove(ChessBoard board,Position position, Position movePosition);
    public abstract boolean isEmptyField(ChessBoard board, Position position);

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
