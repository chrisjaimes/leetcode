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
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
    for (ListNode list : lists) {
      if (list != null) {
        minHeap.add(list);
      }
    }

    ListNode sentinel = new ListNode(-1);
    ListNode tail = sentinel;

    while(!minHeap.isEmpty()) {
      tail.next = minHeap.poll();
      tail = tail.next;

      if (tail.next != null) {
        minHeap.add(tail.next);
      }
    }

    return sentinel.next;
  }
}