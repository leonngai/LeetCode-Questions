ass Solution {
    public int minAddToMakeValid(String S) {
        int ans = 0;
        Stack<Character> stack = new Stack<>();
        
        if (S != null) {
    
            for(int i = 0; i < S.length(); i++) {
                Character c = S.charAt(i);
                if (c == '(')
                    stack.push(c);
                else if (stack.isEmpty()) {
                    ans++;
                }
                else {
                    stack.pop();
                }
                
            }
        }
            return ans + stack.size();
    }
    
    /*
    to be valid, for every opening parentheses we need to have a closing one.. we can use a stack to replicate this

    3 scenarios:
    1) valid parenthesis: stack size = 0 at the end ie: (())
    2) invalid parenthesis:
        a) too many opening parenthesis: (((), stack size != 0 adding to the end
        b) too many closing parenthesis: ())), stack size == 0 add to sum for each time stack is empty and we want an opening parenthesis
    
    
    */
}
