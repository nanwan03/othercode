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
  private class ResultType {
	  int singlePath;
	  int maxPath;
	  ResultType(int singlePath, int maxPath) {
		  this.singlePath = singlePath;
		  this.maxPath = maxPath;
	  }
  }
  private ResultType helper(TreeNode root) {
	  if (root == null) {
		  return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
	  }
	  ResultType left = helper(root.left);
	  ResultType right = helper(root.right);
	  int singlePath = left.singlePath == Integer.MIN_VALUE && right.singlePath == Integer.MIN_VALUE ? root.key : Math.max(left.singlePath, right.singlePath) + root.key;
	  int maxPath = Math.max(Math.max(left.maxPath, right.maxPath), left.singlePath == Integer.MIN_VALUE || right.singlePath == Integer.MIN_VALUE ? Integer.MIN_VALUE : left.singlePath + right.singlePath + root.key);
	  return new ResultType(singlePath, maxPath);
  }
  public int maxPathSum(TreeNode root) {
    if (root == null) {
    	return Integer.MIN_VALUE;
    }
    return helper(root).maxPath;
  }
}