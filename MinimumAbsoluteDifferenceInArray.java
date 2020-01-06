class Solution {
    /*
        Things to do:
        1. Sort the array so that adjacent numbers are as close as possible to each other
        2. Go through the array and compare adjacent numbers
            2a. If the difference is equal to our minimum number, add the two numbers to our result
            2b. If the difference is smaller than our mninimum number, delete the old result and create new list in place with these two numbers
            
        Time Complexity: O(NLogN) to sort
        Space Complexity: O(1) if we are not including the output
    */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int minNumber = Integer.MAX_VALUE;
        
        Arrays.sort(arr);
        
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] < minNumber) {
                result = new ArrayList<>();
                List<Integer> temp = new ArrayList<>();
                
                temp.add(arr[i]);
                temp.add(arr[i + 1]);
                result.add(temp);
                
                minNumber = arr[i + 1] - arr[i];
            }
            else if (arr[i + 1] - arr[i] == minNumber) {
                List<Integer> temp = new ArrayList<>();
                
                temp.add(arr[i]);
                temp.add(arr[i + 1]);
                result.add(temp);
            }
        }
        
        return result;
    }
}
