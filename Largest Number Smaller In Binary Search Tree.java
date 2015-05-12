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
  public int largestSmaller(TreeNode root, int target) {
    if (root == null) {
    	return Integer.MIN_VALUE;
    }
    int rst = Integer.MIN_VALUE;
    while (root != null) {
    	if (root.key >= target) {
    		root = root.left;
    	} else {
    		rst = root.key;
    		root = root.right;
    	}
    }
    return rst;
  }
}