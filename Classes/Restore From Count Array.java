
public class Solution {
  private class Node {
    int start;
    int end;
    Node left;
    Node right;
    int count;
    Node(int start, int end) {
      this.start = start;
      this.end = end;
      this.left = null;
      this.right = null;
      this.count = end - start + 1;
    }
  }
  public int[] restore(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return new int[0];
    }
    int[] rst = new int[array.length];
    Node root = build(1, array.length);
    for (int i = 0; i < array.length; ++i) {
      rst[i] = query(root, array[i]);
      modify(root, rst[i]);
    }
    return rst;
  }
  private Node build(int start, int end) {
    if (start > end) {
      return null;
    }
    Node root = new Node(start, end);
    if (start == end) {
      return root;
    }
    int mid = start + (end - start) / 2;
    root.left = build(start, mid);
    root.right = build(mid + 1, end);
    return root;
  }
  private int query(Node root, int value) {
    if (root == null) {
      return -1;
    }
    if (value == 0 && root.left == null && root.right == null) {
      return root.start;
    }
    if (value < root.left.count) {
      return query(root.left, value);
    } else {
      return query(root.right, value - root.left.count);
    }
  }
  private void modify(Node root, int value) {
    if (root == null) {
      return;
    }
    root.count--;
    int mid = root.start + (root.end - root.start) / 2;
    if (value <= mid) {
      modify(root.left, value);
    } else {
      modify(root.right, value);
    }
  }
}
