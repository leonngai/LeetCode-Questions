class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<Integer>();
        
        preorder(answer, root);
        
        return answer;
    }
    
    public void preorder(List<Integer> answer, TreeNode root) {
        if (root!= null) {
            answer.add(root.val);
            preorder(answer, root.left);
            preorder(answer,root.right);
        }
    }
    
    
}
