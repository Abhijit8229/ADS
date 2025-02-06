import java.util.Scanner;

class BingoBoard {
    String[][] board;
    boolean[][] marks;
    int Size;

    public BingoBoard(String[][] board, boolean[][] marks) {
        this.board = board;
        this.marks = marks;
        this.Size = 5;
    }

    public void markNumbers(int[] calledNumbers) {
        int k = 0;
        while (k < calledNumbers.length) {
            int cell = calledNumbers[k];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (!board[i][j].equals("X")) {

                        if (cell == Integer.parseInt(board[i][j]) && calledNumbers[k] != -1) {
                            marks[i][j] = true;
                            board[i][j] = "X";

                        }
                    }
                }
            }
            k++;
        }
    }

    public boolean isRowComplete(int row) {
        for (int i = 0; i < marks.length; i++) {
            if (!marks[row][i]) {
                return false;
            }
        }
        return true;

    }

    public boolean isColumnComplete(int column) {
        for (int i = 0; i < marks.length; i++) {
            if (!marks[i][column]) {
                return false;
            }
        }
        return true;
    }

    public boolean isMainDiagonalComplete() {
        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (i == j) {

                    if (!marks[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isAntiDiagonalComplete() {
        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if ((i + j) == (board.length - 1)) {

                    if (!marks[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length - 1; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.print(board[i][board.length - 1]);
            System.out.println();

        }
    }
}

class BingoGame {
    String[][] board;
    int[] calledNumbers;
    String bingoLetters;
    char[] LETTERS = { 'B', 'I', 'N', 'G', 'O' };
    BingoBoard Board;

    public BingoGame(String[][] board, int[] calledNumbers, boolean[][] marks) {
        this.board = board;
        this.calledNumbers = calledNumbers;
        this.bingoLetters = "";
        Board = new BingoBoard(board, marks);

    }

    public void play() {
        Board.markNumbers(calledNumbers);
        for (int i = 0; i < LETTERS.length; i++) {
            if (Board.isRowComplete(i)) {
                strikeLetter();
            }
            if (Board.isColumnComplete(i)) {
                strikeLetter();
            }
        }
        if (Board.isMainDiagonalComplete()) {
            strikeLetter();
        }
        if (Board.isAntiDiagonalComplete()) {
            strikeLetter();
        }
    }

    public void strikeLetter() {
        for (int i = 0; i < LETTERS.length; i++) {
            if (LETTERS[i] != '1') {
                bingoLetters += LETTERS[i] + " ";
                LETTERS[i] = '1';
                return;
            }
        }

    }

    public void printResult() {
        String rem = "";
        for (int i = 0; i < LETTERS.length; i++) {
            if (LETTERS[i] != '1') {
                rem += LETTERS[i] + " ";
            }
        }
        Board.printBoard();
        System.out.println();
        if (LETTERS.length * 2 == bingoLetters.length()) {
            System.out.println(bingoLetters.trim());
            System.out.println("Game Completed!");

        } else {

            System.out.print("Remaining Letters: " + rem.trim());
        }

    }

}

public class Solution {

    public static void main(String[] args) {
        String[][] board = new String[5][5];
        int[] calledNumbers = new int[25];
        boolean[][] marks = new boolean[5][5];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            String line = sc.nextLine().trim();
            int index = 0;
            int colIndex = 0;

            while (index < line.length()) {
                StringBuilder numStr = new StringBuilder();

                while (index < line.length() && line.charAt(index) == ' ') {
                    index++;
                }

                while (index < line.length() && line.charAt(index) != ' ') {

                    numStr.append(line.charAt(index));
                    index++;
                }

                if (numStr.length() > 0) {
                    board[i][colIndex++] = numStr.toString().trim();
                }
            }
        }

        String[] numbers = sc.nextLine().trim().split(", ");
        for (int i = 0; i < numbers.length; i++) {
            calledNumbers[i] = Integer.parseInt(numbers[i]);
        }

        for (int num : calledNumbers) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (Integer.parseInt(board[i][j]) == num) {
                        marks[i][j] = true;
                    }
                }
            }
        }
        BingoGame game = new BingoGame(board, calledNumbers, marks);
        game.play();
        game.printResult();
        sc.close();
    }
}