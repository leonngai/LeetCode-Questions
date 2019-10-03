c int solution(int[] A) {
        // write your code in Java SE 8
        
        //segregate the negative and 0 values to the left side
        int startingindex = 0;
        int ans = 0;
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= 0) {
                int temp = A[i];
                A[i] = A[startingindex];
                A[startingindex] = temp;
                startingindex++;
            }
        }
        
        int maxnumberallowed = A.length - startingindex;
        for (int i = startingindex; i < A.length; i++) {
            if (A[i] > maxnumberallowed) 
                continue;
                
            //A at the valued index would be set to negative
            A[A[i] + startingindex - 1] = Integer.MIN_VALUE;
        }
        
        
        for (int i = startingindex; i <= A.length; i++) {
            if (A[i] > 0) {
                ans = i;
                break;
            }
        }
        
        return ans;
    }
