package Pieces;
import Game.*;

import java.awt.*;

public class Bishop extends Piece {
    Type type;

    public Bishop(int x, int y, Player player) {
        super(x, y, player);
        type = Type.BISHOP;
    }

    public Type getType() {
        return Type.BISHOP;
    }

    public Color getColor() {
        return mPlayer.getColor();
    }

    public boolean isValidPath(int finalX, int finalY) {
        int x_diff = Math.abs(finalX - mX);
        int y_diff = Math.abs(finalY - mY);
        if (x_diff == y_diff) {
            mX = finalX;
            mY = finalY;
        }
        return x_diff==y_diff;
    }
    public boolean isValidPathAttacking(int finalX, int finalY){
        int x_diff=Math.abs(finalX-mX);
        int y_diff=Math.abs(finalY-mY);
        if(x_diff==y_diff){
            mX=finalX;
            mY=finalY;
        }
        return x_diff==y_diff;
    }

    public int[][] drawPath( int startX, int startY) {
        int path[][];
        path=new int[8][8];
        for(int i=0;i< path.length;i++){
            for(int j=0;j<path[i].length;j++){
                int x_diff=Math.abs(i-startX);
                int y_diff=Math.abs(j-startY);
                if(x_diff==y_diff){
                    path[i][j]=1;
                }
                else{
                    path[i][j]=0;
                }
            }
        }
        return path;
    }

    }