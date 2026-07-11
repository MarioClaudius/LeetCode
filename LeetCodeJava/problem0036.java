package LeetCodeJava;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class problem0036 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        return isValidRows(board) && isValidColumn(board) && isValidArea(board);
    }

    public static boolean isValidRows(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            int numCount = 0;
            Set<Character> uniqueChar = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                uniqueChar.add(board[i][j]);
                numCount++;
            }
            if (numCount != uniqueChar.size()) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidColumn(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            int numCount = 0;
            Set<Character> uniqueChar = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                uniqueChar.add(board[j][i]);
                numCount++;
            }
            if (numCount != uniqueChar.size()) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidArea(char[][] board) {
        HashMap<Integer, Integer> areaNumCountMap = new HashMap<>();
        HashMap<Integer, Set<Character>> areaUniqueCharMap = new HashMap<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int key = ((i / 3) * 10) + (j / 3);
                if (areaNumCountMap.get(key) == null) {
                    areaNumCountMap.put(key, 1);
                } else {
                    areaNumCountMap.put(key, areaNumCountMap.get(key) + 1);
                }

                if (areaUniqueCharMap.get(key) == null) {
                    Set<Character> areaUniqueChar = new HashSet<>();
                    areaUniqueChar.add(board[i][j]);
                    areaUniqueCharMap.put(key, areaUniqueChar);
                } else {
                    areaUniqueCharMap.get(key).add(board[i][j]);
                }
            }
        }

        for(Integer key : areaNumCountMap.keySet()) {
            if (areaNumCountMap.get(key) != areaUniqueCharMap.get(key).size()) {
                return false;
            }
        }

        return true;
    }
}
