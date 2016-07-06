package chess;

public class Chesspawn extends ChessFigure {
    private Position position;

    public Chesspawn (){
        super();
    }

    public Chesspawn(String name, String color) {
        super(name, color);
    }

    @Override
    public boolean moveRules(Position position, Position position2,ChessBoard chessBoard) {
        boolean flag = false;
        //todo описать ход пешки
        return flag;
    }

    @Override
    public boolean checkPosition(Position position,ChessBoard chessBoard) {
        boolean flag = false;
        for (int i = 0; i < chessBoard.getBorder().length; i++) {
            for (int j = 0; j < chessBoard.getBorder().length ; j++) {
                if (chessBoard.getBorder()[i][j] == chessBoard.getBorder()[position.getX()][position.getY()] && chessBoard.getBorder()[i][j] == 1 ){
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
}
