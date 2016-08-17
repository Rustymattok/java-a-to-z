package chess;

import java.util.Random;

public class ChessBoard {
    final private int ASIZE = 8;
    final private int BSIZE = 8;
    public final static int PAWN = 1;

    private int[][] border ;

    public ChessBoard(){
        //растановка шахмтоной доски
        Random random = new Random();
        border = new int[ASIZE][BSIZE];
        int arr[] = {0,1,2};
        int n;
        for (int i = 1; i < ASIZE-1 ; i++) {
            for (int j = 1; j < BSIZE-1; j++) {
                n = arr[random.nextInt(arr.length)];
                if (n == 0 && (border[i-1][j] != 1 && border[i+1][j] != 1 )){
                    border[i][j] = PAWN;
                }
            }
        }
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
