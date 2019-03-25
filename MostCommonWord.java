class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().replaceAll("[,;''!.?]", " ").split("\\s+");
        
        HashSet<String> bannedHash = new HashSet<String>();
        for (int i = 0; i < banned.length; i++) {
            bannedHash.add(banned[i]);
        }
    
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            if (!bannedHash.contains(words[i])) {
                hash.put(words[i],hash.getOrDefault(words[i], 0) + 1);
            }
        }
        
        int maxValueInMap = (Collections.max(hash.values()));
        
         for (Map.Entry<String, Integer> entry : hash.entrySet()) {  // Itrate through hashmap
            if (entry.getValue()==maxValueInMap) {
                return entry.getKey();     // Print the key with max value
            }
        }
    
        return "";
    }
}
