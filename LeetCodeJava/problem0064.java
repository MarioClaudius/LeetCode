package LeetCodeJava;

import java.util.HashMap;

public class problem0064 {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{
            {1,1},
            {3,2},
            {2,1}
        }));
        System.out.println(minPathSum(new int[][]{
            {1,3,1},
            {1,5,1},
            {4,2,1}
        }));
        System.out.println(minPathSum(new int[][]{
            {1,2,3},
            {4,5,6}
        }));
    }

    public static int minPathSum(int[][] grid) {
        HashMap<String, Integer> indexMinimumPathSum = new HashMap<>();
        return backtrack(0, 0, 0, grid, indexMinimumPathSum);
    }

    public static int backtrack(int x, int y, int currentSum, int[][] grid, HashMap<String, Integer> indexMinimumPathSum) {
        // base case
        if (x > grid.length-1 || y > grid[0].length-1) {
            return -1;
        }

        currentSum += grid[x][y];
        if (indexMinimumPathSum.containsKey(String.format("%d,%d", x, y))) {
            return currentSum + indexMinimumPathSum.get(String.format("%d,%d", x, y));
        }
        if (x == grid.length-1 && y == grid[0].length-1) {
            return currentSum;
        }

        int rightSum = backtrack(x, y+1, currentSum, grid, indexMinimumPathSum);
        int bottomSum = backtrack(x+1, y, currentSum, grid, indexMinimumPathSum);
        if (rightSum == -1) {
            indexMinimumPathSum.put(String.format("%d,%d", x, y), bottomSum-currentSum);
            return bottomSum;
        }
        if (bottomSum == -1) {
            indexMinimumPathSum.put(String.format("%d,%d", x, y), rightSum-currentSum);
            return rightSum;
        }

        if (rightSum < bottomSum) {
            indexMinimumPathSum.put(String.format("%d,%d", x, y), rightSum-currentSum);
            return rightSum;
        }

        indexMinimumPathSum.put(String.format("%d,%d", x, y), bottomSum-currentSum);
        return bottomSum;
    }
}
