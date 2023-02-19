package Pieces;
import Game.*;

import java.awt.*;

public class King extends Piece{
    Type type;
    boolean hasMoved;

    public King(int x, int y, Player player){
        super(x,y,player);
        type=Type.KING;
    }

    public Type getType() {return Type.KING;}
    public Color getColor(){
        return mPlayer.getColor();
    }

    public boolean isValidPath(int finalX, int finalY){
        if(Math.abs(finalX-mX)<=1&&Math.abs(finalY-mY)<=1){
            mX=finalX;
            mY=finalY;
            return true;
        }
        else {return false;}

    }
    public boolean isValidPathAttacking(int finalX, int finalY){
        if(Math.abs(finalX-mX)<=1&&Math.abs(finalY-mY)<=1){
            mX=finalX;
            mY=finalY;
            return true;
        }
        else {return false;}

    }

    public int[][] drawPath(int startX, int startY) {
        int path[][];
        path=new int[8][8];
        for(int i=0;i< path.length;i++){
            for(int j=0;j<path[i].length;j++){
                if(Math.abs(i-startX)<=1&&Math.abs(j-startY)<=1){
                    path[i][j]=1;
                }
                else {path[i][j]=0;}
            }
        }
        return path;
    }
}