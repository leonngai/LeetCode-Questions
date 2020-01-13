class Solution {
    /*
        Process:
        1. Use recursive backtracking function to go through all possible combinations
        2. At each function call, check to see if both n = 0 and k = 0
            2a. If it is then add this list to our list of lists
            2b. If not continue
        3. Check to see if n <= 0 or k <= 0, if it is then we return and break out of this recursion function as we know it is an invalid one
        4. In our for loop inside recursion function go from 1 - 9 and take away 1 from k and the number 1-9 from n each call
        5. Backtrack by removing the number that we added in the temporary list from the previous step
    
    */
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, new ArrayList<>(), 1);
        return result;
    }
    
    public void backtrack(int k, int n, List<Integer> temp, int number) {
        if (n == 0 && k == 0)
            result.add(new ArrayList<>(temp));
        if (n <= 0 || k <= 0)
            return;
        
        for (int i = number; i <= 9; i++) {
            if (i > n)
                continue;
            temp.add(i);
            backtrack(k - 1, n - i, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
