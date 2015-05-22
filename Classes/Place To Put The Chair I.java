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
      return this.x * 31 + this.y;
    }
    @Override
    public boolean equals(Object obj) {
      if (obj == null || !(obj instanceof Node)) {
        return false;
      }
      if (obj == this) {
        return true;
      }
      Node node = (Node)obj;
      return node.x == this.x && node.y == this.y;
    }
  }
  public List<Integer> putChair(char[][] gym) {
    List<Integer> rst = new ArrayList<Integer>();
    if (gym == null || gym.length == 0) {
      return rst;
    }
    int row = gym.length;
    int col = gym[0].length;
    int[][] costSum = new int[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (gym[i][j] == 'E') {
          if (!addCost(gym, i, j, costSum)) {
            return null;
          }
        }
      }
    }
    Node node = null;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (gym[i][j] != 'O' && gym[i][j] != 'E') {
          if (node == null) {
            node = new Node(i, j);
          }else if (costSum[i][j] < costSum[node.x][node.y]) {
            node.x = i;
            node.y = j;
          }
        }
      }
    }
    if (node == null) {
      return null;
    } else {
      rst.add(node.x);
      rst.add(node.y);
      return rst;
    }
  }
  
  private boolean addCost(char[][] gym, int i, int j, int[][] costSum) {
    int row = gym.length;
    int col = gym[0].length;
    Queue<Node> queue = new LinkedList<Node>();
    queue.offer(new Node(i, j));
    boolean[][] visited = new boolean[row][col];
    visited[i][j] = true;
    int level = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int x = 0; x < size; x++) {
        Node node = queue.poll();
        costSum[node.x][node.y] += level;
        List<Node> neighbors = getNeighbors(node, gym);
        for (Node neighbor : neighbors) {
          if (!visited[neighbor.x][neighbor.y]) {
            queue.offer(neighbor);
            visited[neighbor.x][neighbor.y] = true;
          }
        }
      }
      level++;
    }
    for (int x = 0; x < row; x++) {
      for (int y = 0; y < col; y++) {
        if (gym[x][y] == 'E' && !visited[x][y]) {
          return false;
        }
      }
    }
    return true;
  }
  
  private List<Node> getNeighbors(Node node, char[][] gym) {
    int row = gym.length;
    int col = gym[0].length;
    List<Node> rst = new ArrayList<Node>();
    if (node.x - 1 >= 0 && gym[node.x - 1][node.y] != 'O') {
      rst.add(new Node(node.x - 1, node.y));
    }
    if (node.x + 1 < row && gym[node.x + 1][node.y] != 'O') {
      rst.add(new Node(node.x + 1, node.y));
    }
    if (node.y - 1 >= 0 && gym[node.x][node.y - 1] != 'O') {
      rst.add(new Node(node.x, node.y - 1));
    }
    if (node.y + 1 < col && gym[node.x][node.y + 1] != 'O') {
      rst.add(new Node(node.x, node.y + 1));
    }
    return rst;
  }
}