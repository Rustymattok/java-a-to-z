import chess.ChessBoard;
import chess.Position;
import chess.fabrica.ChessFigure;
import chess.model.*;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ChesspawnTest {
        @Test
        public void whenShouldCheckPosition(){
            final ChessBoard chessBoard = new ChessBoard();
            /**
             * Position position = new Position(1,1);
             * Инициация координаты фигуры, по расположению фигур на доске проверяется что за фигура и есть ли
             * в указанных координатах фигура.
             * Position moveposition = new Position(1,1);
             * Иницилизация координаты, куда нужно подвинуть фигуру, тут же проверяется и возможность ее
             */
            final Position position = new Position(1,1);
            final Position moveposition = new Position(1,2);
            ChessFigure figure = null;
            boolean  result = false;
            switch (chessBoard.getBorder()[position.getX()][position.getY()]){
                case  ChessBoard.PAWN:
                    figure =  new ChessPawn(position);
                    figure.show();
                    result = figure.moveRules(chessBoard,position,moveposition);
                    assertThat(result,is(true));
                    break;
                case ChessBoard.ELEPHANT:
                    figure = new ChessElephant(position);
                    figure.show();
                    //todo написать тест
                    break;
                case ChessBoard.HORSE:
                    figure = new ChessHorse(position);
                    figure.show();
                    //todo написать тест
                    break;
                case ChessBoard.KING:
                    figure = new ChessKing(position);
                    figure.show();
                    //todo написать тест
                    break;
                case  ChessBoard.QWEEN:
                    figure = new ChessQween(position);
                    figure.show();
                    //todo написать тест
                    break;
                case ChessBoard.ROOK:
                    figure = new ChessRook(position);
                    figure.show();
                    //todo написать тест
                    break;
                default:
                    assertThat(result,is(false));
            }
        }
}