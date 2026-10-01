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
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode answer = null;
    ListNode current = null;

    if (list1 == null && list2 == null) {
      return answer;
    }

    if (list2 != null && (list1 == null || list2.val < list1.val)) {
      answer = new ListNode(list2.val, null);
      current = answer;
      list2 = list2.next;
    } else {
      answer = new ListNode(list1.val, null);
      current = answer;
      list1 = list1.next;
    }

    while (list1 != null && list2 != null) {
      if (list2.val < list1.val) {
        current.next = new ListNode(list2.val, null);
        current = current.next;
        list2 = list2.next;
      } else {
        current.next = new ListNode(list1.val, null);
        current = current.next;
        list1 = list1.next;
      }
    }

    while (list1 != null) {
      current.next = new ListNode(list1.val, null);
      current = current.next;
      list1 = list1.next;
    }

    while (list2 != null) {
      current.next = new ListNode(list2.val, null);
      current = current.next;
      list2 = list2.next;
    }

    return answer;
  }
}