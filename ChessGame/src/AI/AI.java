package AI;
import Game.*;
import Pieces.Piece;

import java.awt.*;

public class AI {
    Piece[][] b;
    int d;
    int bestFinalX;
    int bestFinalY;
    int bestStartX;
    int bestStartY;
    public AI(Piece[][] board, int depth){
        b=board;
        d=depth;
        bestFinalX=0;
        bestFinalY=0;
        bestStartX=0;
        bestStartY=0;
    }
    public int minimax(Piece[][] board,int alpha, int beta, int depth, boolean maximizingPlayer){
        if(depth==0){
            return Evaluate(board);
        }
        else if(maximizingPlayer){
            int maxEval=-1000;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++) {
                    if(board[i][j]!=null) {
                        if (board[i][j].getColor().equals(Color.black)) {
                            int[][] p = board[i][j].drawPath(i, j);
                            for (int x = 0; x < 8; x++) {
                                for (int y = 0; y < 8; y++) {
                                    if(p[x][y]==1) {
                                            if (board[i][j].isValidPath(x,y)){
                                                if (board[i][j].canMove(p, board, x, y, i, j)) {
                                                    board[x][y] = board[i][j];
                                                    board[i][j] = null;
                                                    int eval = minimax(board,alpha,beta, (depth - 1), false);
                                                    board[i][j] = board[x][y];
                                                    board[x][y] = null;
                                                    if (maxEval <= eval) {
                                                        maxEval = eval;
                                                        bestFinalX = x;
                                                        bestFinalY = y;
                                                        bestStartX = i;
                                                        bestStartY = j;
                                                    }
                                                    alpha=Math.max(alpha,eval);
                                                    if(beta<=alpha){break;}
                                                }
                                            }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return maxEval;
        }
        else{
            int minEval=1000;
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[i].length;j++) {
                    if(board[i][j]!=null) {
                        if (board[i][j].getColor().equals(Color.white)) {
                            int[][] p = board[i][j].drawPath(i, j);
                            for (int x = 0; x < p.length; x++) {
                                for (int y = 0; y < p[x].length; y++) {
                                    if (p[x][y] == 1) {
                                            if (board[i][j].isValidPath(x, y)) {
                                                if (board[i][j].canMove(p, board, x, y, i, j)) {
                                                    board[x][y] = board[i][j];
                                                    board[i][j] = null;
                                                    int eval = minimax(board,alpha, beta, (depth - 1), true);
                                                    board[i][j] = board[x][y];
                                                    board[x][y] = null;
                                                    minEval = Math.min(minEval, eval);
                                                    beta =Math.min(beta,eval);
                                                    if(beta<=alpha){break;}
                                                }
                                            }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return minEval;
        }
    }
    public int getBestFinalX(){
        return bestFinalX;
    }

    public int getBestFinalY() {
        return bestFinalY;
    }

    public int getBestStartX() {
        return bestStartX;
    }
    public int getBestStartY() {
        return bestStartY;
    }

    public int getDepth(){
        return d;
    }

    public int Evaluate(Piece[][] gb){
        int result=0;
        for(int i=0;i< gb.length;i++){
            for(int j=0;j<gb[i].length;j++) {
                if (gb[i][j] != null){
                    if (gb[i][j].getColor().equals(Color.black)) {
                        switch (gb[i][j].getType()) {
                            case PAWN:
                                result -= 1;
                                break;
                            case KNIGHT:
                                result -= 3;
                                break;
                            case BISHOP:
                                result -= 3;
                                break;
                            case ROOK:
                                result -= 5;
                                break;
                            case QUEEN:
                                result -= 9;
                                break;
                            case KING:
                                result -= 20;
                                break;
                        }
                    } else if (gb[i][j].getColor().equals(Color.black)) {
                        switch (gb[i][j].getType()) {
                            case PAWN:
                                result += 1;
                                break;
                            case KNIGHT:
                                result += 3;
                                break;
                            case BISHOP:
                                result += 3;
                                break;
                            case ROOK:
                                result += 5;
                                break;
                            case QUEEN:
                                result += 9;
                                break;
                            case KING:
                                result += 20;
                                break;
                        }
                    }
            }
            }
        }
        return result;
    }
}
