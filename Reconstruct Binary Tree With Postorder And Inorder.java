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
  public TreeNode reconstruct(int[] post, int[] in) {
    if (in.length != post.length) {
            return null;
    }
    return buildTree(in, 0, in.length - 1, post, 0, post.length - 1);
  }
  private TreeNode buildTree(int[] inorder, int inStart, int inEnd,
                                int[] postorder, int poStart, int poEnd) {
        if (inStart > inEnd || poStart > poEnd) {
            return null;
        }
        int k = findK(inorder, inStart, inEnd, postorder[poEnd]);
        if (k == -1) {
            return null;
        }
        TreeNode root = new TreeNode(inorder[k]);
        int leftLength = k - inStart;
        int rightLength = inEnd - k;
        TreeNode left = buildTree(inorder, inStart, k - 1, postorder, poStart, poStart + leftLength - 1);
        TreeNode right = buildTree(inorder, k + 1, inEnd, postorder, poEnd - rightLength, poEnd - 1);
        root.left = left;
        root.right = right;
        return root;
    }
    private int findK(int[] inorder, int start, int end, int val) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}