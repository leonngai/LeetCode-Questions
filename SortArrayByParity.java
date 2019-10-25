class Solution {
    public int[] sortArrayByParity(int[] A) {
        int start = 0, end = A.length - 1;
        
        while (start < end) {
            //if both in wrong place
            if (A[start] % 2 != 0 && A[end] % 2 == 0) {
                swap(A, start, end);
            }
            //start in wrong place, but end in right place
            else if (A[start] % 2 != 0) {
                //end needs to go down until it hits an even number to swap with
                while(A[end] % 2 != 0 && start < end) {
                    end--;
                }
                swap(A, start, end);
            }
            //end in wrong place, but start in right place
            else if (A[end] % 2 == 0) {
                while(A[start] % 2 == 0 && start < end) {
                    start++;
                }
                swap(A, start, end);
            }
            
            start++;
            end--;
            
        }
        return A;
    }
    
    public void swap(int[] A, int start, int end) {
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
    }
}
