class Solution {
    public int[] sortedSquares(int[] A) {
        int[] answer = new int[A.length];
        int start = 0, end = A.length - 1, index = end;
        
        while(start <= end) {
            int startAns = A[start] * A[start];
            int endAns = A[end] * A[end];
            
            if (startAns > endAns) {
                answer[index] = startAns;
                start++;;
            }
            else {
                answer[index] = endAns;
                end--;
            }
            
            index--;
        }
        
        return answer;
    }
}
