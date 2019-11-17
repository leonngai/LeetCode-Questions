class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] answer = new int[queries.length];
        int sum  = 0;
        for (int number: A) {
            if (number % 2 == 0)
                sum += number;
        }
        
        for(int i = 0; i < queries.length; i++) {
            int current = A[queries[i][1]];
            A[queries[i][1]] += queries[i][0];
            //current even, sum even
            if (A[queries[i][1]] % 2 == 0 && current % 2 == 0) {
                sum += A[queries[i][1]] - current;
            }
            //current odd, sum even
            else if (A[queries[i][1]] % 2 == 0 && current % 2 != 0) {
                sum += A[queries[i][1]];
            }
            //current even, sum uneven
            else if (A[queries[i][1]] % 2 != 0 && current % 2 == 0) {
                sum -= current;
            }
            //current odd, sum odd; skip and do nothing as there is no affect on results
            answer[i] = sum;
        }
        
        return answer;
    }
}
