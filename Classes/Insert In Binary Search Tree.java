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
  public TreeNode insert(TreeNode root, int key) {
    if (root == null) {
      return new TreeNode(key);
    }
    TreeNode prev = null;
    TreeNode cur = root;
    while (cur != null) {
      prev = cur;
      if (cur.key == key) {
        return root;
      } else if (cur.key < key) {
        cur = cur.right;
      } else {
        cur = cur.left;
      }
    }
    if (prev != null) {
      if (prev.key < key) {
        prev.right = new TreeNode(key);
      } else {
        prev.left = new TreeNode(key);
      }
    }
    return root;
    
  }
}