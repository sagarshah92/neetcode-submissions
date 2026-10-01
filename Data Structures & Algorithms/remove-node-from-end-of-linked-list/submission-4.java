/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        // Stack<ListNode> stack = new Stack<>();
        // ListNode cur = head;
        // while(cur!=null){
        //     stack.push(cur);
        //     cur = cur.next;
        // }
        // ListNode last= null;
        // for(int i =0; i<n-1; i++){
        //     last= stack.pop();
        // }
        // ListNode removeNode = stack.pop();
        // if(stack.isEmpty()){
        //     return last;
        // }
        // stack.peek().next = last;
        // removeNode.next = null;
        // //System.out.println(last.val);
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;

        for(int i=0; i<n;i++){
            right = right.next;
        }
        //System.out.println("Right:" + right.val);
        while(right !=null){
            left= left.next;
            right= right.next;
        }
        
        left.next = left.next.next;
        return dummy.next;

    }
}
