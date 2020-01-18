class Solution {
    /*
        Process:
        1. Sort the 2d array based on the second entry in every pair
        2. Keep track of min variable and keep comparing with entries
        3. As soon as we find a pair, we update our min to this
        
        Time Complexity: O(NLogN)
        Space Complexity: O(1)
    */
    public int findLongestChain(int[][] pairs) {
        if (pairs.length <= 1)
            return pairs.length;
        
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int ans = 1, min = pairs[0][1];
        
        for (int i = 1; i < pairs.length; i++) {
            if (min < pairs[i][0]) {
                ans++;
                min = pairs[i][1];
            }
        }
        return ans;
    }
}
