class TrieNode{
    Map<Character, TrieNode> map = new HashMap<>();
    boolean isWord;
}
class WordDictionary {
    TrieNode root; 
    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(!cur.map.containsKey(c)){
                cur.map.put(c, new TrieNode());
            }
            cur = cur.map.get(c);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        // TrieNode cur = root;
        // for(char c : word.toCharArray()){

        //     if(!cur.map.containsKey(c)){
        //         return false;
        //     }
        //     cur = cur.map.get(c);
        // }

        // return cur.isWord;
        return searchDFS(root, word, 0);
    }
    
    public boolean searchDFS(TrieNode cur, String word, int index){
        if(index==word.length() && cur.isWord){
            //System.out.println(word+" call");
            return true;
        }
        if(index==word.length()){
            return false;
        }
        char c = word.charAt(index);
        //System.out.println(word+" "+c+" ");
        if(c =='.'){
            for(Character key: cur.map.keySet()){
                boolean isPresent = searchDFS(cur.map.get(key), word, index+1);
                if (isPresent){
                    return true;
                }
            }
        } else {
            if(!cur.map.containsKey(c)){
                return false;
            }
            return searchDFS(cur.map.get(c), word, index+1);
        }

        return false;
    }
}
