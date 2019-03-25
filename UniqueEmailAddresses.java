class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> hash = new HashSet<>();
        for (String s: emails) {
            String[] splitted = s.split("@");
            String[] splitagain = splitted[0].split("\\+");
            splitagain[0] = splitagain[0].replace(".","");
         
            hash.add(splitagain[0]+"@"+splitted[1]);
        }
        
        return hash.size();
    }
}
