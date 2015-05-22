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
  public ListNode reverseInPairs(ListNode head) {
    // write your solution here
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    head = dummy;
    while (head.next != null && head.next.next != null) {
      ListNode temp = head.next.next.next;
      head.next.next.next = head.next;
      head.next = head.next.next;
      head.next.next.next = temp;
      head = head.next.next;
    }
    return dummy.next;
  }
}