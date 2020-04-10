class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();
        
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '#')
                s.push(S.charAt(i));
            else if (!s.isEmpty())
                s.pop();
        }
        
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) != '#') 
                t.push(T.charAt(i));
            else if (!t.isEmpty())
                t.pop();
        }
        
        if (s.size() != t.size())
            return false;
        
        while(!s.isEmpty()) {
            if (s.pop() != t.pop())
                return false;
        }
        
        return true;
    }
}
