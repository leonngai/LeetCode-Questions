class Solution {
    /*
        Process:
        1) Put count of letters from T into a map
        2) Iterate through letters from S and put however many letters from T into stringbuilder
        3) Iterate through map and keep appending letters until count of each letter is 0
        4) Return stringbuilder to string
        
        Time Complexity: O(S + T)
        Space Complexity: O(1)
    */
    public String customSortString(String S, String T) {
        int[] map = new int[26];
        
        //put count of letters into T
        for (int i = 0; i < T.length(); i++) {
            map[T.charAt(i) - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < S.length(); i++) {
            while(map[S.charAt(i) - 'a'] > 0) {
                sb.append(S.charAt(i));
                map[S.charAt(i) - 'a']--;
            }
        }
        
        for (int i = 0; i < 26; i++) {
            while(map[i] > 0) {
                sb.append((char) (i + 'a'));
                map[i]--;
            }
        }
        
        return sb.toString();
    }
}
