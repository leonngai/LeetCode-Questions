class Solution {
    // Time Complexity: O(NLogN)
    // Space Complexity: O(N)
    public int heightChecker(int[] heights) {
        //Create a clone of the given heights and sort the array
        int[] clone = heights.clone();
        Arrays.sort(clone);
        
        //Compare how many elements are out of place in the sorted array compared to the given array
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (clone[i] != heights[i])
                count++;
        }
        
        return count;
    }
}
