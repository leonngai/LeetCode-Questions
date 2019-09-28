ass Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> oldlist;
        
        for (int row = 0; row <= rowIndex; row++) {
            vector<int> newlist;
            for (int col = 0; col <= row; col++) {
                if (row == col || col == 0) {
                    newlist.push_back(1);
                }
                else {
                    newlist.push_back(oldlist.at(col - 1) + oldlist.at(col));
                }
            }
            oldlist = newlist;
        }
        
        return oldlist;
    }
};
