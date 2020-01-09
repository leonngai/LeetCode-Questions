class Solution {
    /*
        Process:
            1. Iterate through each array
                1a. Calculate the sum of each
                1b. Put each value into a hashset for B
            2. Add both sums together and divide by 2 to get the sum needed for each
            3. Iterate through one array and it becomes a two sum problem where we find the needed number through the hashset in optimum time
            4. Return answer
            
            ie:
                A = [1,1] -> asum = 2
                B = [2,2] -> bsum = 4

                The sum of both need to equal each other ie: Sum needed would be (4 + 2) / 2 = 3

                At first element of A[0], we have 1. So lets pretend to take this away by doing sum - A[0] = 2 - 1 = 1; Then find the number needed to replace this with to equal the sum needed -> sum needed - 1 = 2;
                If this number needed is in the hashset of B, then return A[0] and the needed value
        
        Time Complexity: O(A + B) - Have to go through each array once to get sum, then once more to find the right numbers
        Space Complexity: O(B) - Hashset of size B.length
    */
    public int[] fairCandySwap(int[] A, int[] B) {
        //Step 1
        int Asum = 0, Bsum = 0;
        int[] answer = new int[2];
        HashSet<Integer> hashB = new HashSet<>();
        
        //Step 1a
        for (int i = 0; i < A.length;i++) {
            Asum += A[i];
        }
        
        //Step 1a
        for (int i = 0; i < B.length; i++) {
            Bsum += B[i];
            //Step 1b
            hashB.add(B[i]);
        }
        
        //Step 2
        int sumNeeded = (Asum + Bsum) / 2;
        
        //Step 3
        for (int i = 0; i < A.length; i++) {
            if (hashB.contains(sumNeeded - (Asum - A[i]))) {
                answer[0] = A[i];
                answer[1] = sumNeeded - (Asum - A[i]);
                break;
            }
        }
        
        //Step 4
        return answer;
    }
}
