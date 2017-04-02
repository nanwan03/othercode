
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
    if (root == null) {
      return 0;
    }
    TreeNode ancestor = commonAncestor(root, k1, k2);
    if (ancestor == null) {
      return 0;
    }
    int dist = findDist(root, ancestor.key);
    int dist1 = findDist(root, k1);
    int dist2 = findDist(root, k2);
    return dist1 + dist2 - 2 * dist;
  }
  private TreeNode commonAncestor(TreeNode root, int k1, int k2) {
    if (root == null || root.key == k1 || root.key == k2) {
      return root;
    }
    TreeNode left = commonAncestor(root.left, k1, k2);
    TreeNode right = commonAncestor(root.right, k1, k2);
    if (left != null && right != null) {
      return root;
    }
    return left == null ? right : left;
  }
  private int findDist(TreeNode root, int key) {
    if (root == null) {
      return 0;
    }
    if(root.key == key) {
      return 1;
    }
    int left = findDist(root.left, key);
    int right = findDist(root.right, key);
    if (left != 0) {
      return 1 + left;
    }
    if (right != 0) {
      return 1 + right;
    }
    return 0;
  }
}
