package chess;

public abstract class ChessFigure {

    private String name;
    private String color;

    public ChessFigure() {
    }

    public ChessFigure(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public abstract boolean checkPosition(Position position,ChessBoard chessBoard);
    public abstract boolean moveRules(Position position,Position position2,ChessBoard chessBoard);

}
