class Solution {
  public boolean isPalindrome(int x) {
    // Se for negativo, não é palíndromo
    if (x < 0) {
      return false;
    }

    // Cria cópia
    int y = x;
    // Número criado de trás para frente
    int accumulated = 0;

    // Vamos recriar o número de trás para frente e depois comparar com o original
    while (y > 0) {
      int lastDigit = y % 10;
      y = y / 10;
      accumulated = accumulated * 10 + lastDigit;
    }

    if (accumulated == x) {
      return true;
    }

    return false;
  }
}