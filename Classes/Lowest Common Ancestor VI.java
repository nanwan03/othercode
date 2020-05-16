/**
* public class KnaryTreeNode {
 *     int key;
 *     List<KnaryTreeNode> children;
 *     public KnaryTreeNode(int key) {
 *         this.key = key;
 *         this.children = new ArrayList<>();
 *     }
 * }
 */
public class Solution {
  public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, List<KnaryTreeNode> nodes) {
    // Write your solution here
    Set<KnaryTreeNode> set = new HashSet<>(nodes);
    return helper(root, set);
  }
  private KnaryTreeNode helper(KnaryTreeNode root, Set<KnaryTreeNode> set) {
    if (root == null || set.contains(root)) {
      return root;
    }
    KnaryTreeNode found = null;
    for (KnaryTreeNode child : root.children) {
      KnaryTreeNode node = helper(child, set);
      if (node == null) {
        continue;
      }
      if (found == null) {
        found = node;
      } else {
        return root;
      }
    }
    return found;
  }
}