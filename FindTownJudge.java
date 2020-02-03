class Solution {
    public int findJudge(int N, int[][] pairs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < pairs.length; i++) {
            if (map.containsKey(pairs[i][0])) {
                map.get(pairs[i][0]).add(pairs[i][1]);
            }
            else {
                Set<Integer> list = new HashSet<>();
                list.add(pairs[i][1]);
                map.put(pairs[i][0], list);
            }
        }
        
        int key = -1;
        
        for (int i = 1; i <= N; i++) {
            if (!map.containsKey(i)) {
                key = i;
                break;
            }
        }
        
        if (key == -1)
            return -1;
        
        for (int i = 1; i <= N; i++) {
            if (i == key)
                continue;
            
            if (!map.containsKey(i) || !map.get(i).contains(key))
                return -1;
        }
        
        return key;
    }
}
