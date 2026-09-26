package LeetCodeJava;

public class problem0200 {
    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        }));

        System.out.println(numIslands(new char[][]{
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        }));
    }

    public static int numIslands(char[][] grid) {
        boolean[][] visitedCoordinate = new boolean[grid.length][grid[0].length];
        int islandsCount = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (!visitedCoordinate[i][j]) {
                    visitIslandCoordinate(i, j, grid, visitedCoordinate);
                    if (grid[i][j] == '1') {
                        islandsCount++;
                    }
                }
            }
        }
        return islandsCount;
    }

    public static void visitIslandCoordinate(int x, int y, char[][] grid, boolean[][] visitedCoordinate) {
        // base case
        if (x > grid.length-1 || y > grid[0].length-1 || x < 0 || y < 0) {
            return;
        }
        if (visitedCoordinate[x][y]) {
            return;
        }
        visitedCoordinate[x][y] = true;
        if (grid[x][y] == '0') {
            return;
        }
        visitIslandCoordinate(x-1, y, grid, visitedCoordinate);
        visitIslandCoordinate(x+1, y, grid, visitedCoordinate);
        visitIslandCoordinate(x, y-1, grid, visitedCoordinate);
        visitIslandCoordinate(x, y+1, grid, visitedCoordinate);
    }
}
