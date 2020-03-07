class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        
        for (int n: arr) {
            hash.put(n, hash.getOrDefault(n, 0) + 1);
        }
        
        Set<Integer> freq = new HashSet<>();
        
        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
		    if (freq.contains(entry.getValue()))
                return false;
            
            freq.add(entry.getValue());
		}
                
        return true;
    }
}
