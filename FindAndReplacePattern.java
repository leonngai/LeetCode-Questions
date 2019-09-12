//Find and Replace Pattern

ass Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> answer = new ArrayList<>();
        
        //if the pattern matches then we add to the list
        for (String s: words) {
            if (matches(s, pattern)) 
                answer.add(s);
        }
        
        return answer;
    }
    
    public boolean matches (String word, String pattern) {
        //the hashmaps should be identical if it is a good match
        HashMap<Character, Character> hash1 = new HashMap<>();
        HashMap<Character, Character> hash2 = new HashMap<>();
        
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            
            if (!hash1.containsKey(w))
                hash1.put(w, p);
            if (!hash2.containsKey(p))
                hash2.put(p, w);
            if (hash1.get(w) != p || hash2.get(p) != w)
                return false;
        }
        
        return true;
    }
}
