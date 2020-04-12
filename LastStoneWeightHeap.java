class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(stones.length, (a, b) -> (b - a));
        
        for (int n : stones) 
            heap.offer(n);
        
        while(heap.size() > 1) {
            int biggest = heap.poll();
            int secondBiggest = heap.poll();
            
            if (biggest != secondBiggest)
                heap.offer(biggest - secondBiggest);
        }
        
        return heap.size() == 1 ? heap.poll() : 0;
    }
}
