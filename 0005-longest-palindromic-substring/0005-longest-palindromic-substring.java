class Solution {
    public String longestPalindrome(String s)
    {
        // Brute force

        int ans = 0;
        int l = 0, r = 0;
        int n = s.length();
        for (int i=0; i<n; i++)
        {
            int currL, currR, currAns;
            currL = i-1;
            currR = i+1;
            while (currL >=0 && currR < n && s.charAt(currL) == s.charAt(currR))
            {
                currL--;
                currR++;
            }
            currAns = currR - currL - 1;
            if (ans < currAns)
            {
                ans = currAns;
                l = currL + 1;
                r = currR - 1;
                System.out.println("l = " + l + ", r = " + r + ", ans = " + ans);
            }
            
            currL = i;
            currR = i+1;
            while (currL >=0 && currR < n && s.charAt(currL) == s.charAt(currR))
            {
                currL--;
                currR++;
            }
            currAns = currR - currL - 1;
            if (ans < currAns)
            {
                ans = currAns;
                l = currL + 1;
                r = currR - 1;
                System.out.println("l = " + l + ", r = " + r + ", ans = " + ans);
            }
        }
        return s.substring(l, r+1);
    }
}