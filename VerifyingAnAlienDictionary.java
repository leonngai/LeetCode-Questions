class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        
        for (int i = 0; i < 26; i++)
            index[order.charAt(i) - 'a'] = i;
    
        for (int i = 0; i < words.length - 1; i++) {
            boolean ans = helper(words[i], words[i + 1], index);
            
            if (!ans)
                return false;
        }
        
        return true;
    }
    
    public boolean helper(String word1, String word2, int[] index) {
        int pointer = 0;
    
        while(pointer < word1.length() && pointer < word2.length()) {
            if (index[word2.charAt(pointer) - 'a'] < index[word1.charAt(pointer) - 'a'])
                return false;
            else if (index[word2.charAt(pointer) - 'a'] > index[word1.charAt(pointer) - 'a'])
                return true;
            else
                pointer++;
        }
        
        return false;
    }
}
