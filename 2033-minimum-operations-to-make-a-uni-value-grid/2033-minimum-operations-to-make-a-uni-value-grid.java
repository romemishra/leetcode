class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        
        // Flatten grid
        for (int[] row : grid) {
            for (int num : row) {
                list.add(num);
            }
        }
        
        // Check feasibility
        int base = list.get(0);
        for (int num : list) {
            if ((num - base) % x != 0) {
                return -1;
            }
        }
        
        // Normalize
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) / x);
        }
        
        // Sort
        Collections.sort(list);
        
        // Median
        int median = list.get(list.size() / 2);
        
        // Count operations
        int operations = 0;
        for (int num : list) {
            operations += Math.abs(num - median);
        }
        
        return operations;
    }
}