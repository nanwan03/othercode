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
  public TreeNode reconstruct(int[] post) {
    // write your solution here
    if (post == null || post.length == 0) {
      return null;
    }
    return buildBST(post, 0, post.length - 1);
  }
  private TreeNode buildBST(int[] post, int left, int right) {
    if (left > right) {
      return null;
    }
    TreeNode root = new TreeNode(post[right]);
    int nextSmaller = findNext(post, left, right - 1, post[right]);
    root.left = buildBST(post, left, nextSmaller);
    root.right = buildBST(post, nextSmaller + 1, right - 1);
    return root;
  }
  private int findNext(int[] post, int left, int right, int target) {
    int cur = right;
    for (;cur >= left; cur--) {
      if (post[cur] < target) {
        return cur;
      }
    }
    return cur;
  }
}