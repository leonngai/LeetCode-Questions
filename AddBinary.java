class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder sum = new StringBuilder();
        int aLength = a.length() - 1, bLength = b.length() - 1, carry = 0;

        while (aLength >= 0 || bLength >= 0 || carry == 1) {
            
            int aNum = aLength < 0 ? 0 : a.charAt(aLength--) - 48;
            int bNum = bLength < 0 ? 0 : b.charAt(bLength--) - 48;
            
            sum.insert(0, (carry + aNum + bNum) % 2);
            carry = (carry + aNum + bNum) / 2;
            }

        String str = sum.toString();
        return str;
    }
}
