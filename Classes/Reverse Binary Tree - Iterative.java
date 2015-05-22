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
  public TreeNode reverse(TreeNode root) {
    if (root == null || root.left == null) {
    	return root;
    }
    TreeNode prev = null;
    TreeNode prevRight = null;
    while (root != null) {
    	TreeNode next = root.left;
    	TreeNode right = root.right;
    	root.left = prev;
    	root.right = prevRight;
    	prev = root;
    	prevRight = right;
    	root = next;
    }
    return prev;
  }
}