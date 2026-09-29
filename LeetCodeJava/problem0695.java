package LeetCodeJava;

public class problem0695 {
    // Max Area of Island
    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(new int[][]{
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
        }));
        System.out.println(maxAreaOfIsland(new int[][]{
            {0,0,0,0,0,0,0,0}
        }));
        System.out.println(maxAreaOfIsland(new int[][]{
            {1,1,0,0,0},
            {1,1,0,0,0},
            {0,0,0,1,1},
            {0,0,0,1,1}        
        }));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        boolean[][] visitedCoordinate = new boolean[grid.length][grid[0].length];
        int maxAreaOfIsland = 0;
        for(int x = 0; x < grid.length; x++) {
            for(int y = 0; y < grid[x].length; y++) {
                int areaOfIsland = checkCoordinate(x, y, grid, visitedCoordinate);
                if (maxAreaOfIsland < areaOfIsland) {
                    maxAreaOfIsland = areaOfIsland;
                }
            }
        }
        return maxAreaOfIsland;
    }

    public static int checkCoordinate(int x, int y, int[][] grid, boolean[][] visitedCoordinate) {
        if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[x].length - 1) {
            return 0;
        }
        if (visitedCoordinate[x][y]) {
            return 0;
        }

        visitedCoordinate[x][y] = true;
        if (grid[x][y] == 0) {
            return 0;
        }

        return 1 + checkCoordinate(x-1, y, grid, visitedCoordinate) + checkCoordinate(x+1, y, grid, visitedCoordinate) + checkCoordinate(x, y-1, grid, visitedCoordinate) + checkCoordinate(x, y+1, grid, visitedCoordinate);
    }
}
