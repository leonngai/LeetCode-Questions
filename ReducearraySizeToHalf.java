class Solution {
    public int minSetSize(int[] arr) {
        int needed = arr.length / 2, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
		List<Integer> freqList = new ArrayList<>();
        
        for(int n: arr) 
            map.put(n, map.getOrDefault(n, 0) +1);
        for(Integer i : map.keySet()) 
            freqList.add(map.get(i));
		
        Collections.sort(freqList, Collections.reverseOrder());
		
        for(int i = 0; i < freqList.size(); i++){
            needed -= freqList.get(i);
            if(needed <= 0) return i+1;
        }
        return -1;
    }
}
