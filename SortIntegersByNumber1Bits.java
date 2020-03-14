class Solution {
    public int[] sortByBits(int[] arr) {
        //First we sort the array to ensure the order that we put in the lists is ascending order
        Arrays.sort(arr);
        
        //Use treemap instead of hashmap to ensure ascending order of keys
        Map<Integer, List<Integer>> map = new TreeMap<>();
        
        for (int n : arr) {
            int temp = n, count = 0;
            
            //Count number of bits for each number
            while(temp > 0) {
                count += temp & 1;
                temp = temp >> 1;
            }
            
            //If this specific frequency has already been found, then add n to the list 
            if (map.containsKey(count)) {
                map.get(count).add(n);
            }
            //If this specific frequency has not been found, add a new list to this count
            else {
                List<Integer> newList = new ArrayList<>();
                newList.add(n);
                map.put(count, newList);
            }
        }
        
        //Iterate through the map and change the number in the array to this
        int index = 0;
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> temp = entry.getValue();

            for (int n : temp) {
                arr[index] = n;
                index++;
            }
        }
        
        return arr;
    }
}
