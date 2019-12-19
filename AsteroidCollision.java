class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int index = 0, size = asteroids.length;
        
        while(index < asteroids.length) {
            if (asteroids[index] > 0) {
                stack.push(index);
                index++;
            }
            else {
                if (!stack.empty()) {
                    int stackIndex = stack.peek();
                    if (asteroids[stackIndex] > Math.abs(asteroids[index])) {
                        asteroids[index] = 0;
                        size--;
                        index++;
                    }
                    else if (asteroids[stackIndex] < Math.abs(asteroids[index])) {
                        asteroids[stackIndex] = 0;
                        size--;
                        stack.pop();
                    }
                    else {
                        asteroids[stackIndex] = 0;
                        asteroids[index] = 0;
                        size -= 2;
                        stack.pop();
                        index++;
                    }
                }
                else {
                    index++;
                }
            }
        }
        
        int [] answer = new int[size];
        int answerIndex = 0;
        for(int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] != 0) {
                answer[answerIndex] = asteroids[i];
                answerIndex++;
            }
        }
        
        return answer;
    }
}
