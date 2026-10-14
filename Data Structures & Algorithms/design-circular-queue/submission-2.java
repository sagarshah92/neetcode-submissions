class Node {

    int val;
    Node next;
    Node prev;

    public Node(int val){
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class MyCircularQueue {
    int size;
    Node head;
    Node tail;
    int currentSize =0;

    public MyCircularQueue(int k) {
        this.size =k;
        Node head = new Node(-1);
        Node tail = new Node(-1);
        head.next = tail;
        head.prev = tail;
        tail.next = head;
        tail.prev = head;
        this.head = head;
        this.tail = tail;
    }
    
    public boolean enQueue(int value) {
        if(currentSize==this.size){
            return false;
        }
        Node n = new Node (value);
        n.next = this.tail.next;
        n.prev = tail;
        this.tail.next.prev = n;
        tail.next = n;
        currentSize= currentSize+1;
        return true;
    }
    
    public boolean deQueue() {
        if(currentSize==0){
            return false;
        }
        Node p = head.prev;
        head.prev = p.prev;
        p.prev.next = head;
        p.next = null;
        p.prev = null;
        currentSize = currentSize-1;
        return true;
    }
    
    public int Front() {
        return head.prev.val;
    }
    
    public int Rear() {
        return tail.next.val;
    }
    
    public boolean isEmpty() {
        return currentSize==0;
    }
    
    public boolean isFull() {
        return currentSize==this.size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */