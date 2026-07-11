package LeetCodeJava;

import java.util.HashMap;

public class problem0062 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths2(3, 7));
    }

    public static int uniquePaths(int m, int n) {
        int[][] coordinateWaysCountMap = new int[m][n];
        // most top one will only have 1 possible way which is 1 from the left, 
        // and most left one also will only have 1 possible way which is from the top, 
        // so assign as 1 for the most left and top array
        for(int i = 0; i < m; i++) {
            coordinateWaysCountMap[i][0] = 1;
        }
        for(int j = 0; j < n; j++) {
            coordinateWaysCountMap[0][j] = 1;
        }
        for(int x = 0; x < m; x++) {
            for(int y = 0; y < n; y++) {
                if (coordinateWaysCountMap[x][y] != 0) {
                    continue;
                }
                coordinateWaysCountMap[x][y] = coordinateWaysCountMap[x-1][y] + coordinateWaysCountMap[x][y-1];
            }
        }
        return coordinateWaysCountMap[m-1][n-1];
    }

    public static int uniquePaths2(int m, int n) {
        HashMap<String, Integer> backtrackTotalUniquePathMap = new HashMap<>();
        int totalUniquePaths = backtrack(0, 0, m, n, backtrackTotalUniquePathMap);
        return totalUniquePaths;
    }

    public static int backtrack(int x, int y, int m, int n, HashMap<String, Integer> backtrackTotalUniquePathMap) {
        if (backtrackTotalUniquePathMap.get(String.format("%d:%d", x, y)) != null) {
            return backtrackTotalUniquePathMap.get(String.format("%d:%d", x, y));
        }

        int totalUniquePaths = 0;
        if (x < m-1) {
            totalUniquePaths += backtrack(x+1, y, m, n, backtrackTotalUniquePathMap);
        }

        if (y < n-1) {
            totalUniquePaths += backtrack(x, y+1, m, n, backtrackTotalUniquePathMap);
        }

        if (x == m-1 && y == n-1) {
            totalUniquePaths++;
        }

        backtrackTotalUniquePathMap.put(String.format("%d:%d", x, y), totalUniquePaths);
        return totalUniquePaths;
    }
}
