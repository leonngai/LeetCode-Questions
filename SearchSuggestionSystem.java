class Trie {
    Trie[] next = new Trie[26];
    List<String> suggestions = new ArrayList<>();
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        
        Trie root = new Trie();
        
        for (String product : products) {
            Trie letter = root;
            
            for (Character c : product.toCharArray()) {
                if (letter.next[c - 'a'] == null) 
                    letter.next[c - 'a'] = new Trie();
                
                letter = letter.next[c - 'a'];
                if (letter.suggestions.size() < 3)
                    letter.suggestions.add(product);
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        for (Character c : searchWord.toCharArray()) {
            if (root != null) {
                root = root.next[c - 'a'];
            }
            
            res.add(root == null ? new ArrayList<>() : root.suggestions);
        }
        
        return res;
    }
}
