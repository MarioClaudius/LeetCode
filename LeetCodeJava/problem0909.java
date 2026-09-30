package LeetCodeJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class problem0909 {
    // snake and ladders
    public static void main(String[] args) {
        System.out.println(snakesAndLadders(new int[][]{
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,35,-1,-1,13,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,15,-1,-1,-1,-1}
        }));
        System.out.println(snakesAndLadders(new int[][]{
            {-1,-1,-1},
            {-1,9,8},
            {-1,8,9}
        }));
    }

    public static int snakesAndLadders(int[][] board) {
        int rowCount = 0;
        int numSign = 0;
        boolean[][] visitedBoard = new boolean[board.length][board[0].length];
        Map<Integer, String> numSignBoardIndexMap = new HashMap<>();
        for(int r = board.length-1; r >= 0; r--) {
            rowCount++;
            if (rowCount % 2 != 0) {
                for(int c = 0; c < board[r].length; c++) {
                    numSign++;
                    numSignBoardIndexMap.put(numSign, String.format("%d_%d", r, c));
                }
            } else {
                for(int c = board[r].length-1; c >= 0; c--) {
                    numSign++;
                    numSignBoardIndexMap.put(numSign, String.format("%d_%d", r, c));
                }
            }
        }
        if (numSign - 1 <= 6) {
            return 1;
        }
        int minMove = 0;
        // first queue
        List<Integer> queue = new ArrayList<>(Arrays.asList(1));
        Set<Integer> tempNextQueue = new HashSet<>();
        boolean allNumOnQueueVisited = true;
        boolean loopIsDone = false;
        while (queue.size() != 0 || tempNextQueue.size() != 0) {
            if (loopIsDone) {
                break;
            }
            if (queue.isEmpty()) {
                if (allNumOnQueueVisited) {
                    return -1;
                }
                minMove++;
                allNumOnQueueVisited = true;
                queue.addAll(tempNextQueue);
                tempNextQueue.clear();;
            }
            int currentNum = queue.removeFirst();
            String[] currentBoardIndex = numSignBoardIndexMap.get(currentNum).split("_");
            int currentR = Integer.parseInt(currentBoardIndex[0]);
            int currentC = Integer.parseInt(currentBoardIndex[1]);
            if (!visitedBoard[currentR][currentC]) {
                visitedBoard[currentR][currentC] = true;
                allNumOnQueueVisited = false;
            }
            for(int i = currentNum + 1; i <= Collections.min(Arrays.asList(currentNum+6, numSign)); i++) {
                if (i == numSign) {
                    minMove++;
                    loopIsDone = true;
                    break;
                }
                String[] boardIndex = numSignBoardIndexMap.get(i).split("_");
                int r = Integer.parseInt(boardIndex[0]);
                int c = Integer.parseInt(boardIndex[1]);

                int checkBoard = board[r][c];
                if (checkBoard == numSign) {
                    minMove++;
                    loopIsDone = true;
                    break;
                }
                if (board[r][c] != -1) {
                    tempNextQueue.add(checkBoard);
                } else {
                    tempNextQueue.add(i);
                }
            }
        }
        
        return minMove;
    }
}
