/**
 * @Author Brandon Daryl Wanji
 * Date : October 4th 2019
 */

import java.util.Scanner;
public class Game {
    Scanner in = new Scanner(System.in);
    char player1 = 'X';
    char player2 = 'O';

    Board board = new Board();

    public Game() {
        playGame();
    }

    public void playGame()
    {
        board.emptyBoard();
        System.out.println("Welcome to Connect 4");
        System.out.println("Please Enter a mode in which you mode.");
        System.out.println("Enter : \n 1- For P vs P           2- P  vs Comp ");
        int choice = in.nextInt();
        switch (choice)
        {
            case 1:
                System.out.println("Please choose a column in which you want to play. Ranges from 0 - 6");
                for (int j = 0; j <=board.board.length ; j++) {
                    System.out.print(j+"   ");
                }
                System.out.println(" ");
                printBoard(board.board);
                while(board.isEmpty()) {
                    player1(player1);
                    for (int j = 0; j <=board.board.length ; j++) {
                        System.out.print(j+"   ");
                    }
                    System.out.println(" ");
                    printBoard(board.board);
                    if(player1 == checkWin(board.board))
                    {
                        System.out.println(" ");
                        for (int j = 0; j <=board.board.length ; j++) {
                            System.out.print(j+"   ");
                        }
                        System.out.println(" ");
                        printBoard(board.board);
                        System.out.println(" Player : "+ player1 + " wins");
                        System.out.println(" Replay ? : \n 0 :Yes               1:No");
                        int replay = in.nextInt();
                        switch (replay)
                        {
                            case 0: playGame();
                            case 1:
                                System.out.println("Not Yet Implemented ");
                                break;
                            default:
                                break;
                        }
                        break;
                    }
                    else
                        player2(player2);
                    for (int j = 0; j <=board.board.length ; j++) {
                        System.out.print(j+"   ");
                    }
                    System.out.println(" ");
                    printBoard(board.board);
                    if(player2 == checkWin(board.board))
                    {
                        System.out.println(" ");
                        printBoard(board.board);
                        System.out.println(" Player : "+ player2+ " wins");
                        System.out.println(" Replay ? : \n 0 :Yes               1:No");
                        int replay = in.nextInt();
                        switch (replay)
                        {
                            case 0: playGame();
                            case 1: break;
                            default:
                                break;
                        }
                        break;
                    }
                }

                break;
            case 2:
                System.out.println( " Coming Soon");
                break;

            default:
                printBoard(board.board);
                break;
        }


    }

    /**
     * This method prints "theBoard" to the Terminal
     * @param theBoard, represents the board at each state of the program
     */
    public void printBoard(char [][] theBoard)
    {
        for (int i = 0; i <theBoard.length ; i++) {
            for (int j = 0; j <theBoard[i].length ; j++) {
                System.out.print(theBoard[i][j]+" | ");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param board
     * @return the Player that Won.
     */
    public  char checkWin(char[][] board) {
        for (int row = 0; row < board.length; row++) { // iterate rows, bottom to top
            for (int column = 0; column < board[0].length; column++) { // iterate columns, left to right
                char player = board[row][column];
                if (player == ' ')
                    continue; // don't check empty slots

                if (column + 3 < board[0].length &&
                        player == board[row][column+1] && // look right
                        player == board[row][column+2] &&
                        player == board[row][column+3])
                    return player;
                if (row + 3 < board.length) {
                    if (player == board[row+1][column] && // look up
                            player == board[row+2][column] &&
                            player == board[row+3][column])
                        return player;
                    if (column + 3 < board[0].length &&
                            player == board[row+1][column+1] && // look up & right
                            player == board[row+2][column+2] &&
                            player == board[row+3][column+3])
                        return player;
                    if (column - 3 >= 0 &&
                            player == board[row+1][column-1] && // look up & left
                            player == board[row+2][column-2] &&
                            player == board[row+3][column-3])
                        return player;
                }
            }
        }
        return ' '; // no winner found
    }

    public char [][] player1( char player)
    {
        int play = in.nextInt();
        return  board.addX(player,play);
    }

    public char [][] player2(char player)
    {
        int play = in.nextInt();
        return  board.addX(player,play);
    }


    public static void main(String[] args) {
        new Game();
    }
}