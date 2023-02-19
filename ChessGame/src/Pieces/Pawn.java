package Pieces;
import Game.*;

import java.awt.*;


public class Pawn extends Piece{
    Type type;
    boolean hasMoved;

    public Pawn(int x, int y, Player player){
        super(x,y,player);
        hasMoved=false;
        type=Type.PAWN;
    }

    public Type getType() {return Type.PAWN;}
    public Color getColor(){
        return mPlayer.getColor();
    }

    public boolean isValidPath(int finalX, int finalY){
        int result = mX - finalX;
        if(mPlayer.getColor().equals(Color.black)){
            if (hasMoved) {
                if (result == -1 && finalY == mY) {
                    mX = finalX;
                    mY = finalY;
                    return true;
                } else {
                    return false;
                }
            } else {
                if (result == -1 || result == -2&& finalY == mY) {
                    mX = finalX;
                    mY = finalY;
                    hasMoved = true;
                    return true;
                } else {
                    return false;
                }

            }
        }
        else {
            if (hasMoved) {
                if (result == 1 && finalY == mY) {
                    mX = finalX;
                    mY = finalY;
                    return true;
                } else {
                    return false;
                }
            } else {
                if ((result == 1 || result == 2) && finalY == mY) {
                    mX = finalX;
                    mY = finalY;
                    hasMoved = true;
                    return true;
                } else {
                    return false;
                }

            }
        }

    }
    public boolean isValidPathAttacking(int finalX, int finalY){
        int x_diff=finalX-mX;
        int y_diff=finalY-mY;
        if(mPlayer.getColor().equals(Color.black)){
            if (hasMoved) {
                if (x_diff==1 && (y_diff==-1||y_diff==1)) {
                    mX = finalX;
                    mY = finalY;
                    return true;
                } else {
                    return false;
                }
            } else {
                if (x_diff==1 && (y_diff==-1||y_diff==1)) {
                    mX = finalX;
                    mY = finalY;
                    hasMoved = true;
                    return true;
                } else {
                    return false;
                }

            }
        }
        else {
            if (hasMoved) {
                if (x_diff == -1&& (y_diff==-1||y_diff==1)) {
                    mX = finalX;
                    mY = finalY;
                    return true;
                } else {
                    return false;
                }
            }
            else {
                if (x_diff == -1 && (y_diff==-1||y_diff==1)) {
                    mX = finalX;
                    mY = finalY;
                    hasMoved = true;
                    return true;
                } else {
                    return false;
                }

            }
        }

    }

    public int[][] drawPath(int startX, int startY) {
        int path[][];
         path=new int[8][8];
        for(int i=0;i< path.length;i++){
            for(int j=0;j<path[i].length;j++){
                int result = startX - i;
                if(mPlayer.getColor().equals(Color.black)){
                    if(hasMoved){
                        if (result == -1 && j == startY) {
                            path[i][j] = 1;
                        } else {
                            path[i][j] = 0;
                        }
                    }
                    else {
                        if (result == -1 || result == -2 && j == startY) {
                            path[i][j] = 1;
                        } else {
                            path[i][j] = 0;
                        }
                    }
                }
                else {
                    if(hasMoved){
                        if (result == 1 && j == startY) {
                            path[i][j] = 1;
                        } else {
                            path[i][j] = 0;
                        }

                    }
                    else {
                        if ((result == 1 || result == 2) && j == startY) {
                            path[i][j] = 1;
                        } else {
                            path[i][j] = 0;
                        }
                    }
                }
            }
        }
        return path;
    }


}