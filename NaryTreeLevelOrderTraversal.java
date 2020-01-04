/* class Node {
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
    public List<List<Integer>> levelOrder(Node root) {    
        List<List<Integer>> list = new ArrayList<>();
        
        if (root == null)
            return list;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        //Perform BFS of each treenode, adding its children to the queue
        //After each level, add the temporary list to the result
        while(!q.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                Node temp = q.poll();
                
                for (Node child: temp.children)
                    q.add(child);
                
                tempList.add(temp.val);
            }
            
            list.add(new ArrayList<>(tempList));
        }
            
        return list;
    }
}
