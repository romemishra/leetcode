class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        String num = Integer.toString(x);
        int start = 0;
        int end = num.length() - 1;
        for(int counter = 0; counter < num.length()/2; counter++){
            if(num.charAt(start + counter ) != num.charAt(end - counter)){
                return false;
            }
        }
        return true;
    }
}