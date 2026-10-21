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
    // answer é a cabeça/primeiro item, currentAnswer é o item atual da lista de resposta (último item)
    ListNode answer = null;
    ListNode currentAnswer = null;
    // Dígito que é carregado para a próxima casa
    int nextDigit = 0;

    // Lógica parecida com MergeSort
    // percorremos as duas listas ao mesmo tempo, depois percorremos o restante da
    // lista que ainda não acabou
    while (current1 != null && current2 != null) {
      int sum = current1.val + current2.val + nextDigit;
      int digit = sum % 10;
      nextDigit = sum / 10;

      // Tratando o caso da primeira iteração, onde a lista de resposta ainda não foi
      // criada
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

      // Tratando o caso da primeira iteração, onde a lista de resposta ainda não foi
      // criada
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

      // Tratando o caso da primeira iteração, onde a lista de resposta ainda não foi
      // criada
      if (currentAnswer == null) {
        answer = new ListNode(digit, null);
        currentAnswer = answer;
      } else {
        currentAnswer.next = new ListNode(digit, null);
        currentAnswer = currentAnswer.next;
      }

      current2 = current2.next;
    }

    // Se a última soma tiver gerado um dígito a mais
    if (nextDigit > 0) {
      currentAnswer.next = new ListNode(nextDigit, null);
      currentAnswer = currentAnswer.next;
    }

    return answer;
  }
}