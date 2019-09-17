ass Solution {
    public int minAddToMakeValid(String S) {
        
        int openUnmatched = 0;
        int closedUnmatched = 0;
        
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') 
                openUnmatched++;
            else if (S.charAt(i) == ')' && openUnmatched > 0)
                openUnmatched--;
            else if (S.charAt(i) == ')' && openUnmatched == 0)
                closedUnmatched++;
        }
        
        return openUnmatched + closedUnmatched;
    }
    
    /*
        
        To improve on the previous solution, make it more efficient by getting rid of the stack.
        We can check if it is valid and keep track of the number of both open and closed parenthesis that are unmatched instead of having to push and pop onto the stack everytime.
    
    */
}
