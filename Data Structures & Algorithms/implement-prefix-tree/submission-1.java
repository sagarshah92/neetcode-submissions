class TrieNode {
    Map<Character, TrieNode> map = new HashMap<>();
    //TrieNode[] children = new TrieNode[26];
    boolean endofword = false;
}
class PrefixTree {

    TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if (!cur.map.containsKey(c)){
                cur.map.put(c, new TrieNode());
            }
            cur= cur.map.get(c);
        }
        cur.endofword = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char c: word.toCharArray()){
            if (!cur.map.containsKey(c)){
                return false;
            }
            cur = cur.map.get(c);
        }
        return cur.endofword;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c: prefix.toCharArray()){
            if (!cur.map.containsKey(c)){
                return false;
            }
            cur = cur.map.get(c);
        }
        return true;
    }
}
