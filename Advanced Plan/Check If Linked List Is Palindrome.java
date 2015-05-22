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
  public boolean isPalindrome(ListNode head) {
    // Write your solution here.
    if (head == null || head.next == null) {
      return true;
    }
    ListNode mid = findMid(head);
    ListNode tail = reverse(mid.next);
    mid.next = null;
    while (head != null && tail != null) {
      if (head.value != tail.value) {
        return false;
      }
      head = head.next;
      tail = tail.next;
    }
    return true;
  }
  private ListNode findMid(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
  private ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode cur = head;
    ListNode prev = null;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }
}