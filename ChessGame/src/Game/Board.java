package Game;

import Pieces.*;

import java.awt.*;

public class Board{
    Piece board[][];
    Player white;
    Player black;
    int lastMovedX;
    int lastMovedY;

    Pawn wPawn1;
    Pawn wPawn2;
    Pawn wPawn3;
    Pawn wPawn4;
    Pawn wPawn5;
    Pawn wPawn6;
    Pawn wPawn7;
    Pawn wPawn8;

    Pawn bPawn1;
    Pawn bPawn2;
    Pawn bPawn3;
    Pawn bPawn4;
    Pawn bPawn5;
    Pawn bPawn6;
    Pawn bPawn7;
    Pawn bPawn8;

    Rook wRook;
    Rook wRook2;

    Rook bRook;
    Rook bRook2;

    Knight wKnight;
    Knight wKnight2;

    Knight bKnight;
    Knight bKnight2;

    Bishop wBishop;
    Bishop wBishop2;

    Bishop bBishop;
    Bishop bBishop2;

    Queen wQueen;
    Queen bQueen;

    King wKing;
    King bKing;


    public Board(Player w,Player b){
        board=new Piece[8][8];
        white=w;
        black=b;
    }
    public void newBoard(){
        int side=-1;
        for(int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                if(i<2){
                    if(i==0){
                        if(j==0){
                            bRook=new Rook(i,j,black);
                            board[i][j] =bRook;
                        }
                        if(j==1){
                            bKnight=new Knight(i,j,black);
                            board[i][j]=bKnight;
                        }
                        if(j==2){
                            bBishop=new Bishop(i,j,black);
                            board[i][j]=bBishop;
                        }
                        if(j==3){
                            bQueen=new Queen(i,j,black);
                            board[i][j]=bQueen;
                        }
                        if(j==4){
                            bKing=new King(i,j,black);
                            board[i][j]=bKing;
                        }
                        if(j==5){
                            bBishop2=new Bishop(i,j,black);
                            board[i][j]=bBishop2;

                        }
                        if(j==6){
                            bKnight2=new Knight(i,j,black);
                            board[i][j]=bKnight2;

                        }
                        if(j==7){
                            bRook2=new Rook(i,j,black);
                            board[i][j] =bRook2;
                        }
                    }
                    else{
                        if(j==0){
                            bPawn1=new Pawn(i,j,black);
                            board[i][j]=bPawn1;
                        }
                        if(j==1){
                            bPawn2=new Pawn(i,j,black);
                            board[i][j]=bPawn2;
                        }
                        if(j==2){
                            bPawn3=new Pawn(i,j,black);
                            board[i][j]=bPawn3;
                        }
                        if(j==3){
                            bPawn4=new Pawn(i,j,black);
                            board[i][j]=bPawn4;
                        }
                        if(j==4){
                            bPawn5=new Pawn(i,j,black);
                            board[i][j]=bPawn5;
                        }
                        if(j==5){
                            bPawn6=new Pawn(i,j,black);
                            board[i][j]=bPawn6;
                        }
                        if(j==6){
                            bPawn7=new Pawn(i,j,black);
                            board[i][j]=bPawn7;
                        }
                        if(j==7){
                            bPawn8=new Pawn(i,j,black);
                            board[i][j]=bPawn8;
                        }

                    }
                }
                else if(i>board.length-3){
                    if(i==board.length-2){
                        if(j==0){
                            wPawn1=new Pawn(i,j,white);
                            board[i][j]=wPawn1;
                        }
                        if(j==1){
                            wPawn2=new Pawn(i,j,white);
                            board[i][j]=wPawn2;
                        }
                        if(j==2){
                            wPawn3=new Pawn(i,j,white);
                            board[i][j]=wPawn3;
                        }
                        if(j==3){
                            wPawn4=new Pawn(i,j,white);
                            board[i][j]=wPawn4;
                        }
                        if(j==4){
                            wPawn5=new Pawn(i,j,white);
                            board[i][j]=wPawn5;
                        }
                        if(j==5){
                            wPawn6=new Pawn(i,j,white);
                            board[i][j]=wPawn6;
                        }
                        if(j==6){
                            wPawn7=new Pawn(i,j,white);
                            board[i][j]=wPawn7;
                        }
                        if(j==7){
                            wPawn8=new Pawn(i,j,white);
                            board[i][j]=wPawn8;
                        }
                    }
                    else{
                        if(j==0){
                            wRook=new Rook(i,j,white);
                            board[i][j] =wRook;
                        }
                        if(j==1){
                            wKnight=new Knight(i,j,white);
                            board[i][j]=wKnight;
                        }
                        if(j==2){
                            wBishop=new Bishop(i,j,white);
                            board[i][j]=wBishop;
                        }
                        if(j==3){
                            wQueen=new Queen(i,j,white);
                            board[i][j]=wQueen;
                        }
                        if(j==4){
                            wKing=new King(i,j,white);
                            board[i][j]=wKing;
                        }
                        if(j==5){
                            wBishop2=new Bishop(i,j,white);
                            board[i][j]=wBishop2;

                        }
                        if(j==6){
                            wKnight2=new Knight(i,j,white);
                            board[i][j]=wKnight2;

                        }
                        if(j==7){
                            wRook2=new Rook(i,j,white);
                            board[i][j] =wRook2;
                        }
                    }

                }
                else{
                    board[i][j]=null;
                }

            }
        }
    }
    public Piece getPiece(int x, int y){
        return board[x][y];
    }
    public void movePiece(int finalX,int finalY,int startX,int startY){
        board[finalX][finalY]=board[startX][startY];
        board[startX][startY]=null;
        lastMovedX=finalX;
        lastMovedY=finalY;
        printBoard();
    }
    public boolean canMove(int x,int y,int[][] path){
        for(int i=0;i< x;i++){
            for(int j=0;j< y;j++){
                if(path[i][j]==1&&board[i][j]!=null){
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard(){
        for (int i=0;i< board.length;i++){
            for (int j=0;j< board[i].length;j++){
                if(board[i][j]==null){
                    System.out.print("|    |"+" ");
                }
                else{
                    System.out.print("|"+board[i][j].getType()+"|");
                }

            }
            System.out.println("\n");
        }
    }
    public void printPath(int path[][]){
        for(int i=0;i< path.length;i++){
            for(int j=0;j<path[i].length;j++){
                System.out.print(path[i][j]+" ");
            }
            System.out.println();
        }
    }
    public Piece[][] getBoard(){
        return board;
    }
    public boolean checkMateCheck(){
        Piece lP=board[lastMovedX][lastMovedY];
        int path[][]=lP.drawPath(lastMovedX,lastMovedY);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(lP.getColor().equals(Color.black)){
                    if(board[i][j].getType()==Type.KING&&board[i][j].getColor().equals(Color.white)){
                        if(path[i][j]==1){
                            if(i+1< board.length) {
                                if (board[i][j].canMove(path,board, i + 1, j,i,j)) {
                                    return false;
                                } else if (board[i][j].canMove(path,board, i + 1, j + 1,i,j)) {
                                    return false;
                                } else if (board[i][j].canMove(path,board, i + 1, j - 1,i,j)) {
                                    return false;
                                }
                                else if(board[i][j].canMove(path,board,i,j+1,i,j)){
                                    return false;
                                }
                                else if(board[i][j].canMove(path,board,i,j-1,i,j)){
                                    return false;
                                }
                                else if(board[i][j].canMove(path,board,i-1,j,i,j)){
                                    return false;
                                }
                                else if(board[i][j].canMove(path,board,i-1,j+1,i,j)){
                                    return false;
                                }
                                else if(board[i][j].canMove(path,board,i-1,j-1,i,j)){
                                    return false;
                                }
                                else{
                                    return true;
                                }
                            }
                            else if(j+1< board.length){
                                if (board[i][j].canMove(path,board, i + 1, j,i,j)) {
                                    return false;
                                } else if (board[i][j].canMove(path,board, i + 1, j + 1,i,j)) {
                                    return false;
                                } else if (board[i][j].canMove(path,board, i + 1, j - 1,i,j)) {
                                    return false;
                                }
                                else if(board[i][j].canMove(path,board,i,j+1,i,j)){
                                    return false;
                                }
                                else if(board[i][j].canMove(path,board,i,j-1,i,j)){
                                    return false;
                                }
                                else if(board[i][j].canMove(path,board,i-1,j,i,j)){
                                    return false;
                                }
                                else if(board[i][j].canMove(path,board,i-1,j+1,i,j)){
                                    return false;
                                }
                                else if(board[i][j].canMove(path,board,i-1,j-1,i,j)){
                                    return false;
                                }
                                else{
                                    return true;
                                }
                            }

                        }
                        else{
                            return false;
                        }

                    }
                }
                else{
                    if(board[i][j].getType()==Type.KING&&board[i][j].getColor().equals(Color.black)){
                        if(path[i][j]==1){
                            if (board[i][j].canMove(path,board,i+1,j,i,j)) {
                                return false;
                            }
                            else if(board[i][j].canMove(path,board,i+1,j+1,i,j)){
                                return false;
                            }
                            else if(board[i][j].canMove(path,board,i+1,j-1,i,j)){
                                return false;
                            }
                            else if(board[i][j].canMove(path,board,i,j+1,i,j)){
                                return false;
                            }
                            else if(board[i][j].canMove(path,board,i,j-1,i,j)){
                                return false;
                            }
                            else if(board[i][j].canMove(path,board,i-1,j,i,j)){
                                return false;
                            }
                            else if(board[i][j].canMove(path,board,i-1,j+1,i,j)){
                                return false;
                            }
                            else if(board[i][j].canMove(path,board,i-1,j-1,i,j)){
                                return false;
                            }
                            else{
                                return true;
                            }
                        }
                        else{
                            return false;
                        }

                    }

                }
            }

        }
        return false;
    }
    public boolean checkCheck(){
        Piece lP=board[lastMovedX][lastMovedY];
        int path[][]=lP.drawPath(lastMovedX,lastMovedY);
        for(int i=0;i<board.length;i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (lP.getColor().equals(Color.black)) {
                    if (board[i][j].getType() == Type.KING && board[i][j].getColor().equals(Color.white)) {
                        if (path[i][j] == 1) {
                                return true;
                            }
                        } else {
                            return false;
                        }

                    }
                else {
                    if (board[i][j].getType() == Type.KING && board[i][j].getColor().equals(Color.black)) {
                        if (path[i][j] == 1) {
                                return true;
                        } else {
                            return false;
                        }

                    }

                }
            }
        }
            return false;
    }
    public boolean checkStaleMate(){
        return false;
    }

        }