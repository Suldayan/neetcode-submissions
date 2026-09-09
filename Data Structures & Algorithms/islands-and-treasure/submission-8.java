class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            final int[] cell = queue.poll();
            final int row = cell[0];
            final int column = cell[1];

            for (final int[] direction : directions) {
                final int nRow = row + direction[0];
                final int nColumn = column + direction[1];

                if (nRow >= 0 && nRow < grid.length && nColumn >= 0 && nColumn < grid[0].length && grid[nRow][nColumn] == Integer.MAX_VALUE) {
                    grid[nRow][nColumn] = grid[row][column] + 1;
                    queue.add(new int[]{nRow, nColumn});
                }
            }
        }
    }
}
