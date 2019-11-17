class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
        //instantiate new max-heap that keeps the smallest K elements 
        PriorityQueue<int[]> heap = new PriorityQueue<>((b,a) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
        int[][] answer = new int[K][2];
        
        //Time complexity of NLog(K) because we always sort K + 1 elements each time we add an entry into our heap
        for (int[] entry: points) {
            heap.add(entry);
            //at most, the size of our heap that we want to keep is K elements, so we kick out the highest entry each time we exceed K element size
            if (heap.size() > K) 
                heap.poll();
        }
        
        while(K > 0)
            answer[--K] = heap.poll();
        
        return answer;
    }
}
