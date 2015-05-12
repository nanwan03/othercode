public class Solution {
  private class Node {
    int x;
    int y;
    Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
    @Override
    public int hashCode() {
      return x * 31 + y;
    }
    @Override
    public boolean equals(Object obj) {
      if (obj == null || !(obj instanceof Node)) {
        return false;
      }
      if (obj == this) {
        return true;
      }
      Node node = (Node)(obj);
      return node.x == this.x && node.y == this.y;
    }
  }
  public int whiteObjects(int[][] matrix) {
    // write your solution here
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    int row = matrix.length;
    int col = matrix[0].length;
    int count = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if(matrix[i][j] == 0) {
          BFS(matrix, i, j);
          count++;
        }
      }
    }
    return count;
  }
  private void BFS(int[][] matrix, int i, int j) {
    int row = matrix.length;
    int col = matrix[0].length;
    Queue<Node> queue = new LinkedList<Node>();
    Set<Node> set = new HashSet<Node>();
    matrix[i][j] = 1;
    queue.offer(new Node(i, j));
    set.add(new Node(i, j));
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      int prevX = node.x;
      int prevY = node.y;
      if (prevX > 0 && matrix[prevX - 1][prevY] == 0) {
        Node newNode = new Node(prevX - 1, prevY);
        if (set.add(newNode)) {
          queue.offer(newNode);
          matrix[prevX - 1][prevY] = 1;
        }
      }
      if (prevX < row - 1 && matrix[prevX + 1][prevY] == 0) {
        Node newNode = new Node(prevX + 1, prevY);
        if (set.add(newNode)) {
          queue.offer(newNode);
          matrix[prevX + 1][prevY] = 1;
        }
      }
      if (prevY > 0 && matrix[prevX][prevY - 1] == 0) {
        Node newNode = new Node(prevX, prevY - 1);
        if (set.add(newNode)) {
          queue.offer(newNode);
          matrix[prevX][prevY - 1] = 1;
        }
      }
      if (prevY < col - 1 && matrix[prevX][prevY + 1] == 0) {
        Node newNode = new Node(prevX, prevY + 1);
        if (set.add(newNode)) {
          queue.offer(newNode);
          matrix[prevX][prevY + 1] = 1;
        }
      }
    }
  }
}