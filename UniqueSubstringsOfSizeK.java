// https://leetcode.com/discuss/interview-question/344976/Amazon-or-OA-2019-or-Substrings-of-size-K-with-K-distinct-chars
public class Main {
    
    public static List<String> kSubstring(String s, int k) {
        int length = s.length() - k;
        Set<String> result = new HashSet<>();
        
        for (int i = 0; i <= length; i++) {
            Set<Character> chars = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            
            for (int j = i; j < i + k; j++) {
                char c = s.charAt(j);
                if (!chars.contains(c)) {
                    chars.add(c);
                    sb.append(c);
                }
                else {
                    break;
                }
            }
            
            if (sb.length() == k) {
                result.add(sb.toString());
            }
        }
        
        return new ArrayList<>(result);
    }
    
    public static void main(String[] args) {
        System.out.println(kSubstring("awaglknagawunagwkwagl", 4));
    }
}
