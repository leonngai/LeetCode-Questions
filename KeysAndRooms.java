class Solution {
    Set<Integer> visited = new HashSet<>();
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        dfs(rooms, 0);
        return visited.size() == rooms.size();
    }
    
    public void dfs(List<List<Integer>> rooms, int room) {
        if (visited.contains(room))
            return;
        
        visited.add(room);
        
        for (int i = 0; i < rooms.get(room).size(); i++) {
            dfs(rooms, rooms.get(room).get(i));    
        }
    }

