class Solution {
    /*
        Process:
        1. Convert the string to a char array and have a left pointer and right pointer starting at index 0 and last index respectively
        2. Keep moving left pointer until it finds a letter or crosses right pointer
        3. Keep moving right pointer until it finds a letter or crosses left pointer
        4. Swap the characters at left pointer and right pointer
        
        Time Complexity: O(N)
        Space Complexity: O(N) if we count converting the string to char array
    
    */
    public String reverseOnlyLetters(String S) {
        int leftIndex = 0, rightIndex = S.length() - 1;
        char[] arr = S.toCharArray();
        
        while (leftIndex < rightIndex) {
            while(leftIndex < rightIndex && !Character.isLetter(arr[leftIndex])) {
                leftIndex++;
            }
            
            while(rightIndex > leftIndex && !Character.isLetter(arr[rightIndex])) {
                rightIndex--;
            }
            
            char temp = arr[leftIndex];
            arr[leftIndex] = arr[rightIndex];
            arr[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }
        
        return new String(arr);
    }
}
