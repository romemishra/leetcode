class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;

        int l2 = nums2.length;
        int l1 = nums1.length;

        int i = 0;
        int j = 0;

        while(i < l1 && j < l2) {
            if(nums1[i] <= nums2[j]) {
                max = Math.max(max, j - i);
                j++;
            } else {
                i++;
                j++;
            }
        }

        return max;
    }
}