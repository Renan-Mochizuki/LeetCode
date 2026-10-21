class Solution {
  public int maxSubArray(int[] nums) {
    int max = nums[0];
    int current = nums[0];

    // Percorremos o array e vamos adicionando os valores do subarray
    // Se a adição do valor atual for negativa, não há porque continuar com o subarray, então reiniciamos o subarray com o valor atual
    // E vamos registrando o maior valor, em algum momento passaremos pela maior subarray 
    for (int i = 1; i < nums.length; i++) {
      current = current + nums[i];
      if (nums[i] > current) {
        current = nums[i];
      }

      if (current > max) {
        max = current;
      }
    }

    return max;
  }
}