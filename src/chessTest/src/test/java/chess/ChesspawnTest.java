package chess;

import chess.fabrica.ChessFigure;
import chess.model.*;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ChesspawnTest {
    private Position position = new Position(1,1);
    private static ChessBoard chessBoard = new ChessBoard();
    final private ChessFigure figure = new ChessPawn(position);
    private boolean result = false;

    @Test
    public void whenShouldCheckChessPawnEmptyField(){
        result = figure.move(chessBoard, new Position(2,2));
        System.out.println("Тест на проверку свободного поля для указанных координат :");
        chessBoard.show();
        assertThat(result,is(true));
    }

    @Test
    public  void whenShouldCheckChessPawnNormalMove(){
        result = figure.move(chessBoard, new Position(1,2));
        System.out.println("Тест на возможность передвижения фигуры вверх, вниз :");
        chessBoard.show();
        assertThat(result,is(true));
    }

    @Test
    public void whenShouldCheckChessPawnCurveMove(){
        result = figure.move(chessBoard, new Position(2,1));
        System.out.println("Тест на возможность передвижения фигуры по диагонали :");
        chessBoard.show();
        assertThat(result,is(true));
    }
}