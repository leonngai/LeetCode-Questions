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
        List<Pair> list = new ArrayList<>();
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
            list.add(pair);

            lo++;
        }
        
        Collections.sort(list, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                if (p1.power == p2.power)
                    return Integer.compare(p1.val, p2.val);
                else
                    return Integer.compare(p1.power, p2.power);
            }
        });

        return list.get(k - 1).val;
    }
}
