
class Solution {
    public String addBinary(String a, String b) {
        
        int difference = Math.abs(a.length() - b.length()), carry = 0;
        System.out.print(difference);
        StringBuilder strA = new StringBuilder(a);
        StringBuilder strB = new StringBuilder(b);
        StringBuilder str = new StringBuilder();
        
        if (difference != 0) {
            if (a.length() > b.length()) {
                for(int i = 0; i < difference; i++)
                    strB.insert(0,"0");
            }
            else {
                 for(int i = 0; i < difference; i++)
                    strA.insert(0,"0");
            }
        }

        int index = strB.length();
        System.out.print(index);
        for(int i = 0; i < strA.length(); i++) {
            
            if (carry + strA.charAt(index - 1) - 48 + strB.charAt(index - 1) - 48 == 3) {
                str.insert(0,"1");
                carry = 1;
            }
            else if (carry + strA.charAt(index - 1) - 48 + strB.charAt(index - 1) - 48 == 2) {
                str.insert(0,"0");
                carry = 1;
            }
            else if (carry + strA.charAt(index - 1) - 48 + strB.charAt(index - 1) - 48 == 1) {
                str.insert(0,"1");
                carry = 0;
            }
            else {
            	str.insert(0, "0");
            	carry = 0;
            }
            
           index--;
            
            if (i == strA.length() - 1 && carry == 1) {
                str.insert(0,"1");
                carry = 0;
	            }
            }

        String sum = str.toString();
        return sum;
    }
}
