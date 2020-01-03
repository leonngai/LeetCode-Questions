class Solution {
    /*
        1. Iterate through arr2 putting each number into the hashmap as a key
        2. Iterate through arr1 counting the number of instances we see of each number
            2a. If the number we see is a key, that means it was part of arr2 and we can increment the count
            2b. If the number we see is not a key, that means it is not a part of arr2 and we place the number at the end of our result array
        3. Replace the values in arr1 based on the count that we saw from the hashmap with the order from arr2
        4. Sort the numbers in the resultant array that are not part of arr2
        
        Time Complexity: O(NLogN)
        Space Complexity: O(N)
    */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int arr1Index = 0;
        int endPointer = arr1.length - 1;
        int[] result = new int[arr1.length];
        
        HashMap<Integer, Integer> hash = new HashMap<>();
        
        for (int num: arr2)
            hash.put(num, 0);
        
        for (int num: arr1) {
            if (hash.containsKey(num))
                hash.put(num, hash.get(num) + 1);
            else {
                result[endPointer] = num;
                endPointer--;
            }
        }
                
        for (int num: arr2) {
            int count = hash.get(num);
            
            while(count > 0) {
                result[arr1Index] = num;
                arr1Index++;
                count--;
            }
        }
        
        Arrays.sort(result, arr1Index, arr1.length);
        return result;
    }
}
