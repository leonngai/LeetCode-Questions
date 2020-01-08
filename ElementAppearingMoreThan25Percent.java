class Solution {
    /*
        Process and things to remember:
            1. Find the total number of elements in array and divide by 4 to get 25% count
            2. Iterate through the array and keep count of how many times we see an element
                2a. Comparing with previous number if it is the same then we increment count
                2b. If it is not the same number as previous number, change our previous number and reset our count to 1
            3. As soon as a count of one element is greater than this number found in step 1, return this number
    
        Time Complexity: O(N)
        Space Complexity: O(1)
    */
    public int findSpecialInteger(int[] arr) {
        // Step 1
        int countNeeded = arr.length / 4;
        int count = 0;
        
        int previousNumber = arr[0];
        // Step 2
        for (int i = 0; i < arr.length; i++) {
            // Step 2a
            if (arr[i] == previousNumber) {
                count++;
                
                // Step 3
                if (count > countNeeded)
                    return arr[i];
            }
            // Step 2b
            else {
                count = 1;
                previousNumber = arr[i];
            }
                
        }
        
        return arr[0];
    }
}
