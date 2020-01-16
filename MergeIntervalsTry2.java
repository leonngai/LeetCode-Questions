class Solution {
    /*
        Process:
        1. Idea is to first sort the intervals by first number
        2. Next we can iterate through the sorted intervals and see which intervals overlap with each other
        3. Compare the previous iterations second number with next iterations first number
            3a. If previous iteration[1] >= next iteration[0] then change previous iteration[1] to max of previous iteration[1] and . next iteration [1]
            3b. If previous iteration[1] < next iteration[0] then that means we have found the max number of rooms that overlap and we set this new room to be the previous iteration
        4. Return the result
    
    */
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;
        
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
       
        int[] prevInterval = intervals[0];
        list.add(prevInterval);
        
        for (int[] interval: intervals) {
            if (prevInterval[1] >= interval[0]) {
                prevInterval[1] = Math.max(prevInterval[1], interval[1]);
            }
            else {
                prevInterval = interval;
                list.add(prevInterval);
            }
        }
        
        return list.toArray(new int[list.size()][]);
    }
}
