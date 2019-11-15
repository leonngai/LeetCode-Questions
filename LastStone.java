class Solution {
    public int lastStoneWeight(int[] stones) {
        HashSet<Integer> visited = new HashSet<>();
        int secondBiggest = 0, biggest = 0;
        
        while(stones.length - visited.size() > 2) {
            secondBiggest = Integer.MIN_VALUE;
            biggest = Integer.MIN_VALUE + 1;
            int secondBiggestIndex = -1, biggestIndex = -1;
            
            for (int i = 0; i < stones.length; i++) {
                if (!visited.contains(i)) {
                    if(stones[i] > biggest) {
                        secondBiggest = biggest;
                        biggest = stones[i];
                        
                        secondBiggestIndex = biggestIndex;
                        biggestIndex = i;
                    }
                    else if (stones[i] > secondBiggest) {
                        secondBiggest = stones[i];
                        secondBiggestIndex = i;
                    }
                }
            }
            
            if (biggest == secondBiggest) {
                visited.add(biggestIndex);
                visited.add(secondBiggestIndex);
            }
            else {
                stones[secondBiggestIndex] = biggest - secondBiggest;
                visited.add(biggestIndex);
            }
            
        }
        
        if (stones.length - visited.size() == 1) {
        	for (int i = 0; i < stones.length; i++) {
        		if (!visited.contains(i))
        			return stones[i];
        	}
        }
        
        secondBiggest = Integer.MIN_VALUE;
        biggest = Integer.MIN_VALUE + 1;
        
        for (int i = 0; i < stones.length; i++) {
            if (!visited.contains(i)) {

                if (stones[i] > biggest) {
                    secondBiggest = biggest;
                    biggest = stones[i];
                }
                else if (stones[i] > secondBiggest) {
                    secondBiggest = stones[i];
                }
            }
        }
        
        return biggest - secondBiggest;
    }
}
