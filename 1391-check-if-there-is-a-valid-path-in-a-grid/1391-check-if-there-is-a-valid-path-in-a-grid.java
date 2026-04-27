class Solution {
    
    // incomingDir 0:left, 1: up, 2:right, 3: down
    static int[][] DIRS = {{0,-1},{-1,0},{0,1},{1,0}};
    int m, n;
    int[][] grid;
    boolean[][] visited;

    static int[][] OUT = {
        {0, 2}, 
        {1, 3},
        {0, 3},
        {2, 3},
        {0, 1},
        {1, 2}
    };

    public boolean hasValidPath(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        int incomingDir = 0;
        return dfs(0, 0, incomingDir);
    }
    

    boolean dfs(int r, int c, int incomingDir) {
        visited[r][c] = true;
        if (r == m - 1 && c == n - 1) return true;

        boolean canReach = false;

        int street = grid[r][c];

        for (int dirIdx : OUT[street - 1]) {
            int[] dir = DIRS[dirIdx];
            int nr = r + dir[0], nc = c + dir[1];
            if (
                nr >= 0 && nr < m && nc >= 0 && nc < n
                && !visited[nr][nc] && accept(grid[nr][nc], dirIdx)
            ) {
                if (dfs(nr, nc, dirIdx)) {
                    canReach = true;
                }
            }
        }

        return canReach;
    }


    boolean accept(int street, int incomingDir) {
        if (street == 1) return incomingDir == 0 || incomingDir == 2;
        if (street == 2) return incomingDir == 1 || incomingDir == 3;
        if (street == 3) return incomingDir == 2 || incomingDir == 1;
        if (street == 4) return incomingDir == 0 || incomingDir == 1;
        if (street == 5) return incomingDir == 2 || incomingDir == 3;
        if (street == 6) return incomingDir == 0 || incomingDir == 3;
        return false;
    }
}
