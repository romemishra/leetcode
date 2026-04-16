class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();

        for (int q : queries) {
            int val = nums[q];
            List<Integer> list = map.get(val);

            if (list.size() == 1){
                result.add(-1);
                continue;
            }

            int idx = Collections.binarySearch(list, q);
            int size = list.size();

            int left = list.get((idx - 1 + size) % size);
            int right = list.get((idx + 1) % size);

            int distLeft = getDist(q, left, n);
            int distRight = getDist(q, right, n);

            result.add(Math.min(distLeft, distRight));
        }
        return result;
    }
     private int getDist(int a, int b, int n) {
        int d = Math.abs(a - b);
        return Math.min(d, n - d);
    }
}