class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hash = new HashMap<>();
        HashMap<Character, Character> hash2 = new HashMap<>();
        int index = 0;
        
        while(index < s.length()) {
            if (!hash.containsKey(s.charAt(index)))
                hash.put(s.charAt(index), t.charAt(index));
            if (!hash2.containsKey(t.charAt(index)))
                hash2.put(t.charAt(index), s.charAt(index));
            if (hash.get(s.charAt(index)) != t.charAt(index) || hash2.get(t.charAt(index)) != s.charAt(index))
                return false;
            
            index++;
        }
        
        return true;
    }
}
