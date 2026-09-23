import java.util.*;

class Solution {
  public int lastStoneWeight(int[] stones) {
    Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

    for (int stone : stones) {
      queue.add(stone);
    }

    while (queue.size() >= 2) {
      int y = queue.poll();
      int x = queue.poll();

      if (x != y) {
        y = y - x;
        queue.add(y);
      }
    }

    if (queue.isEmpty()){
      return 0;
    }

    return queue.poll();
  }
}