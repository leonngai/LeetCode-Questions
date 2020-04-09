class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        int[] res = new int[N];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
    
        for (int i = 0; i < N; i++)
            graph.put(i, new HashSet<>());
        
        for (int[] path : paths) {
            graph.get(path[0] - 1).add(path[1] - 1);
            graph.get(path[1] - 1).add(path[0] - 1);
        }
        
        for (int i = 0; i < N; i++) {
            boolean[] typeUsed = new boolean[5];
            
            for (int j : graph.get(i))
                typeUsed[res[j]] = true;
            
            for (int c = 1; c <= 4; c++) {
                if (!typeUsed[c]) {
                    res[i] = c;
                    break;
                }
            }
        }
        return res;
    }
}
