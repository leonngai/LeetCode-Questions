class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0, tenCount = 0;
        
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5)
                fiveCount++;
            else if (bills[i] == 10 && fiveCount > 0) {
                    fiveCount--;
                    tenCount++;
            }
            else if (bills[i] == 20 && fiveCount > 0 && tenCount > 0) {
                    fiveCount--;
                    tenCount--;
            }
            else if (bills[i] == 20 && fiveCount >= 3) {
                fiveCount -= 3;
            }
            else
                return false;
        }
        
        return true;
    }
}
