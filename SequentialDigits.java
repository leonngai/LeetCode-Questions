class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 1; i < 10; i++) {
            int num = 0;
            for (int j = i; j < 10; j++) {
                num = num * 10 + j;
                
                if (num >= low && num <= high)
                    answer.add(num);
                else if (num > high)
                    break;
            }
        }
        
        Collections.sort(answer);
        return answer;
    }
}
