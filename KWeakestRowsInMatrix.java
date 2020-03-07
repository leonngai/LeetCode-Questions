class Solution {
    /*
        We basically want the K smallest rows so a heap would be an excellent choice here so that we only have to sort at most k entries
        
        Process:
        1. Create a max heap that prioritizes the count in each row first and then row itself 
        2. Iterate through the matrix and count soldiers in each row before placing the result into our heap
        3. Poll the heap when our heap size becomes greater than k
        4. Keep polling the heap until we have all the rows of our heap put into our resultant answer array
        
        Time Complexity: O(NLogK)
        Space Complexity: O(K)
    */
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] weakestRows = new int[k];
        
        PriorityQueue<Pair> heap = new PriorityQueue<>(k + 1, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.count == p2.count)
                    return Integer.compare(p2.row, p1.row);
                else
                    return Integer.compare(p2.count, p1.count);
            }
        });
        
        for (int row = 0; row < mat.length; row++) {
            int count = 0;
            for (int col = 0; col < mat[0].length; col++) {
                if (mat[row][col] == 0)
                    break;
                
                count++;
            }
            
            Pair newPair = new Pair(row, count);
            heap.offer(newPair);
            
            if (heap.size() > k)
                heap.poll();
        }
        
        for (int i = k - 1; i >= 0; i--) {
            weakestRows[i] = heap.poll().row;
        }
        
        return weakestRows;
    }
}

class Pair {
    int row;
    int count;
    
    Pair(int row, int count) {
        this.row = row;
        this.count = count;
    }
}
