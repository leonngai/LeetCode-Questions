class Solution {
public:
    
    int minAddToMakeValid(string S) {
        int openUnmatched = 0, closedUnmatched = 0;
        
        for (char c : S) {
            if (c == '(') 
                openUnmatched++;
            else if (openUnmatched > 0)
                openUnmatched--;
            else if (openUnmatched == 0)
                closedUnmatched++;
        }
        
        return openUnmatched + closedUnmatched;
    }
    
};
