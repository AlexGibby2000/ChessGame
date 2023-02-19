package Game;

import GUI.*;
import Pieces.King;

import java.awt.*;

public class Game {

    private static Board gameBoard;
    private Player white;
    private Player black;
    public Game(int depth) {
        white = new Player(Color.white);
        black = new Player(Color.black);
        gameBoard = new Board(white, black);
        gameBoard.newBoard();
        gameBoard.printBoard();
        ChessBoardGUI GUI = new ChessBoardGUI(gameBoard,depth);

    }
}