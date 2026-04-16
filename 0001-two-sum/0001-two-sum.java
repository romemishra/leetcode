class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] res = new int[2];
        Map<Integer, Integer> avail = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            avail.put(nums[i], i);
        }

        for(int i=0; i<nums.length; i++){
            int search = target - nums[i];
            if(avail.containsKey(search) && avail.get(search)!= i){
                res[0] = i; 
                res[1] = avail.get(search);
                return res;
            }
        }

        return res;
    }
}