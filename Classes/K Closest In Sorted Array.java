public class Solution {
  private class Node {
    int value;
    int diff;
    Node(int diff, int value) {
      this.diff = diff;
      this.value = value;
    }
    public int getValue() {
      return value;
    }
  }
  private class NodeComparator implements Comparator<Node> {
    public int compare(Node a, Node b) {
      return a.diff - b.diff;
    }
  }
  public int[] kClosest(int[] array, int target, int k) {
    // Write your solution here
    if(array == null || array.length == 0) {
      return array;
    }
    List<Node> minusTarget = new ArrayList<Node>();
    for (int i : array) {
      minusTarget.add(new Node(Math.abs(i - target), i));
    }
    Collections.sort(minusTarget, new NodeComparator());
    int[] rst = new int[k];
    for (int i = 0; i < k; i++) {
      rst[i] = minusTarget.get(i).getValue();
    }
    return rst;
  }
}