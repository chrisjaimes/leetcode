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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode sentinel = new ListNode(0);
    ListNode head = sentinel;
    int carry = 0;
    int sum = carry;
    while (l1 != null || l2 != null) {
      sum = carry;
      if (l1 == null) {
        sum = l2.val + carry; 
        l2 = l2.next;
      } else if (l2 == null) {
        sum = l1.val + carry;
        l1 = l1.next;
      } else {
        sum = l1.val + l2.val + carry;
        l1 = l1.next;
        l2 = l2.next;
      }
      
      if (sum > 9) {
        carry = 1;
        sum %= 10;
      } else {
        carry = 0;
      }
      
      head.next = new ListNode(sum);
      head = head.next;
    }
    
    if (carry > 0) {
      head.next = new ListNode(carry);
    }
    
    return sentinel.next;
  } 
}
