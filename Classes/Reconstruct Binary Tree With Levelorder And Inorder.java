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
  public TreeNode reconstruct(int[] level, int[] in) {
    // write your solution here
    if (level == null ||  level.length == 0) {
      return null;
    }
    return buildTree(level, in, 0, in.length - 1);
  }
  private TreeNode buildTree(int[] level, int[] in, int inLeft, int inRight) {
    if (inLeft > inRight) {
      return null;
    }
    TreeNode root = new TreeNode(level[0]);
    if (inLeft == inRight) {
      return root;
    }
    int k = findK(in, inLeft, inRight, level[0]);
    if (k == -1) {
      return null;
    }
    int leftSize = k - inLeft;
    int rightSize = inRight - k;
    int[] left = new int[leftSize];
    int indexL = 0;
    int[] right = new int[rightSize];
    int indexR = 0;
    for (int j = 1; j < level.length; j++) {
	    	for (int i = inLeft; i < k; i++) {
		        if (level[j] == in[i]) {
		          left[indexL++] = level[j];
		        }
	      }
	    }
	    
	    for (int j = 1; j < level.length; j++) {
	    	for (int i = k + 1; i <= inRight; i++) {
		        if (level[j] == in[i]) {
		          right[indexR++] = level[j];
		        }
	      }
	    }
    root.left = buildTree(left, in, inLeft, k - 1);
    root.right = buildTree(right, in, k + 1, inRight);
    return root;
  }
  private int findK(int[] in, int inLeft, int inRight, int target) {
    for (int i = inLeft; i <= inRight; i++) {
      if (in[i] == target) {
        return i;
      }
    }
    return -1;
  }
}