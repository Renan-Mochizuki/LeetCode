import java.util.*;

class KthLargest {
  Queue<Integer> heap;
  int k;
  int size;

  public KthLargest(int k, int[] nums) {
    this.k = k;
    heap = new PriorityQueue<>();

    for (int num : nums) {
      heap.add(num);
      size++;

      if (size > k) {
        heap.poll();
        size--;
      }
    }
  }

  public int add(int val) {
    heap.add(val);
    size++;
    if (size > k) {
      heap.poll();
      size--;
    }
    return heap.peek();
  }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */