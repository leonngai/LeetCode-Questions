class Solution {
    public int countElements(int[] arr) {
        Arrays.sort(arr);
        
        int count = 0;
        Map<Integer, Integer> dict = new HashMap<>();
        
        for (int n : arr) {
            if (dict.containsKey(n - 1)) {
                count += dict.get(n - 1);
                dict.remove(n - 1);
            }
            
            dict.put(n, dict.getOrDefault(n, 0) + 1);
        }
        
        return count;
    }
}
