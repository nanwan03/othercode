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
      DFS(root, a, b, 0);
      return (aLevel == bLevel) && (aParent != bParent);
    }
    private void DFS(TreeNode root, int a, int b, int currentLevel) {
      if (root == null) {
        return;
      }
      if ((root.left != null && root.left.key == a) || (root.right != null && root.right.key == a)) {
        aLevel = currentLevel + 1;
        aParent = root;
      }
      if ((root.left != null && root.left.key == b) || (root.right != null && root.right.key == b)) {
        bLevel = currentLevel + 1;
        bParent = root;
      }
      DFS(root.left, a, b, currentLevel + 1);
      DFS(root.right, a, b, currentLevel + 1);
    }
}