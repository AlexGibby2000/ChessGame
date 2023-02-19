package Pieces;
import Game.*;

import java.awt.*;

/*
* Constructor for a Piece.
* int x is the x location of the Piece
* int y is the y location of the Piece
 */
public abstract class Piece {
    public int mX,mY;
    public Player mPlayer;


    public Piece(int x, int y, Player player){
        mX=x;
        mY=y;
        mPlayer=player;
        //mPlayer.myGame.gameBoard.boardArray[x][y]=this;
    }
    public abstract Color getColor();

    public abstract boolean isValidPath(int finalX, int finalY);
    public abstract boolean isValidPathAttacking(int finalX, int finalY);
    public abstract int[][] drawPath(int startX,int startY);
    public boolean canMove(int[][] path,Piece[][] gB,int finalX,int finalY,int startX, int startY){
        int x_diff=finalX-startX;
        int y_diff=finalY-startY;
        if(x_diff>0){
            for(int i=startX;i<finalX-1;i++){
                if(y_diff>0){
                    for(int j=startY;j<finalY-1;j++){
                        System.out.println(path[i][j]);
                        if(path[i][j]==1&&gB[i][j]!=null){
                            return false;
                        }
                    }
                }
                else if(y_diff<0){
                    for(int j=startY;j>finalY+1;j--){
                        System.out.println(path[i][j]);
                        if(path[i][j]==1&&gB[i][j]!=null){
                            return false;
                        }
                    }
                }
                else{
                    if(path[i][startY]==1&&gB[i][startY]!=null){
                        return false;
                    }
                }

            }
        }
        else if(x_diff<=0){
            for(int i=startX;i>finalX+1;i--){
                if(y_diff>0){
                    for(int j=startY;j<finalY-1;j++){
                        System.out.println(path[i][j]);
                        if(path[i][j]==1&&gB[i][j]!=null){
                            return false;
                        }
                    }
                }
                else if(y_diff<0){
                    for(int j=startY;j>finalY+1;j--){
                        System.out.println(path[i][j]);
                        if(path[i][j]==1&&gB[i][j]!=null){
                            return false;
                        }
                    }
                }
                else{
                    if(path[i][startY]==1&&gB[i][startY]!=null){
                        return false;
                    }
                }

            }

        }
        return true;
    }
    public abstract Type getType();


}