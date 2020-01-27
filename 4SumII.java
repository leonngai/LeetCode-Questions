class Solution {
            public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
      
        for (int i = 0; i < C.length; i++) {
          for (int j = 0; j < D.length; j++) {
            map.put(C[i] + D[j], map.getOrDefault(C[i] + D[j], 0) + 1);
          }
        }
      
        for (int i = 0; i < A.length; i++) {
          for (int j = 0; j < B.length; j++) {
            int sum = A[i] + B[j]; 
            
            if (map.containsKey(-sum))
              ans += map.get(-sum);
          }
        }
          
          
        return ans;
    }
}
