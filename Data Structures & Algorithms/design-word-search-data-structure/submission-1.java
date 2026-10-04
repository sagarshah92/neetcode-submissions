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
        for(int i =index; i<word.length(); i++){
            char c = word.charAt(i);
            //System.out.println(word+" "+c+" ");
            if(c =='.'){
                for(Character key: cur.map.keySet()){
                    boolean isPresent = searchDFS(cur.map.get(key), word, i+1);
                    if (isPresent){
                        return true;
                    }
                }
                return false;
            } else {
                if(!cur.map.containsKey(c)){
                    return false;
                }
                cur = cur.map.get(c);
            }
        }
        

        return cur.isWord;
    }
}
