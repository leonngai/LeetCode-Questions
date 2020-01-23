class Solution {
    public String reorganizeString(String s) {
        if (s == null || s.length() == 0)
            return "";
        
        int[] count = new int[26];
        int len = s.length();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<>() {
            public int compare (Pair p1, Pair p2) {
                return p2.count - p1.count;
            }
        });
        
        for (int i = 0; i < len; i++) {
            count[s.charAt(i) - 'a']++;
            //If at any point we have found a count that is greater than majority then 
            if (count[s.charAt(i) - 'a'] > (len + 1) / 2) {
                return "";
            }
        }
        
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                pq.add(new Pair((char) (i + 'a'), count[i]));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(pq.size() >= 2) {
            Pair p1 = pq.poll();
            Pair p2 = pq.poll();
            
            sb.append(p1.c);
            sb.append(p2.c);
            
            if (--p1.count > 0) pq.add(p1);
            if (--p2.count > 0) pq.add(p2);
        }
        
        if (pq.size() > 0) {
            sb.append(pq.poll().c);
        }

        
        return sb.toString();
    }
}

class Pair {
    char c;
    int count;
    
    Pair(char c, int count) {
        this.c = c;
        this.count = count;
    }
}
