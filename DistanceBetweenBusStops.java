class Solution {
    /*
        Initial thoughts
        - We check the sum from start to destination going from left to right then check the sum from right to left
        - return the minimum of these two sums
        
        Process:
            1. Iterate from left to right starting from start index until we hit destination index while keeping track of sum
                1a. If we reach destination.length, then wrap around starting at index 0 until we hit destination
            2. Iterate from right to left starting from start index until we wrap around to the destination index
                2a. begin at start index until we reach destination
                2b. If we reach index 0, then we go to distance.length  and wrap around to destination index
            3. Return minimum of the two sums
            
        Time Complexity: O(N)
        Space Complexity: O(1)
    
    */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination)
            return 0;
        
        int leftToRight = 0, rightToLeft = 0;
        int leftPointer = start, rightPointer = start - 1;
        
        while(leftPointer < distance.length && leftPointer!= destination) {
            leftToRight += distance[leftPointer];
            leftPointer++;
        }
        
        //This means that we have reached the end of the array but have not hit our destination yet, need to wrap around
        if (leftPointer != destination) {
            leftPointer = 0;
            while(leftPointer != destination) {
                leftToRight += distance[leftPointer];
                leftPointer++;
            }
        }
        
        while(rightPointer >= 0 && rightPointer != destination - 1) {
            rightToLeft += distance[rightPointer];
            rightPointer--;
        }
        
        //This means that we have reached the beginning of the array and still have not hit our destination yet, need to wrap around to the end
        if (rightPointer != destination - 1) {
            rightPointer = distance.length - 1;
            while(rightPointer != destination - 1) {
                rightToLeft += distance[rightPointer];
                rightPointer--;
            }
        }
        
        return Math.min(leftToRight, rightToLeft);
    }
}
