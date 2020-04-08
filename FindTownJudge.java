class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] inDegree = new int[N + 1], outDegree = new int[N + 1];
        
        //build the in degree and out degree graph
        for (int[] arr : trust) {
            inDegree[arr[1]]++;
            outDegree[arr[0]]++;
        }
        
        for (int i = 1; i < N + 1; i++) {
            if (inDegree[i] == N - 1 && outDegree[i] == 0)
                return i;
        }
        
        return -1;
    }
}
