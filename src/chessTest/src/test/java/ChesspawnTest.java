import chess.ChessBoard;
import chess.Position;
import chess.fabrica.ChessFigure;
import chess.model.*;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ChesspawnTest {
    final private Position position = new Position(1,1);
    final private Position moveposition = new Position(1,2);
    final private static ChessBoard chessBoard = new ChessBoard();
    final private ChessFigure figure = new ChessPawn(position);

    @Test
    public void whenShouldCheckChessPawnEmptyField(){
        boolean  result = false;
        result = figure.isEmptyField(chessBoard,position);
        System.out.println("Тест на проверку свободного поля для указанных координат :");
        chessBoard.show();
        assertThat(result,is(true));
    }

    @Test
    public  void whenShouldCheckChessPawnNormalMove(){
        boolean  result = false;
        result = figure.isNormalMove(chessBoard,position,moveposition);
        System.out.println("Тест на возможность передвижения фигуры вверх, вниз :");
        chessBoard.show();
        assertThat(result,is(true));
    }

    @Test
    public void whenShouldCheckChessPawnCurveMove(){
        boolean  result = false;
        result = figure.isCurvMove(chessBoard,position,moveposition);
        System.out.println("Тест на возможность передвижения фигуры по диагонали :");
        chessBoard.show();
        assertThat(result,is(true));
    }
}