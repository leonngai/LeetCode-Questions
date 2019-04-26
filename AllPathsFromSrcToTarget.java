class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        helper(graph, 0, answer, path);
        return answer;
    }
}
