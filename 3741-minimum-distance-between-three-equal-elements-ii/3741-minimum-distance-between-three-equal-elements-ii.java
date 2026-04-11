class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            ArrayList<Integer> l=map.getOrDefault(nums[i],new ArrayList<>());
            l.add(i);
            map.put(nums[i],l);
        }
        int min=Integer.MAX_VALUE;
        for(int key:map.keySet()){
            if(map.get(key).size()<3) continue;
            ArrayList<Integer> temp=map.get(key);
            int i=0;
            int j=1;
            int k=2;
            while(k<temp.size()){
                min=Math.min(min,2*(Math.max(temp.get(i),Math.max(temp.get(j),temp.get(k)))-Math.min(temp.get(i),Math.min(temp.get(j),temp.get(k)))));
                i++;
                j++;
                k++;
            }
        }
        return min==Integer.MAX_VALUE?-1:min;

    }
}