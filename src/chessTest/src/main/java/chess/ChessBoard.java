package chess;

public class ChessBoard {
    final private int ASIZE = 8;
    final private int BSIZE = 8;
    public final static int PAWN = 1;
    public final static int ELEPHANT = 2;
    public final static int HORSE = 3;
    public final static int ROOK = 4;
    public final static int QWEEN = 5;
    public final static int KING = 6;

    private int[][] border ;

    public ChessBoard(){
        //растановка шахмтоной доски
        border = new int[ASIZE][BSIZE];
        for (int j = 0; j < BSIZE ; j++) {
            border[1][j] = PAWN;
        }
        for (int j = 0; j < BSIZE ; j++) {
            border[6][j] = PAWN;
        }
        border[0][0] = ELEPHANT;
        border[7][7] = ELEPHANT;
        border[0][7] = ELEPHANT;
        border[7][0] = ELEPHANT;

        //
        border[0][1] = HORSE;
        border[0][6] = HORSE;
        border[7][1] = HORSE;
        border[7][6] = HORSE;
        //
        border[0][2] = ROOK;
        border[0][5] = ROOK;
        border[7][2] = ROOK;
        border[7][5] = ROOK;

        border[0][4] = QWEEN;
        border[7][4] = QWEEN;

        border[0][3] = KING;
        border[7][3] = KING;

        show(); // тестовый метод - чтобы проверить сколько раз создается конструктор
    }
    //
    public void show(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(border[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public int [][] getBorder() {
        return border;
    }

    public void setBorder(int[][] border) {
        this.border = border;
    }
}
