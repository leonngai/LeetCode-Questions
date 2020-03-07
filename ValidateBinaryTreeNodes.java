class Solution {
    /*
        Process:
            Keep track of how many nodes are pointed at from another node
            The number of each should be 1 with the exception of the the parent which should have no nodes pointing to it
            
            Time Complexity: O(N)
            Space Complexity: O(N)
    */
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] count = new int[n];
        HashSet<Integer> visited = new HashSet<>();
        
        for (int index = 0; index < n; index++) {
            if (leftChild[index] != -1) {
                if (!visited.contains(leftChild[index]) && count[leftChild[index]] == 0)
                    count[leftChild[index]]++;
                else
                    return false;
            }
            
            if (rightChild[index] != -1) {
                if (!visited.contains(leftChild[index]) && count[rightChild[index]] == 0)
                    count[rightChild[index]]++;
                else
                    return false;
            }
            
            if (leftChild[index] != -1 || rightChild[index] != -1)
                visited.add(index);
        }
        
        int parentCount = 0;
        for (int index = 0; index < n; index++) {
            if (count[index] != 1) {
                if (parentCount == 0)
                    parentCount++;
                else
                    return false;
            }
        }
        
        return parentCount == 1;
    }
}



