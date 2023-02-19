package Pieces;
import Game.*;

import java.awt.*;

public class Queen extends Piece{
    Type type;
    boolean hasMoved;

    public Queen(int x, int y, Player player){
        super(x,y,player);
        hasMoved=false;
        type=Type.QUEEN ;
    }

    public Type getType() {return Type.QUEEN;}
    public Color getColor(){
        return mPlayer.getColor();
    }

    public boolean isValidPath(int finalX, int finalY){
        int x_diff=Math.abs(finalX-mX);
        int y_diff=Math.abs(finalY-mY);
        if(x_diff==y_diff){
            mX=finalX;
            mY=finalY;
            return true;
        }
        else if(finalX!=mX&&finalY==mY){
            mX=finalX;
            mY=finalY;
            return true;
        }
        else if(finalX==mX&&finalY!=mY){
            mX=finalX;
            mY=finalY;
            return true;
        }
        else{return false;}
    }
    public boolean isValidPathAttacking(int finalX, int finalY){
        int x_diff=Math.abs(finalX-mX);
        int y_diff=Math.abs(finalY-mY);
        if(x_diff==y_diff){
            mX=finalX;
            mY=finalY;
            return true;
        }
        else if(finalX!=mX&&finalY==mY){
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
                int x_diff=Math.abs(i-startX);
                int y_diff=Math.abs(j-startY);
                if(x_diff==y_diff){
                    path[i][j]=1;
                }
                else if(i!=startX&&j==startY){
                    path[i][j]=1;
                }
                else if(j!=startY&&i==startX){
                    path[i][j]=1;
                }
                else{path[i][j]=0;}
            }
        }
        return path;
    }
    @Override
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
}