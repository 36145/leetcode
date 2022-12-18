package test.arrays;

import org.testng.annotations.Test;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;

public class ValidSudokuTest {


    @Test
    public void TestValidSudoku() {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {

        HashMap<Point, HashSet<Character>> blockMap = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {

                Point blockPoint = new Point(i / 3, j / 3);
                HashSet<Character> blockSet = blockMap.getOrDefault(blockPoint, new HashSet<>());

                if (board[i][j] != '.'){

                    if (row.contains(board[i][j]) ||  blockSet.contains(board[i][j]))
                        return false;

                    row.add(board[i][j]);
                    blockSet.add(board[i][j]);
                    blockMap.put(blockPoint, blockSet);
                }

                if (  board[j][i] != '.') {
                    if (col.contains(board[j][i]))
                        return false;
                    col.add(board[j][i]);
                }



            }
        }
        return true;
    }


}
