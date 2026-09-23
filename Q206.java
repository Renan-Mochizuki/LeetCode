/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode answer = null;

    while (head != null) {
      if (answer == null) {
        answer = new ListNode(head.val, null);
        head = head.next;
        continue;
      }

      answer = new ListNode(head.val, answer);
      head = head.next;
    }

    return answer;
  }
}