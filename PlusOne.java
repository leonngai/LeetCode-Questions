    public int[] plusOne(int[] digits) {
      int index = digits.length - 1, carry = 1;
      
      while(index >= 0 && carry == 1) {
        digits[index] += carry;
        
        if (digits[index] == 10) {
          digits[index] = 0;
          carry = 1;
        }
        else {
          carry = 0;
        }
        
        index--;
      }
     
      
      //numbersSeen = 3
      //index = -1
      //carry = 1
      
      if (carry == 1 && index == -1) {
        digits = new int[digits.length + 1];
        digits[0] = 1;
      }
      
      return digits;
    }
