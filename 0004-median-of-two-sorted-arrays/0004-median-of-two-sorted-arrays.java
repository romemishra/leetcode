class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      //using binary search 
      int total = nums1.length + nums2.length;
     
      double median = 0.0;
      // using bs for smaller array
      if(nums1.length > nums2.length){
           return findMedianSortedArrays(nums2 , nums1);
       }

       int l = 0 ;
       int h = nums1.length;

      
       while(l<= h){

        // partition points;
       int cut1 =(l+h)/2;
       int cut2= (total+1)/2 -cut1 ;


        // leftm most in each partition
        int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
        int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];

        //right least
       int r1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
       int r2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];

        // comparisions
        if(l1<= r2 && l2 <= r1){
            // if even length
            if(total % 2 == 0){
                return median = (Math.max(l1 , l2) + Math.min(r1 , r2))/2.0; 
            }
            else{
                return median = Math.max (l1 , l2);
            }
        
        }
        // search in left 
        else if(l1> r2){
            h = cut1 - 1;
        }
        else{
            l = cut1+1;
        }

      
       }
       
        return 0.0 ;
       

    }
}