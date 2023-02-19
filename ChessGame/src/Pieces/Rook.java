package Pieces;
import Game.*;

import java.awt.*;

public class Rook extends Piece{
    Type type;
    boolean hasMoved;

    public Rook(int x, int y, Player player){
        super(x,y,player);
        hasMoved=false;
        type=Type.ROOK;
    }

    public Type getType() {return Type.ROOK;}
    public Color getColor(){
        return mPlayer.getColor();
    }

    public boolean isValidPath(int finalX, int finalY){
        if(finalX!=mX&&finalY==mY){
            mX=finalX;
            mY=finalY;
            return true;
        }
        else if(finalY!=mY&&finalX==mX){
            mX=finalX;
            mY=finalY;
            return true;
        }
        else{return false;}

    }
    public boolean isValidPathAttacking(int finalX, int finalY){
        if(finalX!=mX&&finalY==mY){
            mX=finalX;
            mY=finalY;
            return true;
        }
        else if(finalY!=mY&&finalX==mX){
            mX=finalX;
            mY=finalY;
            return true;
        }
        else{return false;}

    }

    public int[][] drawPath(int startX, int startY) {
        int path[][];
        path=new int[8][8];
        for(int i=0;i< path.length;i++){
            for(int j=0;j<path[i].length;j++){
                if(i!=startX&&j==startY){
                    path[i][j]=1;
                }
                else if(j!=startY&&i==startX){
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