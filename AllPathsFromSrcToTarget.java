class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        helper(graph, 0, answer, path);
        return answer;
    }
    
     public void helper(int[][] graph, int node, List<List<Integer>> answer, List<Integer> path) {
        if (node == graph.length - 1) {
            answer.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (int n: graph[node]) {
            path.add(n);
            helper(graph, n, answer, path);
            path.remove(path.size() - 1);
        }
    }
}
