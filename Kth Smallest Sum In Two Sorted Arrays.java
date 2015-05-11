public class Solution {
  private class Node {
    int x;
    int y;
    int value;
    Node(int x, int y, int value) {
      this.x = x;
      this.y = y;
      this.value = value;
    }
    
    @Override
    public int hashCode() {
      return x * 101 + y;
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
      return node.x == this.x &&
            node.y == this.y;
    }
  }
  private class NodeComparator implements Comparator<Node> {
      public int compare(Node a, Node b) {
        return a.value - b.value;
      }
  }
  public int kthSum(int[] A, int[] B, int k) {
    // Write your solution here
    if (A.length == 0 || B.length == 0 || k == 0) {
      return 0;
    }
    Queue<Node> heap = new PriorityQueue<Node>(k, new NodeComparator());
    Set<Node> set = new HashSet<Node>();
    Node start = new Node(0, 0, A[0] + B[0]);
    heap.offer(start);
    set.add(start);
    int rst = Integer.MAX_VALUE;
    while (k > 0) {
      Node node = heap.poll();
      int x = node.x;
      int y = node.y;
      rst = node.value;
      if (x + 1 < A.length) {
        Node nextA = new Node(x + 1, y, A[x + 1] + B[y]);
        if (set.add(nextA)) {
          heap.offer(nextA);
        }
      }
      if (y + 1 < B.length) {
        Node nextB = new Node(x, y + 1, A[x] + B[y + 1]);
        if (set.add(nextB)) {
          heap.offer(nextB);
        }
      }
      k--;
    }
    return rst;
  }
}