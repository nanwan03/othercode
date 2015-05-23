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
  public int distance(TreeNode root, int k1, int k2) {
    // Write your solution here.
    TreeNode ancester = commonAncester(root, k1, k2);
    if (ancester == null) {
      return 0;
    }
    int dist1 = findDist(root, ancester.key);
    int dist2 = findDist(root, k1);
    int dist3 = findDist(root, k2);
    return (dist2 + dist3 - 2 * dist1);
  }
  public TreeNode commonAncester(TreeNode root, int k1, int k2) {
    if (root == null) {
      return null;
    }
    if (root.key == k1 || root.key == k2) {
      return root;
    }
    TreeNode left = commonAncester(root.left, k1, k2);
    TreeNode right = commonAncester(root.right, k1, k2);
    if (left != null && right != null) {
      return root;
    } else {
      return left == null ? right : left;
    }
  }
  public int findDist(TreeNode root, int k) {
    if (root == null) {
      return -1;
    }
    if (root.left == null && root.right == null && root.key != k) {
      return -1;
    }
    if (root.key == k) {
      return 0;
    }
    int left = findDist(root.left, k);
    if (left != -1) {
      return 1 + left;
    }
    int right = findDist(root.right, k);
    if (right != -1) {
      return 1 + right;
    }
    return -1;
  }
}