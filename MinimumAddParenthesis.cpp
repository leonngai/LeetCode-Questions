class Solution {
public:
    int openUnmatched = 0;
    int closedUnmatched = 0;
    
    int minAddToMakeValid(string S) {
        for (int i = 0; i < S.length(); i++) {
            if (S.at(i) == '(') 
                openUnmatched++;
            else if (S.at(i) == ')' && openUnmatched > 0)
                openUnmatched--;
            else if (S.at(i) == ')' && openUnmatched == 0)
                closedUnmatched++;
        }
        
        return openUnmatched + closedUnmatched;
    }
};
