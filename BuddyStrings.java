class Solution {
    /*
        Process:
        1) Check if strings are of equal length
            1a) return false if not
        2) Check if strings are equal
            2a) check using a set that there is more than one unique letter ie: aa -> true, ab -> false
        3) Iterate through strings and add indices where the letters are different
            3a) compare if the strings would be equal after this swap
    */
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length())
            return false;
        
        if (A.equals(B)) {
            Set<Character> set = new HashSet<>();
            for (Character c : A.toCharArray())
                set.add(c);
            return set.size() < A.length();
        }
        
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i))
                indices.add(i);
        }
        
        return indices.size() == 2 && A.charAt(indices.get(0)) == B.charAt(indices.get(1)) && A.charAt(indices.get(1)) == B.charAt(indices.get(0));
    }
}
