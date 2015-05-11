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
  public ListNode partition(ListNode head, int target) {
    // write your solution here
    if (head == null || head.next == null) {
      return head;
    }
    ListNode leftDummy = new ListNode(0);
    ListNode leftTail = leftDummy;
    ListNode rightDummy = new ListNode(0);
    ListNode rightTail = rightDummy;
    while (head != null) {
      if (head.value < target) {
        leftTail.next = head;
        leftTail = leftTail.next;
      } else {
        rightTail.next = head;
        rightTail = rightTail.next;
      }
      head = head.next;
    }
    leftTail.next = rightDummy.next;
    rightTail.next = null;
    return leftDummy.next;
  }
}