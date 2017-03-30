
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
  int aLevel = 0;
  int bLevel = 0;
  TreeNode aParent = null;
  TreeNode bParent = null;
  public boolean isCousin(TreeNode root, int a, int b) {
    // Write your solution here.
    if (root == null) {
      return false;
    }
    DFS(null, root, Math.min(a, b), Math.max(a, b), 0);
    return (aLevel == bLevel) && (aParent != bParent);
  }
  private void DFS(TreeNode parent, TreeNode root, int a, int b, int level) {
    if (root == null) {
      return;
    }
    if (root.key == a) {
      aLevel = level;
      aParent = parent;
    }
    if (root.key == b) {
      bLevel = level;
      bParent = parent;
    }
    DFS(root, root.left, a, b, level + 1);
    DFS(root, root.right, a, b, level + 1);
  }
}
