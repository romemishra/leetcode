class Solution {

    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> lastIndexMap = new HashMap<>();
        int best = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            Integer lastIndex = lastIndexMap.get(nums[i]);

            if (lastIndex != null) {
                best = Math.min(best, i - lastIndex);

                if (best == 1) {
                    return 1;
                }

            }

            lastIndexMap.put(reverseInt(nums[i]), i);
        }

        return best == Integer.MAX_VALUE ? -1 : best;
    }

    private int reverseInt(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        return rev;
    }

    /*
    private int reverseInt(int x) {
        String xStr = "" + x;
        String xReversed = new StringBuilder(xStr).reverse().toString();
        return Integer.parseInt(xReversed);
    }
    */

}