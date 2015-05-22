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
  public TreeNode reconstruct(int[] level) {
    // write your solution here
    if (level == null || level.length == 0) {
      return null;
    }
    TreeNode root = new TreeNode(level[0]);
    List<Integer> left = new ArrayList<Integer>();
    List<Integer> right = new ArrayList<Integer>();
    for (int i = 1; i < level.length; i++) {
      if (level[i] < level[0]) {
        left.add(level[i]);
      } else {
        right.add(level[i]);
      }
    }
    int[] leftA = new int[left.size()];
    for (int i = 0; i < left.size(); i++) {
      leftA[i] = left.get(i);
    }
    int[] rightA = new int[right.size()];
    for (int i = 0; i < right.size(); i++) {
      rightA[i] = right.get(i);
    }
    root.left = reconstruct(leftA);
    root.right = reconstruct(rightA);
    return root;
  }
}