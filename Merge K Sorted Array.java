public class Solution {
  private class Node {
    int val;
    int x;
    int y;
    Node(int val, int x, int y) {
      this.val = val;
      this.x = x;
      this.y = y;
    }
  }
  private class NodeComparator implements Comparator<Node> {
    public int compare(Node a, Node b) {
      return a.val - b.val;
    }
  }
  public int[] merge(int[][] arrayOfArrays) {
    int[][] a = arrayOfArrays;
    if (a == null || a.length == 0) {
      return new int[0];
    }
    int count = 0;
    for (int i = 0; i < a.length; i++) {
    	for (int j = 0; j < a[i].length; j++) {
    		count++;
    	}
    }
    if (count == 0) {
      return new int[0];
    }
    int[] rst = new int[count];
    int index = 0;
    Queue<Node> heap = new PriorityQueue<Node>(count, new NodeComparator());
    for (int i = 0; i < a.length; i++) {
      if (a[i].length > 0) {
        heap.offer(new Node(a[i][0], i, 0));
      }
    }
    while (!heap.isEmpty()) {
      Node node = heap.poll();
      int val = node.val;
      int x = node.x;
      int y = node.y;
      rst[index++] = val;
      if (y < a[x].length - 1) {
        heap.offer(new Node(a[x][y + 1], x, y + 1));
      }
    }
    return rst;
  }
}