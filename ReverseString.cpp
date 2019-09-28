ass Solution {
public:
    void reverseString(vector<char>& s) {
        helper(s, 0, s.size() - 1);
    }
    
    void helper(vector<char>&s, int start, int end) {
        if (start < end) {
            char temp = s.at(start);
            s.at(start) = s.at(end);
            s.at(end) = temp;
        
            helper(s, start + 1, end - 1);
        }
    }
};
