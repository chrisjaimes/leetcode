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
  public ListNode oddEvenList(ListNode head) {
    if (head == null) {
      return null;  
    } else if (head.next == null) {
      return head;
    }
    ListNode odd = head;
    ListNode oddHead = head;
    ListNode even = odd.next;
    ListNode evenHead = even;
    
    while (odd != null && even != null) {
      odd.next = even.next;
      if (even.next != null) {
        even.next = even.next.next;    
      }
      
      if (odd.next != null) {
        odd = odd.next;
      } else {
        odd.next = evenHead;
      }
      even = even.next;
    }
    if (odd != null && odd.next != evenHead) {
      odd.next = evenHead;
    }
    return oddHead;
  }
}