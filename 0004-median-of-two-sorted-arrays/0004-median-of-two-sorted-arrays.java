class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        int m = nums1.length;
        int n = nums2.length;
        
        int i=0;
        int j=0;
        
        while(pq.size()<=(m+n)/2){
            
            
            if(i<m && j<n){
                
                if(nums1[i]<nums2[j]){
                    pq.add(nums1[i]);
                    i++;
                }else{
                    pq.add(nums2[j]);
                    j++;
                }
                
            }else if(i>=m){
                 pq.add(nums2[j]);
                 j++;
            }else if(j>=n){
                 pq.add(nums1[i]);
                 i++;
            }
            
        }
        
        if((m+n)%2==0){
            return ((double)((pq.poll()+pq.peek())))/2D;
        }
        
        return pq.peek();
    }
}