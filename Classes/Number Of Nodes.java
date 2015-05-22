/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public int numberOfNodes(ListNode head) {
    // write your solution here
    int length = 0;
    while (head != null) {
      length++;
      head = head.next;
    }
    return length;
  }
}