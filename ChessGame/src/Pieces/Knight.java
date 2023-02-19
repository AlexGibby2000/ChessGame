package Pieces;
import Game.*;

import java.awt.*;

public class Knight extends Piece{
    Type type;
    boolean hasMoved;

    public Knight(int x, int y, Player player){
        super(x,y,player);
        hasMoved=false;
        type=Type.KNIGHT;
    }

    public Type getType() {return Type.KNIGHT;}
    public Color getColor(){
        return mPlayer.getColor();
    }

    public boolean isValidPath(int finalX, int finalY){
        if(Math.abs(finalX-mX)==2) {
            if (Math.abs(finalY - mY) == 1) {
                mX=finalX;
                mY=finalY;
                return true;
            }
            else{return false;}
        }
        else if(Math.abs(finalX-mX)==1) {
            if (Math.abs(finalY - mY) == 2) {
                mX=finalX;
                mY=finalY;
                return true;
            }
            else{return false;}
        }
        else{return false;}

    }
    public boolean isValidPathAttacking(int finalX, int finalY) {
        if (Math.abs(finalX - mX) == 2) {
            if (Math.abs(finalY - mY) == 1) {
                mX = finalX;
                mY = finalY;
                return true;
            } else {
                return false;
            }
        } else if (Math.abs(finalX - mX) == 1) {
            if (Math.abs(finalY - mY) == 2) {
                mX = finalX;
                mY = finalY;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }
    public int[][] drawPath(int startX, int startY) {
        int path[][];
        path=new int[8][8];
        for(int i=0;i< path.length;i++){
            for(int j=0;j<path[i].length;j++){
                if (Math.abs(i - startX) == 2) {
                    if (Math.abs(j - startY) == 1) {
                        path[i][j]=1;
                    } else {
                        path[i][j]=0;
                    }
                } else if (Math.abs(i - startX) == 1) {
                    if (Math.abs(j - startY) == 2) {
                        path[i][j]=1;
                    } else {
                        path[i][j]=0;
                    }
                } else {
                    path[i][j]=0;
                }
            }
        }
        return path;
    }
}