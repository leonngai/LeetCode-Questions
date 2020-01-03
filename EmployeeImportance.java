/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    /*
        Things we need to do:
            1. Traverse through the list of employees and add each employee into a hashmap with the id as key and reference of employee as value
            2. While traversing the list if the employee id matches the id that we are looking for, add to the Queue
            3. Perform a breadth first search of the matched employee, adding each employees subordinates into the Queue until it return empty
        
        Time Complexity: O(N)
        Space Complexity: O(N)
    
    */
    public int getImportance(List<Employee> employees, int id) {
        int ans = 0;
        HashMap<Integer, Employee> hash = new HashMap<>();
        Queue<Employee> q = new LinkedList<>();
        
        for (Employee employee : employees) {
            hash.put(employee.id, employee);
            
            if (id == employee.id)
                q.add(employee);
        }
        
        while(!q.isEmpty()) {
            Employee temp = q.poll();
            ans += temp.importance;
            
            for (int subordinateID : temp.subordinates)
                q.add(hash.get(subordinateID));
        }
        
        return ans;
    }
}
