import java.util.Arrays;

class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        
        // Convert all boundary points to perimeter positions and sort
        int n = points.length;
        long[] pos = new long[n];
        for (int i = 0; i < n; i++) {
            pos[i] = toPerimeter(points[i][0], points[i][1], side);
        }
        Arrays.sort(pos);
        
        long P = 4L * side; // full perimeter
        
        // Binary search on the answer
        long lo = 1, hi = 2L * side;
        while (lo < hi) {
            long mid = (lo + hi + 1) >>> 1;
            if (feasible(pos, n, k, mid, P)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        
        return (int) lo;
    }
    
    /**
     * Map a boundary point (x, y) to its perimeter distance from (0,0),
     * walking clockwise:
     *   Bottom edge (y=0):  (0,0) → (S,0)   : t = x
     *   Right  edge (x=S):  (S,0) → (S,S)   : t = S + y
     *   Top    edge (y=S):  (S,S) → (0,S)   : t = 2S + (S - x)
     *   Left   edge (x=0):  (0,S) → (0,0)   : t = 3S + (S - y)
     */
    private long toPerimeter(int x, int y, int S) {
        if (y == 0)      return x;
        else if (x == S) return S + y;
        else if (y == S) return 2L * S + (S - x);
        else             return 3L * S + (S - y);
    }
    
    /**
     * Check if k points can be selected from sorted perimeter positions
     * such that every consecutive pair (including the circular wrap-around)
     * has perimeter distance >= d.
     *
     * Strategy: Try each point as the starting point, then greedily jump
     * forward using binary search (k-1) times, and finally verify the
     * closing gap back to the start.
     *
     * Time: O(n * k * log n)
     */
    private boolean feasible(long[] pos, int n, int k, long d, long P) {
        for (int start = 0; start < n; start++) {
            long cur = pos[start];
            boolean ok = true;
            
            for (int step = 0; step < k - 1; step++) {
                long need = cur + d;
                if (need >= P) { // would wrap around before closing
                    ok = false;
                    break;
                }
                // Find leftmost index with pos[j] >= need
                int j = lowerBound(pos, n, need);
                if (j == n) {
                    ok = false;
                    break;
                }
                cur = pos[j];
            }
            
            if (ok) {
                // Closing gap: perimeter distance from last point back to start
                // going forward (wrapping around the perimeter)
                if (pos[start] + P - cur >= d) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Returns the index of the first element in pos[0..n-1] that is >= target.
     * Returns n if no such element exists.
     */
    private int lowerBound(long[] pos, int n, long target) {
        int lo = 0, hi = n;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (pos[mid] < target) lo = mid + 1;
            else                   hi = mid;
        }
        return lo;
    }
}