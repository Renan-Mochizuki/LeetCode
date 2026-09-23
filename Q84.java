import java.util.*;

class Solution {
  int maxArea = 0;

  public int largestRectangleArea(int[] heights) {
    Deque<int[]> stack = new ArrayDeque<>();
    int lastHeight = 0;
    this.maxArea = 0;

    // Percorrendo todos index
    for (int i = 0; i < heights.length; i++) {
      int currentHeight = heights[i];

      // Se não for menor, vamos só adicionando na pilha, se não, teremos que computar
      // e remover da pilha
      if (currentHeight < lastHeight) {
        int[] previousHeight = stack.peek();
        // Armazenando o index do último elemento que foi removido, podemos montar um
        // retângulo do i atual até esse último index
        int lastPreviousIndex = previousHeight[0];
        while (previousHeight != null && previousHeight[1] > currentHeight) {
          stack.pop();
          lastPreviousIndex = previousHeight[0];
          calculateArea(previousHeight, i);
          // Avança pro próximo da pilha (andando para trás)
          previousHeight = stack.peek();
        }
        // Não é necessário armazenar altura 0 na pilha
        if (currentHeight > 0) {
          stack.push(new int[] { lastPreviousIndex, currentHeight });
        }
      } else {
        stack.push(new int[] { i, currentHeight });
      }
      lastHeight = currentHeight;
    }

    // Acabamos o histograma, vamos limpar a pilha e calcular suas áreas
    while (!stack.isEmpty()) {
      int[] previousHeight = stack.pop();
      calculateArea(previousHeight, heights.length);
    }

    return maxArea;
  }

  private void calculateArea(int[] previousHeight, int i) {
    if (previousHeight == null) {
      return;
    }

    int width = i - previousHeight[0];
    int area = width * previousHeight[1];
    if (area > this.maxArea) {
      this.maxArea = area;
    }
  }
}