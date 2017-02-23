/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public TreeNode reconstruct(int[] pre) {
    // write your solution here
    if (pre == null || pre.length == 0) {
      return null;
    }
    return buildBST(pre, 0, pre.length - 1);
  }
  private TreeNode buildBST(int[] pre, int left, int right) {
    if (left > right) {
      return null;
    }
    TreeNode root = new TreeNode(pre[left]);
    int nextLarger = findNext(pre, left + 1, right, pre[left]);
    root.left = buildBST(pre, left + 1, nextLarger - 1);
    root.right = buildBST(pre, nextLarger, right);
    return root;
  }
  private int findNext(int[] pre, int left, int right, int target) {
    while (left <= right && pre[left] <= target) {
      left++;
    }
    return left;
  }
}