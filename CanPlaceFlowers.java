class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1 && flowerbed[0] == 0) {
            n--;
        }
        
        else if (flowerbed.length > 1 && flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            n--;
        }
        
        int i = 1;
        
        while(n > 0 && i < flowerbed.length - 1) {
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                n--;
                flowerbed[i] = 1;
            }
            
            if (flowerbed[i] == 0)
                i++;
            else
                i += 2;
        }
        
        if (flowerbed.length > 1 && flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0)
            n--;
        
        return n <= 0;
    }
}
