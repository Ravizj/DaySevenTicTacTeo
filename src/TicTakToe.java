import java.util.Random;
import java.util.Scanner;

public class TicTakToe {
        static char board[] = new char[10];
        static char player;
        static char computer;
        static int playerLocation;

        /*
         * Created method Called Result
         */
        public static void result() {
            for (int index = 1; index < 10; index++) {
                board[index] = ' ';
            }
        }
        /*
         * Method to make a choice between Computer and player
         */

        public static void getPlayerChoice() {
            Scanner input = new Scanner(System.in);
            System.out.print("select X or O : ");
            player = input.next().toUpperCase().charAt(0);
            /**
             * Used if else conditon to check the result
             */
            if (player == 'X')
                computer = 'O';
            else
                computer = 'X';
            System.out.println("You have selected : " + player);
            System.out.println("Computer's choice is : " + computer);
        }

        /*
         * Logic for Printing the showBoard the TicTacToe Game Board.
         */
        public static void showBoard() {
            System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
            System.out.println("---------");
            System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
            System.out.println("---------");
            System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
        }

        private static void userTurn() {
            int playerMove;
            Scanner input = new Scanner(System.in);
            while (true) {

                System.out.println("Choose your location(1-9): ");
                playerMove = input.nextInt();
                if (board[playerMove] == ' ') {
                    break;
                }

            }
            System.out.println("Player choose:: " + playerMove);
            board[playerMove] = player;
        }

        /*
         * Logic for checking Player selected letter
         */
        public static void check() {
            Scanner input = new Scanner(System.in);
            System.out.println("please select your choice letter: 'X' or 'Y' ");
            char choice = input.next().toUpperCase().charAt(0);
            if (choice == 'X') {
                System.out.println("Player selected letter is:" + 'X');
                System.out.println("Computer selected letter is:" + 'O');

            } else if (choice == 'Y') {
                System.out.println("Player selected letter is:" + 'O');
                System.out.println("Computer selected letter is:" + 'X');
            }
        }

        /*
         * Method to check the free space.
         */
        private static void checkFreeSpace() {
            boolean isSpaceAvailable = false;
            int numOfFreeSpaces = 0;
            for (int index = 1; index < board.length; index++) {
                if ((board[index] == ' ')) {
                    isSpaceAvailable = true;
                    numOfFreeSpaces++;
                }
            }
            if (isSpaceAvailable == false) {
                System.err.println("Board is full! You can't make another move");
                System.exit(0);
            } else {
                System.out.println("Free space is available! you have " + numOfFreeSpaces + " moves left");
            }
        }

        /*
         * Method to check who plays first
         */
        public static void tossResult() {
            Random toss = new Random();
            Scanner input = new Scanner(System.in);
            int tossResult = toss.nextInt(2);
            System.out.println("Genarated random Number is :" + tossResult);
            System.out.println("\nChoose 0 for Heads or 1 for Tails");
            int coinSelect = input.nextInt();
            if (coinSelect == tossResult) {
                System.out.println("\nPlayer Won The Toss! Player Starts");
            } else {
                System.out.println("\nComputer Won The Toss! Computer Starts");
            }
        }

        /*
         * Method to check winning condition
         */
        private static void winningCondition() {
            if ((board[1] == player && board[2] == player && board[3] == player)
                    || (board[4] == player && board[5] == player && board[6] == player)
                    || (board[7] == player && board[8] == player && board[9] == player)
                    || (board[1] == player && board[5] == player && board[9] == player)
                    || (board[3] == player && board[5] == player && board[7] == player)
                    || (board[1] == player && board[4] == player && board[7] == player)
                    || (board[2] == player && board[5] == player && board[8] == player)
                    || (board[3] == player && board[6] == player && board[9] == player)) {
                showBoard();
                System.out.println("Player win the game");
                System.exit(0);
            }
        }

        /*
         * Method to play For computer.
         */
        private static void computerTurn() {
            int computerMove;
            while (true) {
                computerMove = (int) Math.floor(Math.random() * 10) % 9 + 1;
                if (board[computerMove] == ' ') {
                    break;
                }

            }
            System.out.println("Computer choose:: " + computerMove);
            board[computerMove] = computer;
        }

        /**
         * program execution starts from main method
         *
         * @param args
         */
        public static void main(String[] args) {
            System.out.println("Welcom to the Tic Tac Toe Game program");
            result();
            getPlayerChoice();
            tossResult();
            while (true) {
                winningCondition();
                computerTurn();
                userTurn();
                checkFreeSpace();
                showBoard();
            }

        }
}
