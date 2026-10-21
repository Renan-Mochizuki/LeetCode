class Solution {
  public int climbStairs(int n) {
    // A solução do item atual depende da solução dos dois itens anteriores, portanto fibonacci
    // Implementação iterativa, para não estourar a pilha de recursão
    int[] computed = new int[n + 1];

    computed[0] = 1;
    computed[1] = 1;

    for (int i = 2; i <= n; i++) {
      computed[i] = computed[i - 1] + computed[i - 2];
    }

    return computed[n];
  }
}