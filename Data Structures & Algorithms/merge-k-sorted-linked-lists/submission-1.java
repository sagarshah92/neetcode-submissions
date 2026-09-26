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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0){
            return null;
        }
        if (lists.length==1){
            return lists[0];
        }
        for(int i = 1; i<lists.length; i++){
            lists[i]= mergeList(lists[i], lists[i-1]);
        }

        return lists[lists.length-1];
    }

    public ListNode mergeList(ListNode a, ListNode b){
        ListNode prev = new ListNode(-1, null);
        ListNode current = prev;
        while(a!=null && b!=null){
            if(a.val<=b.val){
                current.next = a;
                a = a.next;
            } else{
                current.next = b;
                b = b.next;
            }
            current = current.next;
        }
        while(a!=null){
            current.next = a;
            a = a.next;
            current = current.next;
        }
        while(b!=null){
            current.next = b;
            b = b.next;
            current = current.next;
        }
        return prev.next;
    }
}
