class Solution {
    int[][][] dp;

    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n][k + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(dp[i][j], -1);
        return Math.max(score(grid, 0, 0, 0, k), -1);
    }

    public int score(int[][] grid, int i, int j, int cost, int k) {
        if (i >= grid.length || j >= grid[0].length)
            return Integer.MIN_VALUE;
        cost += (grid[i][j] == 0 ? 0 : 1);
        if (cost > k)
            return Integer.MIN_VALUE;
        if (i == grid.length - 1 && j == grid[0].length - 1)
            return grid[i][j];
        if (dp[i][j][cost] != -1)
            return dp[i][j][cost];
        int r = grid[i][j] + score(grid, i + 1, j, cost, k);
        int d = grid[i][j] + score(grid, i, j + 1, cost, k);

        return dp[i][j][cost] = Math.max(r, d);

    }
}