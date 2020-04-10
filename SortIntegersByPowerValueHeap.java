class Pair {
    int val;
    int power;
    
    Pair(int val, int power) {
        this.val = val;
        this.power = power;
    }
}

class Solution {
    public int getKth(int lo, int hi, int k) {
        PriorityQueue<Pair> heap = new PriorityQueue<Pair>(k + 1, (Comparator<? super Pair>) new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                if (p1.power == p2.power)
                	return p2.val - p1.val;
                else
                	return p2.power - p1.power;
            }
        });
        
        Map<Integer, Integer> map = new HashMap<>();
        
        while (lo <= hi) {
            int num = lo, count = 0;
            
            while(num != 1) {
                if (map.containsKey(num)) {
                    count += map.get(num);
                    break;
                }
                
                else if (num % 2 == 0)
                    num = num / 2;
                else
                    num = 3 * num + 1;
                
                count++;
            }
            
            Pair pair = new Pair(lo, count);
            map.put(lo, count);
            heap.offer(pair);
            
            if (heap.size() > k)
                heap.poll();
            
            lo++;
        }

        return heap.poll().val;
    }
}
