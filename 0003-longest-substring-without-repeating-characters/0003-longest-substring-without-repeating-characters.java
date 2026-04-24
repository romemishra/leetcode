class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int low = 0;
        int result = 0;
        boolean[] visited = new boolean[256];
        for (int high = 0; high < s.length(); high++) {
            char c = s.charAt(high);
            while (visited[c]) {
                char l = s.charAt(low);
                visited[l] = false;
                low++;
            }
            visited[c] = true;
            result = Math.max(result, high - low + 1);
        }
        return result;
    }
}