import java.util.*;

class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int minDist = Integer.MAX_VALUE;

        for (int j = 0; j < nums.length; j++) {
            // Check if current number matches any stored reverse
            Integer i = map.get(nums[j]);
            if (i != null) {
                minDist = Math.min(minDist, j - i);
            }

            // Store reverse of current number
            int rev = reverse(nums[j]);
            map.put(rev, j);
        }

        return (minDist == Integer.MAX_VALUE) ? -1 : minDist;
    }

    private int reverse(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        return rev;
    }
}