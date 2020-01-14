class Solution {
    /*
        Process:
        1. First do a deep copy of the input array and sort it
        2. Iterate through both the clone and the input array one element at a time to see where the mismatches lie
        3. Our first mismatch, we set the start index to this and end index to this
        4. Every mismatch after already finding the start we update the end
        5. At the end return 0 if the start index was never changed from -1 or return end - start + 1
    
        Time Complexity: O(NLogN) to sort the array and O(N) to go through the arrays for start and end index
        Space Complexity: O(N) 
    */
    public int findUnsortedSubarray(int[] nums) {
        //Copy 
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        
        //Find start and end
        int start = -1, end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (sorted[i] != nums[i]) {
                if (start == -1) 
                    start = i;
                
                end = i;
            }
        }
        
        return start == -1 ? 0 : end - start + 1;
    }
}
