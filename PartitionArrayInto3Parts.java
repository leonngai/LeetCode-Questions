class Solution {
    /*
        - Initial thoughts: to be able to partition the parts into equal sum, first need to find the total sum
        then if that number can be divided by 3, we know that each partition should equal this number
        if this total sum can not be divided by 3, then we know that it will return false no matter what
        - Next we can iterate through our array again, keeping a temp sum starting at 0.
        - As soon as we have our temp sum equal to total sum / 3, we have found our first parititon and we can reset temp sum to 0 and try to find the other 2 partitions in a similar manner
        
        Process:
        1. Iterate through array and find total sum
        2. Check if total sum can be divided by 3
            2a. If not return false
            2b. else continue
        3. Iterate through array with a temp sum
            3a. If temp sum equal to total sum divided by 3, increment number of partitions by 1 and reset temp sum to 0
        4. Return answer
            4a. True if number of partitions is 3
            4b. False if not
            
        Time Complexity: O(N)
        Space Complexity: O(1)
    */
    public boolean canThreePartsEqualSum(int[] A) {
        //Step 1
        int totalSum = 0;
        
        for (int num: A)
            totalSum += num;
        
        //Step 2
        if (totalSum % 3 != 0)
            return false;
        
        int partitionSize = totalSum / 3;
        
        //Step 3
        int tempSum = 0, numberOfPartitions = 0;
        for (int num: A) {
            tempSum += num;
            if (tempSum == partitionSize) {
                numberOfPartitions++;
                tempSum = 0;
            }
        }
        
        //Step 4
        return numberOfPartitions == 3 ? true : false;
    }
}
