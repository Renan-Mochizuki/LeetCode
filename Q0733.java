import java.util.LinkedList;
import java.util.Queue;

class Solution {
  int[][] matrix;
  int color;
  int m, n;
  Queue<int[]> queue;
  int target;

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    this.m = image.length;
    this.n = image[sr].length;
    if (this.m == 0 || this.n == 0) {
      return image;
    }

    this.target = image[sr][sc];
    this.matrix = image;
    this.color = color;

    bfs(sr, sc);

    return matrix;
  }

  private void bfs(int sr, int sc) {
    queue = new LinkedList<>();

    queue.add(new int[] { sr, sc });
    matrix[sr][sc] = color;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int i = current[0];
      int j = current[1];

      checkNeighbor(i, j - 1);
      checkNeighbor(i - 1, j);
      checkNeighbor(i, j + 1);
      checkNeighbor(i + 1, j);
    }
  }

  private boolean checkNeighbor(int i, int j) {
    if (i >= m || j >= n || i < 0 || j < 0) {
      return false;
    }
    if (matrix[i][j] == target && matrix[i][j] != color) {
      matrix[i][j] = color;
      queue.add(new int[] { i, j });
      return true;
    }

    return false;
  }
}