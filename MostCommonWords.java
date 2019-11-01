class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>();
        for (String s: banned) {
            bannedWords.add(s);
        }
        
        char[] array = paragraph.toCharArray();
        StringBuilder sb = new StringBuilder();
        String ans = "";
        
        HashMap<String, Integer> hash = new HashMap<>();
        int max = 0;
        
        for (char c: array) {
            //if letter, add to string builder
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            }
            //else if not a letter and stringbuilder is not blank
            else if (sb.length() > 0) {
                String result = sb.toString();
                //if a valid word and not part of banned list
                if (!bannedWords.contains(result)) {
                    int freq = hash.getOrDefault(result, 0) + 1;
                    hash.put(result, freq);
                    
                    if (freq > max) {
                        max = freq;
                        ans = result;
                    }
                }
                
                sb = new StringBuilder();
            }
        }
        
        //need to account for if a word was the final element in the array and there is no space or punctuation after it
        if (sb.length() > 0) {
            String result = sb.toString();
                //if a valid word and not part of banned list
                if (!bannedWords.contains(result)) {
                    int freq = hash.getOrDefault(result, 0) + 1;
                    if (freq > max) {
                        ans = result;
                    }
                }
        }
        
        return ans;
    }
}
