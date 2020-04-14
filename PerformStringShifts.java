class Solution {
    public String stringShift(String s, int[][] shifts) {
        int shift = 0;
        
        for (int[] turn: shifts) {
            if (turn[0] == 0)
                shift -= turn[1];
            else
                shift += turn[1];
        }
        
        shift %= s.length();
        
        if (shift == 0)
            return s;
        
        StringBuilder sb = new StringBuilder();
        //meaning this is going to be a right shift
        if (shift > 0)
            shift = s.length() - shift;
        else 
            shift *= -1;
        
        for (int i = shift; i < s.length(); i++)
            sb.append(s.charAt(i));
        for (int i = 0; i < shift; i++)
            sb.append(s.charAt(i));
        
        return sb.toString();
    }
}
