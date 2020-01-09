class Solution {
    /*
        Given:
        - Array is at least size of 1 up to 50000 inclusive
        Find:
        - If it is monotone increasing/decreasing
            - Monotone means that it the elements are basically sorted in ascending or descending order
    
        Process:
        1. Find out if the array should be monotone increasing/decreasing based on the first 2 numbers
            1a. Monotone increasing if the second number is greater than the first number
            1b. Monotone decreasing if the second number is smaller than the first number
            1c. If the numbers are equal keep going until we find which one it is
        2. At each given index, we only have to keep track of the previous number and compare the current number to this
        3. Return false if at any given point we find that the array is not sorted properly
        4. Return true once all elements in the array have been checked
        
        Time Complexity: O(N)
        Space Complexity: O(1)
    */
    public boolean isMonotonic(int[] A) {
        if (A.length == 1)
            return true;
        
        int prevIndex = 0, currentIndex = 1;
        //Step 1 - Check if monotonic ascending or descending
        while(currentIndex < A.length && A[prevIndex] == A[currentIndex]) {
            prevIndex++;
            currentIndex++;
        }
        
        if (currentIndex == A.length)
            return true;
        
        boolean monotoneAscending = A[prevIndex] < A[currentIndex] ? true : false;
        
        // Step 2
        while(currentIndex < A.length) {
            //check that it is ascending
            if(monotoneAscending) {
                //Step 3
                if (A[prevIndex] > A[currentIndex])
                    return false;
            }
            //check that it is descending
            else {
                //Step 3
                if (A[currentIndex] > A[prevIndex])
                    return false;
            }
            
            currentIndex++;
            prevIndex++;
        }
        
        return true;
    }
}
