class Solution {
    public int endPointer;
    
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) 
            return s;
        
        int initialPointer = 0, ansLength = 0;
        int constEndPointer = s.length() - 1;
        String ans = "";
        
        for (int i = 0; i < constEndPointer; i++) {
            int endPointer = constEndPointer;
            int remaining = constEndPointer - i;
            if (ansLength > remaining) {
                break;
            }
            
            char initial = s.charAt(i);
            while(i < endPointer) {
                if (initial == s.charAt(endPointer)) {
                    int length = endPointer - i + 1;
                    
                    if (ansLength < length && isPalindrome(s, i, endPointer)) {
                        ansLength = length;
                        ans = s.substring(i, endPointer + 1);
                        break;
                    }
                }
                endPointer--;
            } 
        }
        
        if (ansLength == 0) {
            return s.substring(0, 1);
        }
        
        return ans;
    }
    
    public boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}
