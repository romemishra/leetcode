class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (!map.containsKey(x)) {
                map.put(x, new int[] {-1, i});
            } else {
                var arr = map.get(x);
                if (arr[0] != -1) {
                    min = Math.min(2 * (i - arr[0]), min);
                }
                arr[0] = arr[1];
                arr[1] = i;
            }
        }
        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        return min;
    }
}