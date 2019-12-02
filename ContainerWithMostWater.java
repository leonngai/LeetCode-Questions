class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int begin = 0, end = height.length - 1;
        
        while(begin < end) {
            ans = Math.max(ans, (end - begin) * Math.min(height[begin], height[end]));
            
            if(height[begin] > height[end])
                end--;
            else
                begin++;
        }
        
        return ans;
    }
}
