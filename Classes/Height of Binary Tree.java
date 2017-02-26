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
   public int findHeight(TreeNode root) {
     if (root == null) {
       return 0;
     }
     if (root.left == null && root.right == null) {
       return 1;
     }
     return 1 + Math.max(findHeight(root.left), findHeight(root.right));
   }
}
