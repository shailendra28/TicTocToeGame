package com.TictactoeGame;
import java.util.Scanner;
/**
 * Welcome to the TicTocToe Game
 */
public class TicTacToeGame {
    private char board[]=new char[10]; //created a tictactoe board of size 10
    private char usersymbol,computersymbol;
    TicTacToeGame(){
        createboard(); //inside the constructor am calling createboard method
        tossForFirstPlay(); //making toss to start play
        takeUserInput();//inside the constructor am calling takeUserInput method
    }
    public void createboard(){  //created a method named createboard.
        for(int count=1;count<10;count++){ //it will iterate this forloop from 1 to 10
            board[count]=' '; //assigned empty space
        }
    }
    public void takeUserInput(){ //created a method named
        Scanner Sc=new Scanner(System.in);
        System.out.println("Your turn: ");
        String symbol=Sc.next(); // taking user input to check
        if (symbol=="x"){        //Comparing the user input
            usersymbol= 'x';
            computersymbol='o';
            System.exit(0);
        }else if (symbol=="o"){
            usersymbol='o';
            computersymbol='x';
            System.exit(0);
        }else{
            System.out.println("invalid option");
        }
    }
    public void showBoard(){     // shaow board
        String horizontalPart = "+---";
        String verticalPart = "|   ";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(horizontalPart);
            }
            System.out.print("+\n");
            for (int j = 0; j < 3; j++) {
                System.out.print(verticalPart);
            }
            System.out.print("+\n");
        }
    }
    public boolean makeMove() {    // Make a move along with checking the space in board
        Scanner Scan=new Scanner(System.in);
        System.out.println("Make your move by choosing number 1-9 :- ");
        int i=Scan.nextInt();
        int player=1;
        while (true) {
            if (board[i] == ' ') {
                if (player == 0) {
                    System.out.println("Computer played: ");
                    board[i] = computersymbol;
                } else {
                    System.out.println("Player played: ");
                    board[i] = usersymbol;
                }
                showBoard();
                return false;
            } else {
                return true;
            }
        }
    }
    public void tossForFirstPlay() {    // Toss to start game
        int player;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Toss (H or T):");
        String toss=sc.next();
        int i = (int) Math.round(Math.random()) % 2;
        if ((i == 1 && toss.equals("H")) || (i == 0 && toss.equals("T"))) {
            System.out.println("Congratulations! You've won the Toss.");
            player = 1;
        } else {
            System.out.println("You've lost Toss. Computer plays first.");
            player = 0;
        }
    }
    public static void main(String[]args){
        TicTacToeGame tictactoe=new TicTacToeGame(); //created object for class TicTacToeGame
        tictactoe.showBoard();
        tictactoe.makeMove();
    }
}
