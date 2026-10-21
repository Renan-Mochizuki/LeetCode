import java.util.*;

class Solution {
  public int lengthOfLongestSubstring(String s) {
    // Ponteiros para o início e fim da substring
    int l = 0, r = 1;
    int max = 0;

    // HashMap vai guardar os caracteres e sua posição na string
    Map<Character, Integer> map = new HashMap<>();

    // Tratando esses casos
    if (s.length() == 0) {
      return 0;
    }
    if (s.length() == 1) {
      return 1;
    }

    map.put(s.charAt(l), l);

    // Vamos percorrer toda string, movendo o ponteiro da direita, armazenando os caracteres no HashMap
    // Se o caractere já existir no HashMap, encontramos um caractere repetido, armazenamos o tamanho da substring
    // e movemos o ponteiro da esquerda até o caractere novo, limpando o HashMap para reiniciar a contagem de uma nova substring
    while (r < s.length()) {
      char right = s.charAt(r);
      // Se acharmos um caractere repetido
      if (map.containsKey(right)) {
        // Calculando o tamanho da substring
        int calc = r - l;
        if (calc > max) {
          max = calc;
        }
        // Movendo o ponteiro da esquerda, limpando o HashMap
        // Vamos parar quando acharmos o caractere repetido (da esquerda) ou quando o ponteiro da esquerda chegar no ponteiro da direita
        while (l < r) {
          char left = s.charAt(l);
          map.remove(left);
          l++;
          if (left == right) {
            break;
          }
        }
      }
      // Movendo o ponteiro da direita e armazenando o caractere no HashMap
      r++;
      map.put(right, r);
    }

    int calc = r - l;
    if (calc > max) {
      max = calc;
    }

    return max;
  }
}
