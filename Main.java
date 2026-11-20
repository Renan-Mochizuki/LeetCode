// Arquivo para manualmente testar uma solução
// Comando para compilar e executar:
// javac -d build Q9.java Main.java && java -cp build Main

public class Main {
  public static void main(String[] args) {
    Solution s = new Solution();
    
    System.out.println(s.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
  }
}
