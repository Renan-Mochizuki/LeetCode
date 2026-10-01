/**
 * @param {number[]} heights
 * @return {number}
 */
var largestRectangleArea = function (heights) {
  let maxArea = 0;
  const stack = [];
  let lastHeight = 0;

  // Percorrendo todos index
  for (let i = 0; i < heights.length; i++) {
    const currentHeight = heights[i];

    // Se for maior ou igual, vamos só adicionando na pilha, se não, vamos computar a área e remover da pilha
    if (currentHeight >= lastHeight) {
      stack.push([i, currentHeight]);
    } else {
      let previousHeight = stack[stack.length - 1];
      // Armazenando o index do último elemento que foi removido, podemos montar um
      // retângulo do i atual até esse último index
      let lastPreviousIndex = previousHeight[0];

      while (previousHeight != null && previousHeight != undefined && previousHeight[1] > currentHeight) {
        stack.pop();
        lastPreviousIndex = previousHeight[0];
        calculateArea(previousHeight, i);
        // Avança pro próximo da pilha (andando para trás)
        previousHeight = stack[stack.length - 1];
      }
      // Não é necessário armazenar altura 0 na pilha
      if (currentHeight > 0) {
        stack.push([lastPreviousIndex, currentHeight]);
      }
    }
    lastHeight = currentHeight;
  }
  // Acabamos o histograma, vamos limpar a pilha e calcular suas áreas
  while (stack.length > 0) {
    const previousHeight = stack.pop();
    calculateArea(previousHeight, heights.length);
  }

  return maxArea;

  function calculateArea(previousHeight, i) {
    if (previousHeight == null) {
      return;
    }

    const width = i - previousHeight[0];
    const area = width * previousHeight[1];
    if (area > maxArea) {
      maxArea = area;
    }
  }
};
