class Solution {
    /*
        1. Add initial index to the Q
        2. While Q is not empty, add the next possible indexes to check in our Q
            - Do not add indexes less than 0 or greater than arr.length
            - Do not add indexes with negative values because that means they have already been visited
        3. Return true if we have found the value 0 or return false if the Q is empty (if empty, we know that we have searched through every possible step in the array)
    
        Time Complexity: O(N)
        Space Complexity: O(N)
    */
    public boolean canReach(int[] arr, int start) {
        //Step 1
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        //Step 2
        while(!queue.isEmpty()) {
            int index = queue.poll();
            
            if (arr[index] == 0)
                return true;
            if (arr[index] == -1)
                continue;
            
            if (index + arr[index] >= 0 && index + arr[index] < arr.length)
                queue.add(index + arr[index]);
            if (index - arr[index] >= 0 && index - arr[index] < arr.length)
                queue.add(index - arr[index]);
            
            arr[index] = -1;
        }
        
        //Step 3
        return false;
    }
}
