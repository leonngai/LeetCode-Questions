class Solution {
    public boolean backspaceCompare(String S, String T) {
        int sPointer = S.length() - 1, tPointer = T.length() - 1;
        
        while(true) {
            int backspaceCount = 0;
            
            while(sPointer >= 0 && (S.charAt(sPointer) == '#' || backspaceCount > 0)) {
                if (S.charAt(sPointer) == '#') {
                    sPointer--;
                    backspaceCount++;
                }
                
                else if (backspaceCount > 0) {
                    sPointer--;
                    backspaceCount--;
                }   
            }
            
            backspaceCount = 0;
            while (tPointer >= 0 && (T.charAt(tPointer) == '#' || backspaceCount > 0)) {
                if (T.charAt(tPointer) == '#') {
                    tPointer--;
                    backspaceCount++;
                }
                
                else if (backspaceCount > 0) {
                    tPointer--;
                    backspaceCount--;
                }
            }
            
            if (tPointer >= 0 && sPointer >= 0 && S.charAt(sPointer) == T.charAt(tPointer)) {
                sPointer--;
                tPointer--;
            }
            else
                break;
        }
        
        return sPointer == -1 && tPointer == -1;
    }
}
