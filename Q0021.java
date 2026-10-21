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
    // answer é a cabeça/primeiro item, currentAnswer é o item atual da lista de resposta (último item)
    ListNode answer = null;
    ListNode current = null;

    // Tratando o caso onde as duas listas são nulas
    if (list1 == null && list2 == null) {
      return answer;
    }

    // Tratando o caso da primeira iteração
    // Vamos criar o primeiro item da lista de resposta
    // Se uma das listas não existir
    if (list1 == null) {
      answer = new ListNode(list2.val, null);
      current = answer;
      list2 = list2.next;
    } else if (list2 == null) {
      answer = new ListNode(list1.val, null);
      current = answer;
      list1 = list1.next;
    } else {
      // Ambas listas existem, vamos comparar os valores para decidir o primeiro item da lista de resposta
      if (list2.val < list1.val) {
        answer = new ListNode(list2.val, null);
        current = answer;
        list2 = list2.next;
      } else {
        answer = new ListNode(list1.val, null);
        current = answer;
        list1 = list1.next;
      }
    }

    // Percorrendo as duas listas ao mesmo tempo
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

    // Percorrendo a lista que ainda não acabou
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