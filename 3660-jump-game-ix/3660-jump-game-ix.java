class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;

        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];

        // Build prefix maximum
        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }

        // Build suffix minimum
        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }

        int[] ans = new int[n];

        int start = 0;
        int currentMax = nums[0];

        for (int i = 0; i < n; i++) {

            currentMax = Math.max(currentMax, nums[i]);

            // End of connected component
            if (i == n - 1 || prefixMax[i] <= suffixMin[i + 1]) {

                for (int j = start; j <= i; j++) {
                    ans[j] = currentMax;
                }

                start = i + 1;

                if (start < n) {
                    currentMax = nums[start];
                }
            }
        }

        return ans;
    }
}