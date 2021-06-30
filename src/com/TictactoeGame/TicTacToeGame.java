package com.TictactoeGame;
import java.util.Scanner;
/**
 * Welcome to the TicTocToe Game
 */
public class TicTacToeGame {
    /**
     * Here scanner will take input and taken two variables having char datatype.
     * created a board of size 10
     */
    private static final Scanner SCANNER = new Scanner(System.in);
    private static char board[] = new char[10];
    private static char usersymbol, computersymbol;
    private static int player,index = 0;
    private static char emptyspace = ' ';
    TicTacToeGame() {
        /**
         * inside the constructor am calling createboard method.
         * making toss to start play---it'll decide who will play first.
         * calling takeUserInput method
         */
        createBoard();
        tossForFirstPlay();
        takeUserInput();
    }
    /**
     * Created a method named createboard.
     * it will iterate this forloop from 1 to 10.
     * Board valus assigned empty space.
     */
    private static void createBoard() {
        for (int count = 1; count < 10; count++) {
            board[count] = ' ';
        }
    }
    /**
     * It'll take user input 'x' and '0'.
     * Compare those to assign the values whether it's computersymbol or usersymbol.
     */
    private static void takeUserInput() {
        System.out.println("Your turn:(Choose x or o) ");
        String symbol = SCANNER.next();
        if (symbol.equals("x")) {
            usersymbol = 'x';
            computersymbol = 'o';
        } else if (symbol.equals("o")) {
            usersymbol = 'o';
            computersymbol = 'x';
        } else {
            System.out.println("invalid option");
        }
    }
    /**
     * This showBoard method is showing the empty board of 3*3 matrices.
     * inside this board it'll take the board values assigned empty space.
     */
    private static void showBoard() {
        String horizontalPart = "+---+---+---+";
        for (int row = 0; row < 3; row++) {
            System.out.println(horizontalPart);
            for (int coloumn = 1; coloumn < 4; coloumn++) {
                System.out.print("| " + board[row * 3 + coloumn] + " ");
            }
            System.out.print("|\n");
        }
        System.out.print(horizontalPart);
        System.out.print("\n");
    }
    /**
     * This makeMove method will take user input from 1 to 9 place your move on the given input.
     * if player==0 then it'll assign the value as given by computer.
     */
    public static boolean makeMove(int index, int player) {
        if (board[index] == emptyspace) {
            if (player == 0) {
                System.out.println("Computer played: ");
                for (int i=0;i<3;i++){
                    board[index] = computersymbol;
                }
                blockOpponent();
            } else {
                System.out.println("Player played: ");
                cornorAvailability();
                board[index] = usersymbol;
            }
            showBoard();
            checkWin();
            return false;
        } else {
            return true;
        }
    }
    /**
     * This tossForFirstPlay method will get the input from user and check whether it's a head or tail by using random function
     */
    public static void tossForFirstPlay() {
        int player;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Toss (H or T):");
        String toss = sc.next();
        int i = (int) Math.round(Math.random()) % 2;
        if ((i == 1 && toss.equals("H")) || (i == 0 && toss.equals("T"))) {
            System.out.println("Congratulations! You've won the Toss.");
            player = 1;
        } else {
            System.out.println("You've lost Toss. Computer plays first.");
            player = 0;
        }
    }
    public static void playGame() {
        for (index = 0; index < 9; index++) {
            if (player == 0) {
                computerPlay();
                player = 1;
            } else {
                checkUserCanWin();
                cornorAvailability();
                System.out.println("Select Position (1-9): ");
                while (makeMove(SCANNER.nextInt(), player)) {
                    System.out.println("Try different place.");
                }
                player = 0;
            }
            if (index == 9) {
                System.out.println("Game Draw!");
                System.exit(0);}
        }
    }
    /**
     * This checkWin method will check all the possible winning chances...
     */
    public static void checkWin() {
        if ((board[1] == usersymbol && board[2] == usersymbol && board[3] == usersymbol) ||
                (board[4] == usersymbol && board[5] == usersymbol && board[6] == usersymbol) ||
                (board[7] == usersymbol && board[8] == usersymbol && board[9] == usersymbol) ||
                (board[1] == usersymbol && board[4] == usersymbol && board[7] == usersymbol) ||
                (board[2] == usersymbol && board[5] == usersymbol && board[8] == usersymbol) ||
                (board[3] == usersymbol && board[6] == usersymbol && board[9] == usersymbol) ||
                (board[1] == usersymbol && board[5] == usersymbol && board[9] == usersymbol) ||
                (board[3] == usersymbol && board[5] == usersymbol && board[7] == usersymbol)) {
            System.out.println("Player Wins!");
            System.exit(0);
        }
        if ((board[1] == computersymbol && board[2] == computersymbol && board[3] == computersymbol) ||
                (board[4] == computersymbol && board[5] == computersymbol && board[6] == computersymbol) ||
                (board[7] == computersymbol && board[8] == computersymbol && board[9] == computersymbol) ||
                (board[1] == computersymbol && board[4] == computersymbol && board[7] == computersymbol) ||
                (board[2] == computersymbol && board[5] == computersymbol && board[8] == computersymbol) ||
                (board[3] == computersymbol && board[6] == computersymbol && board[9] == computersymbol) ||
                (board[1] == computersymbol && board[5] == computersymbol && board[9] == computersymbol) ||
                (board[3] == computersymbol && board[5] == computersymbol && board[7] == computersymbol)) {
            System.out.println("Player Lost!");
            System.exit(0);
        }
    }
    private static void computerPlay() {
        // TODO: Implementation computer playing logic
        while (makeMove((int) (Math.random() * 8) + 1, 0)) {
            if (index == 9) {
                System.out.println("Game Draw!");
                System.exit(0);}
            System.out.println("");
        }
    }
    /**
     * This checkusercanwin will fetch all possibilities.
     * then conclude the result as player can win from computer
     */
    private static void checkUserCanWin() {
        if ((board[1] == usersymbol && board[2] == usersymbol && board[3] == emptyspace) ||
                (board[4] == usersymbol && board[5] == usersymbol && board[6] == emptyspace) ||
                (board[7] == usersymbol && board[8] == usersymbol && board[9] == emptyspace) ||
                (board[1] == usersymbol && board[4] == usersymbol && board[7] == emptyspace) ||
                (board[2] == usersymbol && board[5] == usersymbol && board[8] == emptyspace) ||
                (board[3] == usersymbol && board[6] == usersymbol && board[9] == emptyspace) ||
                (board[1] == usersymbol && board[5] == usersymbol && board[9] == emptyspace) ||
                (board[3] == usersymbol && board[5] == usersymbol && board[7] == emptyspace) ||
                (board[1] == emptyspace && board[2] == usersymbol && board[3] == usersymbol) ||
                (board[4] == emptyspace && board[5] == usersymbol && board[6] == usersymbol) ||
                (board[7] == emptyspace && board[8] == usersymbol && board[9] == usersymbol) ||
                (board[1] == emptyspace && board[4] == usersymbol && board[7] == usersymbol) ||
                (board[2] == emptyspace && board[5] == usersymbol && board[8] == usersymbol) ||
                (board[3] == emptyspace && board[6] == usersymbol && board[9] == usersymbol) ||
                (board[1] == emptyspace && board[5] == usersymbol && board[9] == usersymbol) ||
                (board[3] == emptyspace && board[5] == usersymbol && board[7] == usersymbol) ||
                (board[1] == usersymbol && board[2] == emptyspace && board[3] == usersymbol) ||
                (board[4] == usersymbol && board[5] == emptyspace && board[6] == usersymbol) ||
                (board[7] == usersymbol && board[8] == emptyspace && board[9] == usersymbol) ||
                (board[1] == usersymbol && board[4] == emptyspace && board[7] == usersymbol) ||
                (board[2] == usersymbol && board[5] == emptyspace && board[8] == usersymbol) ||
                (board[3] == usersymbol && board[6] == emptyspace && board[9] == usersymbol) ||
                (board[1] == usersymbol && board[5] == emptyspace && board[9] == usersymbol) ||
                (board[3] == usersymbol && board[5] == emptyspace && board[7] == usersymbol)){
            System.out.println("Player can Win! from Computer");
        }

    }
    private static void blockOpponent(){  // Block Oponent
        if(board[1] == usersymbol && board[2] == usersymbol){
            board[3]=computersymbol;
        }
        if(board[9] == usersymbol && board[6] == usersymbol){
            board[3]=computersymbol;
        }
        if(board[7] == usersymbol && board[5] == usersymbol){
            board[3]=computersymbol;
        }
        if(board[3] == usersymbol && board[2] == usersymbol){
            board[1]=computersymbol;
        }
        if(board[9] == usersymbol && board[5] == usersymbol){
            board[1]=computersymbol;
        }
        if(board[7] == usersymbol && board[4] == usersymbol){
            board[1]=computersymbol;
        }
        if(board[3] == usersymbol && board[1] == usersymbol){
            board[2]=computersymbol;
        }
        if (board[8] == usersymbol && board[5] == usersymbol){
            board[2]=computersymbol;
        }
        if (board[1] == usersymbol && board[4] == usersymbol){
            board[7]=computersymbol;
        }
        if(board[3] == usersymbol && board[5] == usersymbol){
            board[7]=computersymbol;
        }
        if(board[8] == usersymbol && board[9] == usersymbol){
            board[7]=computersymbol;
        }
        if(board[1] == usersymbol && board[5] == usersymbol){
            board[9]=computersymbol;
        }
        if(board[3] == usersymbol && board[6] == usersymbol){
            board[9]=computersymbol;
        }
        if(board[7] == usersymbol && board[8] == usersymbol){
            board[9]=computersymbol;
        }
        if(board[5] == usersymbol && board[2] == usersymbol){
            board[8]=computersymbol;
        }
        if(board[9] == usersymbol && board[7] == usersymbol){
            board[8]=computersymbol;
        }
        if(board[5] == usersymbol && board[6] == usersymbol){
            board[4]=computersymbol;
        }
        if (board[1] == usersymbol && board[7] == usersymbol){
            board[4]=computersymbol;
        }
        if(board[1] == usersymbol && board[9] == usersymbol){
            board[5]=computersymbol;
        }
        if(board[3] == usersymbol && board[7] == usersymbol){
            board[5]=computersymbol;
        }
        if(board[2] == usersymbol && board[8] == usersymbol){
            board[5]=computersymbol;
        }
        if(board[4] == usersymbol && board[6] == usersymbol){
            board[5]=computersymbol;
        }
        if(board[5] == usersymbol && board[4] == usersymbol){
            board[6]=computersymbol;
        }
        if (board[9] == usersymbol && board[3] == usersymbol){
            board[6]=computersymbol;
        }
    }
    /**
     * Added cornor availability method to check the cornors are avilable or not.
     * if available the the position will move towards cornor at the end.
     */
    public static void cornorAvailability() {
        if (board[1] == emptyspace) {
            System.out.println("select 1st position --Cornor is available");
        } else if (board[3] == emptyspace) {
            System.out.println("select 3rd position -- Cornor is available");
        } else if (board[7] == emptyspace) {
            System.out.println("select 7th position -- Cornor is available");
        } else if (board[9] == emptyspace) {
            System.out.println("select 9th position -- Cornor is available");
        }
    }
    public static void centerAvailability(){  // Checking Center positionh
        if(board[5] == emptyspace){
            System.out.println("Center position is available");
        }else{
            System.out.println("Center position is not available..Try another position");
        }

    }
    /**
     * Here I have created a main method to execute the program.
     * an object got created named tictactoe.which called the following methods.
     *
     * args
     */
    public static void main(String[] args) {
        TicTacToeGame tictactoe = new TicTacToeGame(); //created object for class TicTacToeGame
        tictactoe.showBoard();
        tictactoe.playGame();
    }
}