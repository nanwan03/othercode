public class Solution {
  private class Node implements Comparable<Node> {
        int x;
        int y;
        int val;
        Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        @Override
        public int compareTo(Node node) {
            return this.val - node.val;
        }
  }
  private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  public int maxTrapped(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
            return 0;
    }
    int row = matrix.length;
    int col = matrix[0].length;
    boolean[][] visited = new boolean[row][col];
    Queue<Node> heap = new PriorityQueue<Node>();
    for (int i = 0; i < row; ++i) {
        for (int j = 0; j < col; ++j) {
            if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                visited[i][j] = true;
                heap.offer(new Node(i, j, matrix[i][j]));
            }
        }
    }
    int rst = 0;
    int max = Integer.MIN_VALUE;
    while (!heap.isEmpty()) {
        Node node = heap.poll();
        max = Math.max(max, node.val);
        List<Node> neighbors = getNeighbor(node, row, col, matrix, visited);
        for (Node neighbor : neighbors) {
            heap.offer(neighbor);
            rst += Math.max(0, max - neighbor.val);
        }
    }
    return rst;
  }
  private List<Node> getNeighbor(Node node, int row, int col, int[][] heightMap, boolean[][] visited) {
        int x = node.x;
        int y = node.y;
        List<Node> rst = new ArrayList<Node>();
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX < 0 || newY < 0 || newX >= row || newY >= col || visited[newX][newY]) {
                continue;
            }
            visited[newX][newY] = true;
            rst.add(new Node(newX, newY, heightMap[newX][newY]));
        }
        return rst;
    }
}
