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
    ListNode sentinel = new ListNode(-1);
    sentinel.next = head;
    
    ListNode slow = sentinel;
    ListNode fast = sentinel;
    
    while (n >= 0) {
      fast = fast.next;
      n--;
    }
    
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return sentinel.next;
  }
}

