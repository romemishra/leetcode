class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        
        java.util.Queue<int[]> q = new java.util.LinkedList<>();
        q.offer(new int[]{0, 0});
        vis[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            
            if (r == m - 1 && c == n - 1) return true;
            
            int type = grid[r][c];
            
            // UP
            if ((type == 2 || type == 5 || type == 6) && r > 0) {
                int next = grid[r - 1][c];
                if (!vis[r - 1][c] && (next == 2 || next == 3 || next == 4)) {
                    vis[r - 1][c] = true;
                    q.offer(new int[]{r - 1, c});
                }
            }
            
            // DOWN
            if ((type == 2 || type == 3 || type == 4) && r < m - 1) {
                int next = grid[r + 1][c];
                if (!vis[r + 1][c] && (next == 2 || next == 5 || next == 6)) {
                    vis[r + 1][c] = true;
                    q.offer(new int[]{r + 1, c});
                }
            }
            
            // LEFT
            if ((type == 1 || type == 3 || type == 5) && c > 0) {
                int next = grid[r][c - 1];
                if (!vis[r][c - 1] && (next == 1 || next == 4 || next == 6)) {
                    vis[r][c - 1] = true;
                    q.offer(new int[]{r, c - 1});
                }
            }
            
            // RIGHT
            if ((type == 1 || type == 4 || type == 6) && c < n - 1) {
                int next = grid[r][c + 1];
                if (!vis[r][c + 1] && (next == 1 || next == 3 || next == 5)) {
                    vis[r][c + 1] = true;
                    q.offer(new int[]{r, c + 1});
                }
            }
        }
        
        return false;
    }
}