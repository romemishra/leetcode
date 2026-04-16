class Solution {
    public int[] twoSum(int[] nums, int target) {
        int size=nums.length;
        int[] result =new int[2];
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++)
            if(nums[i]+nums[j]==target)
            result=new int[]{i,j};
        }
        return result;
        
    }
}