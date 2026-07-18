package LeetCodeJava;

import java.util.HashMap;

public class problem0063 {
    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{
            {0,0,0},
            {0,1,0},
            {0,0,0}
        }));
        System.out.println(uniquePathsWithObstacles(new int[][]{
            {0,1},
            {0,0}
        }));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        HashMap<String, Integer> indexUniquePathCount = new HashMap<>();
        return backtrack(0, 0, obstacleGrid, indexUniquePathCount);
    }

    public static int backtrack(int x, int y, int[][] obstacleGrid, HashMap<String, Integer> indexUniquePathCount) {
        // base case
        if (indexUniquePathCount.containsKey(String.format("%d,%d", x, y))) {
            return indexUniquePathCount.get(String.format("%d,%d", x, y));
        }
        if (x > obstacleGrid.length - 1) {
            return 0;
        }
        if (y > obstacleGrid[0].length - 1) {
            return 0;
        }
        if (obstacleGrid[x][y] == 1) {
            return 0;
        }
        if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1) {
            return 1;
        }

        int uniquePossiblePathCount = 0;
        // proceed to the right
        uniquePossiblePathCount += backtrack(x, y+1, obstacleGrid, indexUniquePathCount);
        // proceed to the bottom
        uniquePossiblePathCount += backtrack(x+1, y, obstacleGrid, indexUniquePathCount);

        indexUniquePathCount.put(String.format("%d,%d", x, y), uniquePossiblePathCount);
        return uniquePossiblePathCount;
    }
}
