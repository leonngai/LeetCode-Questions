class Solution:
    def minAddToMakeValid(self, S: str) -> int:
        openUnmatched = 0
        closedUnmatched = 0
        
        for char in S:
            if char == '(':
                openUnmatched += 1
            elif char == ')' and openUnmatched > 0:
                openUnmatched -= 1
            elif char == ')' and openUnmatched == 0:
                closedUnmatched += 1
                
        return openUnmatched + closedUnmatched

        
