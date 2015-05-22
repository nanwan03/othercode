/**
 * public class TreeNodeP {
 *   public int key;
 *   public TreeNodeP left;
 *   public TreeNodeP right;
 *   public TreeNodeP parent;
 *   public TreeNodeP(int key, TreeNodeP parent) {
 *     this.key = key;
 *     this.parent = parent;
 *   }
 * }
 */
public class Solution {
  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    // write your solution here
    int length1 = getLength(one);
    int length2 = getLength(two);
    
    int diff = Math.abs(length1 - length2);
    while (diff != 0) {
      if (length1 > length2) {
        one = one.parent;
      } else {
        two = two.parent;
      }
      diff--;
    }
    while (one != null && two != null && one != two) {
      one = one.parent;
      two = two.parent;
    }
    return one;
  }
  private int getLength(TreeNodeP node) {
    int length = 0;
    while (node != null) {
      node = node.parent;
      length++;
    }
    return length;
  }
}