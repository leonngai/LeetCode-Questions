class Solution {
    public int longestMountain(int[] A) {
        int ans = 0, index = 0, len = A.length;
        
        while (index < len) {
            int end = index;
            //check to make sure we dont go over length and that we have found the beginning of a potential mountain
            if (end < len - 1 && A[end] < A[end + 1]) {
                while (end < len - 1 && A[end] < A[end + 1])
                    end++;
                
                //check to see if this is a peak
                if (end < len - 1 && A[end] > A[end + 1]) {
                    while(end < len - 1 && A[end] > A[end + 1])
                        end++;
                    
                    ans = Math.max(ans, end - index + 1);
                }
            }
            
            index = Math.max(index + 1, end);
        }
        
        return ans;
    }
}



