class Node{
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }

}
class LRUCache {
    int size;
    Map<Integer, Node> map;
    Node left;
    Node right; 

    public LRUCache(int capacity) {
        this.size = capacity;
        this.map = new HashMap<>();
        left = new Node(0,0);
        right = new Node(0,0);
        left.next = right;
        right.prev = left;
    }
    public void remove(Node node){
        Node next = node.next;
        Node prev = node.prev;
        next.prev = prev;
        prev.next = next;
    }

    public void add(Node node){
        Node leftmoset = right.prev;
        leftmoset.next = node;
        node.prev = leftmoset;
        node.next = right;
        right.prev = node;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            add(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){
            remove(map.get(key));
        }
        
        Node node = new Node(key, value);
        map.put(key, node);
        add(node);

        if(map.size()>this.size){
            Node first = left.next;
            remove(first);
            map.remove(first.key);
        }
        
    }
}
