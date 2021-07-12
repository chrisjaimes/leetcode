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
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (ListNode list : lists) {
      ListNode head = list;
      while (head != null) {
        minHeap.add(head.val);
        head = head.next;
      }
    }
      
    ListNode sentinel = new ListNode(-1);
    ListNode result = sentinel;
    while (!minHeap.isEmpty()) {
      result.next = new ListNode(minHeap.remove());
      result = result.next;
    }
      
    return sentinel.next;
  }
}