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
    int length = 0;
    ListNode sentinel = new ListNode(-1);
    sentinel.next = head;
    
    while (head != null) {
      length++;
      head = head.next;
    }
    
    int nth = 0;
    head = sentinel;
    while (nth < (length - n)) {
      nth++;
      head = head.next;
    }
    
    head.next = head.next.next;   
    return sentinel.next;
  }
}