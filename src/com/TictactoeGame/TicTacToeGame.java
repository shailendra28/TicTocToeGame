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
    public void makeMove() {    // Make a move
        Scanner Scan=new Scanner(System.in);
        System.out.println("Make your move by choosing number 1-9 :- ");
        int i=Scan.nextInt();
        if (board[i] == ' ') {
            board[i] = usersymbol;
        } else {
            System.out.println("Already occupied place.");
        }
    }
    public static void main(String[]args){
        TicTacToeGame tictactoe=new TicTacToeGame(); //created object for class TicTacToeGame
        tictactoe.showBoard();
        tictactoe.makeMove();
    }
}
