class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            String sortedWord = new String(sArray);
            
            if (!map.containsKey(sortedWord)) {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                res.add(newList);
                map.put(sortedWord, newList);
            }
            
            else {
                map.get(sortedWord).add(s);    
            }
        }
        
        return res;
    }
}
