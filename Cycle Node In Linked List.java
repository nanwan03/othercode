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
  public ListNode cycleNode(ListNode head) {
    if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        do {
            if (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            } else {
                return null;
            }
        } while (fast != slow) ;
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
  }
}