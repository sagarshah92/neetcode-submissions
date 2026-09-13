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
    public void reorderList(ListNode head) {
        if (head ==null || head.next ==null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // if (fast!=null){
        //     slow = slow.next;
        // }

        ListNode prev = null;
        ListNode cur = slow;
        while (cur.next!=null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        cur.next = prev;
        //System.out.println("Cur next"+ cur.next.val);
        ListNode first = head;
        ListNode second = cur;
        while (second !=null&& first!=null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
           
            first.next = second;

            
            second.next = temp1;
            first = temp1;
            second = temp2;

        }

        
    }
}
