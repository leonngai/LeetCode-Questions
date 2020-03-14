class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> ans = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        
        for (int n : nums1)
            set.add(n);
        
        for (int n : nums2) {
            if (set.contains(n))
                ans.add(n);
        }
        
        int[] res = new int[ans.size()];
        int index = 0;
        
        for (int n : ans) {
            res[index] = n;
            index++;
        }
        
        return res;
    }
}
