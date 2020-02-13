class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //build graph via adjacency list
        List<Integer>[] graph = new List[numCourses];
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] prereqs : prerequisites) {
            graph[prereqs[1]].add(prereqs[0]);
            inDegree[prereqs[0]]++;
        }
        
        //add courses that have no prereqs into the queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }
        
        
        int coursesTaken = 0;
        while(!q.isEmpty()) {
            for (int course: graph[q.poll()]) {
                if (--inDegree[course] == 0)
                    q.add(course);
            }
            
            coursesTaken++;
        }
        
        return coursesTaken == numCourses;
    }
}
