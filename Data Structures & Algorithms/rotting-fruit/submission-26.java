class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int freshFruit = 0;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                final int currentCell = grid[i][j];
                if (currentCell == 0) {
                    continue;
                }

                if (currentCell == 1) {
                    freshFruit++;
                }

                if (currentCell == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty() && freshFruit > 0) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                final int[] cell = queue.poll();
                final int i = cell[0];
                final int j = cell[1];

                if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    queue.add(new int[]{i + 1, j});
                    freshFruit--;
                }

                if (i > 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    queue.add(new int[]{i - 1, j});
                    freshFruit--;
                }

                if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    queue.add(new int[]{i, j + 1});
                    freshFruit--;
                }

                if (j > 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    queue.add(new int[]{i, j - 1});
                    freshFruit--;
                }
            }

            minutes++;
        }
        
        if (freshFruit == 0) {
            return minutes;
        }

        return -1;
    }
}
