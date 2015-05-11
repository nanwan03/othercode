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
  public boolean hasCycle(ListNode head) {
    // write your solution here
    if (head == null || head.next == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head;
    do {
      if (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      } else {
        return false;
      }
    } while (fast != slow);
    return true;
  }
}