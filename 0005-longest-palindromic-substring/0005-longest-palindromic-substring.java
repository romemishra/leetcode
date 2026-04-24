class Solution {
    int startInd = 0, endInd = 0;
    public String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        backtrack(charArray,0);
        return s.substring(startInd,endInd+1);
    }
    public void backtrack(char[] charArray, int i){
        if(i> charArray.length-1) return;
        int l= i, r=i;
        //ssss
        while(r< charArray.length-1 && charArray[r] == charArray[r+1]) r++;
        i = r;
        while(l>0 && r< charArray.length-1 && charArray[l-1] == charArray[r+1]){
            l--;
            r++;
        }
        if(r-l>endInd - startInd){
            startInd = l;
            endInd = r;
        }

        backtrack(charArray, ++i);
    }
}