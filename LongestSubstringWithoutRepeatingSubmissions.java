class Solution {
    /*
        Process:
        1. Use hashmap to keep track of where each characters are located using sliding window
        2. If what we see at the end has already been found in the hashmap, set our start to max of start and the index of this character
        3. update our answer in each iteration
        
        Time Complexity: O(N)
        Space Complexity: O(N)
    */
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, ans = 0;
        HashMap<Character, Integer> hash = new HashMap<>();
        
        while(end < s.length()) {
            if (hash.containsKey(s.charAt(end))) {
                start = Math.max(start, hash.get(s.charAt(end)) + 1);
            }
            
            ans = Math.max(ans, end - start + 1);
            hash.put(s.charAt(end), end);
            end++;
        }
        
        return ans;
    }
}
