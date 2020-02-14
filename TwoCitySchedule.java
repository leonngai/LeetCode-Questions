class Solution {
    /*
        Take a greedy approach and try to maximize the difference between flight A and flight B
        We can then sort this to ensure that we have saved the most cost by prioritizing the difference
        Add up the first half flights for column 0 then second half flights for column 1
        
        Time Complexity: O(NLogN)
        Space Complexity: O(1)
    
    */
    public int twoCitySchedCost(int[][] costs) {
        int res = 0;
    
        //Sort from biggest difference to smallest difference
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                return (pair2[1] - pair2[0]) - (pair1[1] - pair1[0]);
            }
        });
        
        for (int i = 0; i < costs.length / 2; i++)
            res += costs[i][0];
        for (int i = costs.length / 2; i < costs.length; i++)
            res += costs[i][1];
        
        return res;
    }
}
