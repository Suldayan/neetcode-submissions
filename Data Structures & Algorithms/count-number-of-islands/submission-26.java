class Solution {
    private void findIsland(
        final char[][] grid, 
        final int i, 
        final int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '#';
      
        findIsland(grid, i + 1, j);
        findIsland(grid, i - 1, j);
        findIsland(grid, i, j + 1);
        findIsland(grid, i, j - 1);
     }

    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                final char c = grid[i][j];
                if (c == '#' || c == '0') {
                    continue;
                }

                if (c == '1') {
                    findIsland(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }
}
