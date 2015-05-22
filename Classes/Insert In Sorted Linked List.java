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
  public ListNode insert(ListNode head, int value) {
    // write your solution here
    ListNode insert = new ListNode(value);
    if (head == null) {
      return insert;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    head = dummy;
    while (head.next != null && head.next.value < value) {
        head = head.next;
    }
    insert.next = head.next;
    head.next = insert;
    return dummy.next;
  }
}