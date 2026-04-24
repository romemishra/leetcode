class Solution {
    //     public int lengthOfLongestSubstring(String s) {
    //     int maxlen = 0;
    //     HashMap<Character, Integer> h = new HashMap<>();
        
    //     int left = 0;

    //     for (int i = 0; i < s.length(); i++) {
    //         char ch = s.charAt(i);
    //         while (h.containsKey(ch)) {
    //             h.remove(s.charAt(left));
    //             left++;
            
    //         h.put(ch, 1);

    //         maxlen = Math.max(maxlen, h.size());
    //     }

    //     return maxlen;
    // }
        public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // If duplicate found, move left pointer
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }

            // Store latest index of character
            map.put(ch, right);

            // Update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}