class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public int answer = 0;
    public int maxDepth(Node root) {
        if (root == null)
            return answer;
        
        helper(root, 1);
        return answer;
    }
    
    public void helper(Node currentNode, int currentHeight) {
        if(currentNode.children.size() == 0) {
            answer = Math.max(answer, currentHeight);
            return;
        }
        
        for (int i = 0; i < currentNode.children.size(); i++) {
            helper(currentNode.children.get(i), currentHeight + 1);
        }
            
        
    }
}
