class Solution {
  public ListNode[] splitListToParts(ListNode head, int k) {
    final int size = getSize(head);
    final int minLen = size / k;
    final int oneMore = size % k;
    final ListNode[] res = new ListNode[k];
    ListNode current = new ListNode();
    current.next = head;
    ListNode ans;
    int step;
    for (int i = 0; i < k; i++) {
      ans = current;
      step = i < oneMore ? minLen + 1 : minLen;
      for (int j = 0; j < step; j++) {
        current = current.next;
      }
      res[i] = ans.next;
      ans.next = null;
    }
    return res;
  }

  private static int getSize(ListNode head) {
    int size = 0;
    while (head != null) {
      size++;
      head = head.next;
    }
    return size;
  }
}