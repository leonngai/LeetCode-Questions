class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int onePointer = 0, twoPointer = 0;
        int oneLength = nums1.length, twoLength = nums2.length;
        
        List<Integer> list = new ArrayList<>();
        
        while(onePointer < oneLength && twoPointer < twoLength) {
            //if number in array 1 is greater than number in array 2
            if (nums1[onePointer] > nums2[twoPointer]) 
                twoPointer++;
            //if number in array 2 is greater than number in array 1
            else if (nums2[twoPointer] > nums1[onePointer])
                onePointer++;
            //if they are both the same
            else {
                list.add(nums1[onePointer]);
                onePointer++;
                twoPointer++;
            }
        }
        
        int[] ans = new int[list.size()];
        int size = ans.length;
        for (int i = 0; i < size; i++) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}
