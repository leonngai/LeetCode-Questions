class Solution {
    public boolean checkValidString(String s) {
        int balance = 0;
        
        //Check validility going from left -> right
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*' || s.charAt(i) == '(')
                balance++;
            else {
                balance--;
                
                if (balance < 0)
                    return false;
            }
        }
        
        if (balance == 0)
            return true;
        
        balance = 0;
        
        //Check validility going from right -> left
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '*' || s.charAt(i) == ')')
                balance++;
            else {
                balance--;
                
                if (balance < 0)
                    return false;
            }
        }
        
        return true;
    }
}
