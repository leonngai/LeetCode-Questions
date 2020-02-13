class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        
        //Do a first pass to find out when the last occurence of each letter is
        int[] lastSeen = new int[26];
        
        for (int i = 0; i < S.length(); i++) 
            lastSeen[S.charAt(i) - 'a'] = i;
        
        //Do a second pass to find out the longest possible partitions for each letter
        int start = 0, end = 0;
        
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, lastSeen[S.charAt(i) - 'a']);
            
            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        
        
        return ans;
    }
}
