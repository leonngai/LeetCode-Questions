class Solution {
    public int countCharacters(String[] words, String chars) {
        int ans = 0;
        int[] charCount = new int[26];
        
        for (int i = 0; i < chars.length(); i++) 
            charCount[chars.charAt(i) - 'a']++;
        
        int[] temp;
        
        for (int i = 0; i < words.length; i++) {
            temp = charCount.clone();
            int j = 0;
            while(j < words[i].length()) {
                if (temp[words[i].charAt(j) - 'a']-- <= 0)
                    break;
                j++;
            }
            
            if (j == words[i].length())
                ans+= j;
        }
        
        return ans;
    }
}
