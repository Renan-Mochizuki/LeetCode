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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode current1 = l1;
    ListNode current2 = l2;
    ListNode answer = null;
    ListNode currentAnswer = null;
    int nextDigit = 0;

    while (current1 != null && current2 != null) {
      int sum = current1.val + current2.val + nextDigit;
      int digit = sum % 10;
      nextDigit = sum / 10;

      if (currentAnswer == null) {
        answer = new ListNode(digit, null);
        currentAnswer = answer;
      } else {
        currentAnswer.next = new ListNode(digit, null);
        currentAnswer = currentAnswer.next;
      }

      current1 = current1.next;
      current2 = current2.next;
    }

    while (current1 != null) {
      int sum = current1.val + nextDigit;
      int digit = sum % 10;
      nextDigit = sum / 10;

      if (currentAnswer == null) {
        answer = new ListNode(digit, null);
        currentAnswer = answer;
      } else {
        currentAnswer.next = new ListNode(digit, null);
        currentAnswer = currentAnswer.next;
      }

      current1 = current1.next;
    }

    while (current2 != null) {
      int sum = current2.val + nextDigit;
      int digit = sum % 10;
      nextDigit = sum / 10;

      if (currentAnswer == null) {
        answer = new ListNode(digit, null);
        currentAnswer = answer;
      } else {
        currentAnswer.next = new ListNode(digit, null);
        currentAnswer = currentAnswer.next;
      }

      current2 = current2.next;
    }

    if (nextDigit > 0) {
      if (currentAnswer == null) {
        answer = new ListNode(nextDigit, null);
        currentAnswer = answer;
      } else {
        currentAnswer.next = new ListNode(nextDigit, null);
        currentAnswer = currentAnswer.next;
      }
    }

    return answer;
  }
}