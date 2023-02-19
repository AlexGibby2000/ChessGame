package GUI;

import AI.AI;
import Game.Board;
import Pieces.Piece;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class ChessBoardGUI
{
    int depth;
    String aiBoard[];
    AI ai;
    boolean whiteWon;
    boolean blackWon;
    int whitePoints;
    int blackPoints;
    Board gB;
    int colorInPlay;
    boolean isPlayingAi=false;
    boolean firstClick=true;
    int startX;
    int startY;
    Piece tempP;
    JPanel temp;
    String pName;
    JFrame window;
    Container con;
    JPanel titleNamePanel;
    JPanel startButtonPanel;
    JPanel aiButtonPanel;
    JPanel exitButtonPanel;
    JLabel titleNameLabel;
    JButton startButton;
    JButton aiButton;
    JButton exitButton;
    Font titleFont= new Font("Times New Roman", Font.PLAIN, 80);
    Font buttonFont=new Font("Times New Roman", Font.PLAIN, 55);
    StartButtonHandler stHandler= new StartButtonHandler();
    AiButtonHandler aiHandler= new AiButtonHandler();
    ExitButtonHandler exitHandler= new ExitButtonHandler();
    protected static final Color SELECTION_COLOR = Color.pink;
    private JPanel selectedPanel = null;
    private Color originalColor = null;
    private Color background=Color.PINK;

    public ChessBoardGUI(Board gameBoard,int d){
        depth=d;
        whitePoints=0;
        blackPoints=0;
        colorInPlay=1;
        gB=gameBoard;
        window= new JFrame();
        window.setSize(800,800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(background);
        window.setLayout(null);
        window.setVisible(true);
        con=window.getContentPane();

        titleNamePanel= new JPanel();
        titleNamePanel.setBounds(100,25,600,100);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel= new JLabel("Chess Game");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel=new JPanel();
        startButtonPanel.setBounds(150,150,500,80);
        startButtonPanel.setBackground(background);

        aiButtonPanel=new JPanel();
        aiButtonPanel.setBounds(150,250,500,80);
        aiButtonPanel.setBackground(background);

        exitButtonPanel=new JPanel();
        exitButtonPanel.setBounds(150,350,500,80);
        exitButtonPanel.setBackground(background);

        startButton=new JButton("Human vs Human");
        startButton.setBackground(background);
        startButton.setForeground(Color.black);
        startButton.setFont(buttonFont);
        startButton.addActionListener(stHandler);

        aiButton=new JButton("Human vs AI");
        aiButton.setBackground(background);
        aiButton.setForeground(Color.black);
        aiButton.setFont(buttonFont);
        aiButton.addActionListener(aiHandler);

        exitButton=new JButton("Exit");
        exitButton.setBackground(background);
        exitButton.setForeground(Color.black);
        exitButton.setFont(buttonFont);
        exitButton.addActionListener(exitHandler);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        aiButtonPanel.add(aiButton);
        exitButtonPanel.add(exitButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);
        con.add(aiButtonPanel);
        con.add(exitButtonPanel);

    }
    public void createGameScreen(){
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        aiButtonPanel.setVisible(false);
        exitButtonPanel.setVisible(false);

        JPanel panel= new JPanel();
        panel.setLayout(new GridLayout(8, 8, 1, 1));
        panel.setBounds(90,50,600,600);
        int a=1,b=0;
        for (int i=0;i<64;i++){
            JPanel label=new JPanel();
            label.add(new JLabel(new ImageIcon()));
            if(i%2==a){
                label.setBackground(Color.GRAY);
            }
            if(i%2==b){
                label.setBackground(Color.white);
            }
            if(i%8==7){
                int temp=a;
                a=b;
                b=temp;
            }
            panel.add(label);

        }
        /*
         * 	Set the images at the proper location
         * */
        ((JPanel) panel.getComponent(0)).remove(0);
        ((JPanel) panel.getComponent(0)).add(new JLabel(new ImageIcon(getClass().getResource("rookB.png"))));
        panel.getComponent(0).setName("rookB.png");

        ((JPanel) panel.getComponent(1)).remove(0);
        ((JPanel) panel.getComponent(1)).add(new JLabel(new ImageIcon(getClass().getResource("horseB.png"))));
        panel.getComponent(1).setName("horseB.png");

        ((JPanel) panel.getComponent(2)).remove(0);
        ((JPanel) panel.getComponent(2)).add(new JLabel(new ImageIcon(getClass().getResource("bishopB.png"))));
        panel.getComponent(2).setName("bishopB.png");

        ((JPanel) panel.getComponent(4)).remove(0);
        ((JPanel) panel.getComponent(4)).add(new JLabel(new ImageIcon(getClass().getResource("queenB.png"))));
        panel.getComponent(4).setName("queenB.png");

        ((JPanel) panel.getComponent(3)).remove(0);
        ((JPanel) panel.getComponent(3)).add(new JLabel(new ImageIcon(getClass().getResource("kingB.png"))));
        panel.getComponent(3).setName("kingB.png");

        ((JPanel) panel.getComponent(5)).remove(0);
        ((JPanel) panel.getComponent(5)).add(new JLabel(new ImageIcon(getClass().getResource("bishopB.png"))));
        panel.getComponent(5).setName("bishopB.png");

        ((JPanel) panel.getComponent(6)).remove(0);
        ((JPanel) panel.getComponent(6)).add(new JLabel(new ImageIcon(getClass().getResource("horseB.png"))));
        panel.getComponent(6).setName("horseB.png");

        ((JPanel) panel.getComponent(7)).remove(0);
        ((JPanel) panel.getComponent(7)).add(new JLabel(new ImageIcon(getClass().getResource("rookB.png"))));
        panel.getComponent(7).setName("rookB.png");

        for(int i=15;i>7;i--){
            ((JPanel) panel.getComponent(i)).remove(0);
            ((JPanel) panel.getComponent(i)).add(new JLabel(new ImageIcon(getClass().getResource("pawnB.png"))));
            panel.getComponent(i).setName("pawnB.png");

        }

        ((JPanel) panel.getComponent(63)).remove(0);
        ((JPanel) panel.getComponent(63)).add(new JLabel(new ImageIcon(getClass().getResource("rookW.png"))));
        panel.getComponent(63).setName("rookW.png");

        ((JPanel) panel.getComponent(62)).remove(0);
        ((JPanel) panel.getComponent(62)).add(new JLabel(new ImageIcon(getClass().getResource("horseW.png"))));
        panel.getComponent(62).setName("horseW.png");

        ((JPanel) panel.getComponent(61)).remove(0);
        ((JPanel) panel.getComponent(61)).add(new JLabel(new ImageIcon(getClass().getResource("bishopW.png"))));
        panel.getComponent(61).setName("bishopW.png");

        ((JPanel) panel.getComponent(59)).remove(0);
        ((JPanel) panel.getComponent(59)).add(new JLabel(new ImageIcon(getClass().getResource("kingW.png"))));
        panel.getComponent(59).setName("kingW.png");

        ((JPanel) panel.getComponent(60)).remove(0);
        ((JPanel) panel.getComponent(60)).add(new JLabel(new ImageIcon(getClass().getResource("queenW.png"))));
        panel.getComponent(60).setName("queenW.png");

        ((JPanel) panel.getComponent(58)).remove(0);
        ((JPanel) panel.getComponent(58)).add(new JLabel(new ImageIcon(getClass().getResource("bishopW.png"))));
        panel.getComponent(58).setName("bishopW.png");

        ((JPanel) panel.getComponent(57)).remove(0);
        ((JPanel) panel.getComponent(57)).add(new JLabel(new ImageIcon(getClass().getResource("horseW.png"))));
        panel.getComponent(57).setName("horseW.png");

        ((JPanel) panel.getComponent(56)).remove(0);
        ((JPanel) panel.getComponent(56)).add(new JLabel(new ImageIcon(getClass().getResource("rookW.png"))));
        panel.getComponent(56).setName("rookW.png");


        for(int i=55;i>47;i--){
            ((JPanel) panel.getComponent(i)).remove(0);
            ((JPanel) panel.getComponent(i)).add(new JLabel(new ImageIcon(getClass().getResource("pawnW.png"))));
            panel.getComponent(i).setName("pawnW.png");


        }
        /*
         * 	Initialize the frame:
         * */
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JPanel panel1 = (JPanel) panel.getComponentAt(e.getPoint());
                if (panel1 == null || panel1 == panel) {
                    return;
                }
                if (selectedPanel != null) {
                    selectedPanel.setBackground(originalColor);
                    selectedPanel.revalidate();
                    selectedPanel.repaint();
                }
                originalColor=panel1.getBackground();
                selectedPanel = panel1;
                selectedPanel.setBackground(SELECTION_COLOR);
                int x=selectedPanel.getY();
                int y=selectedPanel.getX();
                x=x/75;
                y=y/75;
                if(firstClick){
                    if(gB.getPiece(x,y)!=null){
                        if(colorInPlay==1&&gB.getPiece(x,y).getColor().equals(Color.white)){
                            startX=x;
                            startY=y;
                            pName=selectedPanel.getName();
                            temp=selectedPanel;
                            selectedPanel.removeAll();
                            firstClick=false;
                            tempP=gB.getPiece(x,y);
                        }
                        else if(colorInPlay==-1&&gB.getPiece(x,y).getColor().equals(Color.black)){
                            startX=x;
                            startY=y;
                            pName=selectedPanel.getName();
                            temp=selectedPanel;
                            selectedPanel.removeAll();
                            firstClick=false;
                            tempP=gB.getPiece(x,y);
                        }
                    }
                    else{
                        pName="";
                    }
                }
                else{
                    if(gB.getPiece(x,y)==null) {
                            if (tempP.isValidPath(x,y)) {
                                int[][] p=tempP.drawPath(startX,startY);
                                if(tempP.canMove(p, gB.getBoard(),x,y,startX,startY)){
                                    selectedPanel.add(new JLabel(new ImageIcon(getClass().getResource(pName))));
                                    selectedPanel.setName(pName);
                                    temp.removeAll();
                                    temp.setName("");
                                    firstClick = true;
                                    gB.movePiece(x, y, startX, startY);
                                    colorInPlay *= -1;
                                }
                                else {
                                    firstClick = true;
                                    temp.add(new JLabel(new ImageIcon(getClass().getResource(pName))));
                                }
                            }
                            else {
                                firstClick = true;
                                temp.add(new JLabel(new ImageIcon(getClass().getResource(pName))));
                            }
                        }
                    else if(colorInPlay==1){
                        if(gB.getPiece(x,y).getColor().equals(Color.black)){
                            if(tempP.isValidPathAttacking(x,y)){
                                selectedPanel.removeAll();
                                selectedPanel.revalidate();
                                selectedPanel.repaint();
                                selectedPanel.add(new JLabel(new ImageIcon(getClass().getResource(pName))));
                                selectedPanel.setName(pName);
                                temp.removeAll();
                                temp.setName("");
                                firstClick = true;

                                switch (gB.getPiece(x,y).getType()) {
                                    case PAWN:
                                        whitePoints+=1;
                                        break;
                                    case KNIGHT:
                                        whitePoints+=3;
                                        break;
                                    case BISHOP:
                                        whitePoints+=3;
                                        break;
                                    case ROOK:
                                        whitePoints+=5;
                                        break;
                                    case QUEEN:
                                        whitePoints+=9;
                                        break;
                                    case KING:
                                        whitePoints+=20;
                                        whiteWon=true;
                                        break;
                                }
                                    gB.movePiece(x, y, startX, startY);
                                    colorInPlay *= -1;
                            }
                        }
                    }
                    else if(colorInPlay==-1){
                        if(gB.getPiece(x,y).getColor().equals(Color.white)){
                            if(tempP.isValidPathAttacking(x,y)){
                                selectedPanel.removeAll();
                                selectedPanel.revalidate();
                                selectedPanel.repaint();
                                selectedPanel.add(new JLabel(new ImageIcon(getClass().getResource(pName))));
                                selectedPanel.setName(pName);
                                temp.removeAll();
                                temp.setName("");
                                firstClick = true;
                                switch (gB.getPiece(x,y).getType()) {
                                    case PAWN:
                                        blackPoints+=1;
                                        break;
                                    case KNIGHT:
                                        blackPoints+=3;
                                        break;
                                    case BISHOP:
                                        blackPoints+=3;
                                        break;
                                    case ROOK:
                                        blackPoints+=5;
                                        break;
                                    case QUEEN:
                                        blackPoints+=9;
                                        break;
                                    case KING:
                                        blackPoints+=20;
                                        blackWon=true;
                                        break;
                                }
                                gB.movePiece(x,y,startX,startY);
                                colorInPlay*=-1;
                            }
                        }
                    }
                }
                selectedPanel.revalidate();
                selectedPanel.repaint();
                if(blackWon){
                    panel.setVisible(false);
                    blackWins();

                }
                else if(whiteWon){
                    panel.setVisible(false);
                    whiteWins();
                }
            }
        });
        window.getContentPane().setBackground(background);
        con=window.getContentPane();
        con.add(panel);
    }
    public void createGameScreenAi(){
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        aiButtonPanel.setVisible(false);
        exitButtonPanel.setVisible(false);

        JPanel panel= new JPanel();
        panel.setLayout(new GridLayout(8, 8, 1, 1));
        aiBoard=new String[64];
        panel.setBounds(90,50,600,600);
        int a=1,b=0;
        for (int i=0;i<64;i++){
            JPanel label=new JPanel();
            label.add(new JLabel(new ImageIcon()));
            if(i%2==a){
                label.setBackground(Color.GRAY);
            }
            if(i%2==b){
                label.setBackground(Color.white);
            }
            if(i%8==7){
                int temp=a;
                a=b;
                b=temp;
            }
            panel.add(label);

        }
        /*
         * 	Set the images at the proper location
         * */
        ((JPanel) panel.getComponent(0)).remove(0);
        ((JPanel) panel.getComponent(0)).add(new JLabel(new ImageIcon(getClass().getResource("rookB.png"))));
        panel.getComponent(0).setName("rookB.png");
        aiBoard[0]="rookB.png";

        ((JPanel) panel.getComponent(1)).remove(0);
        ((JPanel) panel.getComponent(1)).add(new JLabel(new ImageIcon(getClass().getResource("horseB.png"))));
        panel.getComponent(1).setName("horseB.png");
        aiBoard[1]="horseB.png";

        ((JPanel) panel.getComponent(2)).remove(0);
        ((JPanel) panel.getComponent(2)).add(new JLabel(new ImageIcon(getClass().getResource("bishopB.png"))));
        panel.getComponent(2).setName("bishopB.png");
        aiBoard[2]="bishopB.png";

        ((JPanel) panel.getComponent(4)).remove(0);
        ((JPanel) panel.getComponent(4)).add(new JLabel(new ImageIcon(getClass().getResource("queenB.png"))));
        panel.getComponent(4).setName("queenB.png");
        aiBoard[3]="queenB.png";

        ((JPanel) panel.getComponent(3)).remove(0);
        ((JPanel) panel.getComponent(3)).add(new JLabel(new ImageIcon(getClass().getResource("kingB.png"))));
        panel.getComponent(3).setName("kingB.png");
        aiBoard[4]="kingB.png";

        ((JPanel) panel.getComponent(5)).remove(0);
        ((JPanel) panel.getComponent(5)).add(new JLabel(new ImageIcon(getClass().getResource("bishopB.png"))));
        panel.getComponent(5).setName("bishopB.png");
        aiBoard[5]="bishopB.png";

        ((JPanel) panel.getComponent(6)).remove(0);
        ((JPanel) panel.getComponent(6)).add(new JLabel(new ImageIcon(getClass().getResource("horseB.png"))));
        panel.getComponent(6).setName("horseB.png");
        aiBoard[6]="horseB.png";

        ((JPanel) panel.getComponent(7)).remove(0);
        ((JPanel) panel.getComponent(7)).add(new JLabel(new ImageIcon(getClass().getResource("rookB.png"))));
        panel.getComponent(7).setName("rookB.png");
        aiBoard[7]="rookB.png";

        for(int i=15;i>7;i--){
            ((JPanel) panel.getComponent(i)).remove(0);
            ((JPanel) panel.getComponent(i)).add(new JLabel(new ImageIcon(getClass().getResource("pawnB.png"))));
            panel.getComponent(i).setName("pawnB.png");
            aiBoard[i]="pawnB.png";
        }
        for(int i=16;i<48;i++){
                aiBoard[i]="";
        }

        ((JPanel) panel.getComponent(63)).remove(0);
        ((JPanel) panel.getComponent(63)).add(new JLabel(new ImageIcon(getClass().getResource("rookW.png"))));
        panel.getComponent(63).setName("rookW.png");
        aiBoard[63]="rookW.png";

        ((JPanel) panel.getComponent(62)).remove(0);
        ((JPanel) panel.getComponent(62)).add(new JLabel(new ImageIcon(getClass().getResource("horseW.png"))));
        panel.getComponent(62).setName("horseW.png");
        aiBoard[62]="horseW.png";

        ((JPanel) panel.getComponent(61)).remove(0);
        ((JPanel) panel.getComponent(61)).add(new JLabel(new ImageIcon(getClass().getResource("bishopW.png"))));
        panel.getComponent(61).setName("bishopW.png");
        aiBoard[61]="bishopW.png";

        ((JPanel) panel.getComponent(59)).remove(0);
        ((JPanel) panel.getComponent(59)).add(new JLabel(new ImageIcon(getClass().getResource("kingW.png"))));
        panel.getComponent(59).setName("kingW.png");
        aiBoard[59]="kingW.png";

        ((JPanel) panel.getComponent(60)).remove(0);
        ((JPanel) panel.getComponent(60)).add(new JLabel(new ImageIcon(getClass().getResource("queenW.png"))));
        panel.getComponent(60).setName("queenW.png");
        aiBoard[60]="queenW.png";

        ((JPanel) panel.getComponent(58)).remove(0);
        ((JPanel) panel.getComponent(58)).add(new JLabel(new ImageIcon(getClass().getResource("bishopW.png"))));
        panel.getComponent(58).setName("bishopW.png");
        aiBoard[58]="bishopW.png";

        ((JPanel) panel.getComponent(57)).remove(0);
        ((JPanel) panel.getComponent(57)).add(new JLabel(new ImageIcon(getClass().getResource("horseW.png"))));
        panel.getComponent(57).setName("horseW.png");
        aiBoard[57]="horseW.png";

        ((JPanel) panel.getComponent(56)).remove(0);
        ((JPanel) panel.getComponent(56)).add(new JLabel(new ImageIcon(getClass().getResource("rookW.png"))));
        panel.getComponent(56).setName("rookW.png");
        aiBoard[56]="rookW.png";


        for(int i=55;i>47;i--){
            ((JPanel) panel.getComponent(i)).remove(0);
            ((JPanel) panel.getComponent(i)).add(new JLabel(new ImageIcon(getClass().getResource("pawnW.png"))));
            panel.getComponent(i).setName("pawnW.png");
            aiBoard[i]="pawnW.png";
        }
        /*
         * 	Initialize the frame:
         * */
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JPanel panel1 = (JPanel) panel.getComponentAt(e.getPoint());
                if (panel1 == null || panel1 == panel) {
                    return;
                }
                if (selectedPanel != null) {
                    selectedPanel.setBackground(originalColor);
                    selectedPanel.revalidate();
                    selectedPanel.repaint();
                }
                originalColor = panel1.getBackground();
                selectedPanel = panel1;
                selectedPanel.setBackground(SELECTION_COLOR);
                int x = selectedPanel.getY();
                int y = selectedPanel.getX();
                x = x / 75;
                y = y / 75;
                if (firstClick) {
                    if (gB.getPiece(x, y) != null) {
                        if (colorInPlay == 1 && gB.getPiece(x, y).getColor().equals(Color.white)) {
                            startX = x;
                            startY = y;
                            pName = selectedPanel.getName();
                            temp = selectedPanel;
                            selectedPanel.removeAll();
                            firstClick = false;
                            tempP = gB.getPiece(x, y);
                        }
                    } else {
                        pName = "";
                    }
                } else {
                    if (gB.getPiece(x, y) == null) {
                        if (tempP.isValidPath(x, y)) {
                            int[][] p = tempP.drawPath(startX, startY);
                            if (tempP.canMove(p, gB.getBoard(), x, y, startX, startY)) {
                                selectedPanel.add(new JLabel(new ImageIcon(getClass().getResource(pName))));
                                selectedPanel.setName(pName);
                                temp.removeAll();
                                temp.setName("");
                                firstClick = true;
                                gB.movePiece(x, y, startX, startY);
                                colorInPlay *= -1;
                            } else {
                                firstClick = true;
                                temp.add(new JLabel(new ImageIcon(getClass().getResource(pName))));
                            }
                        } else {
                            firstClick = true;
                            temp.add(new JLabel(new ImageIcon(getClass().getResource(pName))));
                        }
                    } else if (colorInPlay == 1) {
                        if (gB.getPiece(x, y).getColor().equals(Color.black)) {
                            if (tempP.isValidPathAttacking(x, y)) {
                                selectedPanel.removeAll();
                                selectedPanel.revalidate();
                                selectedPanel.repaint();
                                selectedPanel.add(new JLabel(new ImageIcon(getClass().getResource(pName))));
                                selectedPanel.setName(pName);
                                temp.removeAll();
                                temp.setName("");
                                firstClick = true;

                                switch (gB.getPiece(x, y).getType()) {
                                    case PAWN:
                                        whitePoints += 1;
                                        break;
                                    case KNIGHT:
                                        whitePoints += 3;
                                        break;
                                    case BISHOP:
                                        whitePoints += 3;
                                        break;
                                    case ROOK:
                                        whitePoints += 5;
                                        break;
                                    case QUEEN:
                                        whitePoints += 9;
                                        break;
                                    case KING:
                                        whitePoints += 20;
                                        whiteWon = true;
                                        break;
                                }
                                gB.movePiece(x, y, startX, startY);
                                colorInPlay *= -1;
                            }
                        }
                    }
                }
                selectedPanel.revalidate();
                selectedPanel.repaint();
                if (isPlayingAi && colorInPlay == -1) {
                    ai.minimax(gB.getBoard(), -1000,1000,ai.getDepth(), true);
                    int finalX = ai.getBestFinalX();
                    int finalY = ai.getBestFinalY();
                    System.out.println("FinalX " + ai.getBestFinalX() + " and FinalY " + ai.getBestFinalY());
                    System.out.println(gB.getPiece(finalX, finalY));
                    System.out.println(ai.getBestStartX() + " and " + ai.getBestStartY());
                    System.out.println(gB.getPiece(ai.getBestStartX(), ai.getBestStartY()));
                    if (gB.getPiece(ai.getBestStartX(), ai.getBestStartY()).getColor().equals(Color.black)) {
                        startX = ai.getBestStartX();
                        startY = ai.getBestStartY();
                        pName = aiBoard[(x * 8) + y];
                        selectedPanel.removeAll();
                        int tempI = (x * 8) + y;
                        firstClick = false;
                        tempP = gB.getPiece(startX, startY);
                        if (gB.getPiece(finalX, finalY)!= null) {
                            if (gB.getPiece(finalX, finalY).getColor().equals(Color.white)) {
                                if (tempP.isValidPathAttacking(finalX, finalY)) {
                                    ((JPanel) panel.getComponent((finalX * 8) + finalY)).removeAll();
                                    ((JPanel) panel.getComponent((finalX * 8) + finalY)).revalidate();
                                    ((JPanel) panel.getComponent((finalX * 8) + finalY)).repaint();
                                    ((JPanel) panel.getComponent((finalX * 8) + finalY)).add(new JLabel(new ImageIcon(getClass().getResource(pName))));
                                    ((JPanel) panel.getComponent((finalX * 8) + finalY)).setName(pName);
                                    aiBoard[(finalX * 8) + finalY] = pName;
                                    ((JPanel) panel.getComponent(tempI)).removeAll();
                                    aiBoard[tempI] = "";
                                    firstClick = true;
                                    switch (gB.getPiece(x, y).getType()) {
                                        case PAWN:
                                            blackPoints += 1;
                                            break;
                                        case KNIGHT:
                                            blackPoints += 3;
                                            break;
                                        case BISHOP:
                                            blackPoints += 3;
                                            break;
                                        case ROOK:
                                            blackPoints += 5;
                                            break;
                                        case QUEEN:
                                            blackPoints += 9;
                                            break;
                                        case KING:
                                            blackPoints += 20;
                                            blackWon = true;
                                            break;
                                    }
                                    gB.movePiece(finalX, finalY, startX, startY);
                                    colorInPlay *= -1;
                                }
                            }
                        } else {
                            if (tempP.isValidPathAttacking(finalX, finalY)) {
                                ((JPanel) panel.getComponent((finalX * 8) + finalY)).removeAll();
                                ((JPanel) panel.getComponent((finalX * 8) + finalY)).revalidate();
                                ((JPanel) panel.getComponent((finalX * 8) + finalY)).repaint();
                                ((JPanel) panel.getComponent((finalX * 8) + finalY)).add(new JLabel(new ImageIcon(getClass().getResource(pName))));
                                ((JPanel) panel.getComponent((finalX * 8) + finalY)).setName(pName);
                                aiBoard[(finalX * 8) + finalY] = pName;
                                ((JPanel) panel.getComponent(tempI)).removeAll();
                                aiBoard[tempI] = "";
                                firstClick = true;
                                switch (gB.getPiece(x, y).getType()) {
                                    case PAWN:
                                        blackPoints += 1;
                                        break;
                                    case KNIGHT:
                                        blackPoints += 3;
                                        break;
                                    case BISHOP:
                                        blackPoints += 3;
                                        break;
                                    case ROOK:
                                        blackPoints += 5;
                                        break;
                                    case QUEEN:
                                        blackPoints += 9;
                                        break;
                                    case KING:
                                        blackPoints += 20;
                                        blackWon = true;
                                        break;
                                }
                                gB.movePiece(finalX, finalY, startX, startY);
                                colorInPlay *= -1;
                            }
                            ((JPanel) panel.getComponent((finalX * 8) + finalY)).revalidate();
                            ((JPanel) panel.getComponent((finalX * 8) + finalY)).repaint();
                            if (blackWon) {
                                panel.setVisible(false);
                                blackWins();

                            } else if (whiteWon) {
                                panel.setVisible(false);
                                whiteWins();
                            }
                        }
                        if (blackWon) {
                            panel.setVisible(false);
                            blackWins();

                        } else if (whiteWon) {
                            panel.setVisible(false);
                            whiteWins();
                        }
                    }
                }
            }
        });
        window.getContentPane().setBackground(background);
        con=window.getContentPane();
        con.add(panel);
    }
    private void whiteWins() {
        JPanel winnerNamePanel= new JPanel();
        winnerNamePanel.setBounds(100,25,600,100);
        winnerNamePanel.setBackground(Color.black);
        JLabel winLabel=new JLabel("White Wins!");
        winLabel.setForeground(Color.white);
        winLabel.setFont(titleFont);

        winnerNamePanel.setVisible(true);
        winnerNamePanel.add(winLabel);
        exitButtonPanel.setVisible(true);
        con.add(winnerNamePanel);
    }

    private void blackWins() {
        JPanel winnerNamePanel= new JPanel();
        winnerNamePanel.setBounds(100,25,600,100);
        winnerNamePanel.setBackground(Color.black);
        JLabel winLabel=new JLabel("Black Wins!");
        winLabel.setForeground(Color.white);
        winLabel.setFont(titleFont);

        winnerNamePanel.setVisible(true);
        winnerNamePanel.add(winLabel);
        exitButtonPanel.setVisible(true);
        con.add(winnerNamePanel);
    }
    public class StartButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            createGameScreen();
        }
    }
    public class AiButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ai=new AI(gB.getBoard(),depth);
            isPlayingAi=true;
            createGameScreenAi();
        }
    }
    public class ExitButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));

        }
    }
}