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
    
    private ListNode swap(ListNode pre, ListNode head)
    {
        if(head == null || head.next == null)
            return head;
        swap(head.next, head.next.next);
        ListNode next = head.next;
        head.next = next.next;
        next.next = head;
        pre.next = next;
        return next;
    }
    
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        swap(head.next, head.next.next);
        ListNode next = head.next;
        head.next = next.next;
        next.next = head;    
        
        
        return next;
    }
}