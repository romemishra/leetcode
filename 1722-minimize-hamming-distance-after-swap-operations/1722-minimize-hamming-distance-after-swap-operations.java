class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
         int n = source.length;
        
        UnionFind uf = new UnionFind(n);
        
        // Step 1: Union operations
        for (int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }
        
        // Step 2: Group indices by root
        Map<Integer, List<Integer>> groups = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }
        
        int hammingDistance = 0;
        
        // Step 3: Process each component
        for (List<Integer> group : groups.values()) {
            Map<Integer, Integer> freq = new HashMap<>();
            
            // Count source frequencies
            for (int idx : group) {
                freq.put(source[idx], freq.getOrDefault(source[idx], 0) + 1);
            }
            
            // Match with target
            for (int idx : group) {
                if (freq.getOrDefault(target[idx], 0) > 0) {
                    freq.put(target[idx], freq.get(target[idx]) - 1);
                } else {
                    hammingDistance++;
                }
            }
        }
        
        return hammingDistance;
    }
}

// DSU (Union-Find)
class UnionFind {
    int[] parent;
    
    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }
    
    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA != rootB) {
            parent[rootA] = rootB;
        }
    }
}