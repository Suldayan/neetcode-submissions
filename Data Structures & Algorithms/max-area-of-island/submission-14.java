class Solution {
    private int getArea(
        final int[][] grid, 
        final int i, 
        final int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
                return 0;
            }

            grid[i][j] = -1;

            return 1 +
                getArea(grid, i + 1, j) +
                getArea(grid, i - 1, j) +
                getArea(grid, i, j + 1) +
                getArea(grid, i, j - 1);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 || grid[i][j] == -1) {
                    continue;
                }

                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, getArea(grid, i, j));
                }
            }
        }

        return maxArea;
    }
}
