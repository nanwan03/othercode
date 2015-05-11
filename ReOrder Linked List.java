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
  public ListNode reorder(ListNode head) {
    // write your solution here
    if (head == null || head.next == null) {
      return head;
    }
    ListNode mid = findMid(head);
    ListNode right = reverse(mid.next);
    mid.next = null;
    
    return merge(head, right);
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
  private ListNode merge(ListNode left, ListNode right) {
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    boolean flag = true;
    while (left != null && right != null) {
      if (flag) {
        tail.next = left;
        left = left.next;
      } else {
        tail.next = right;
        right = right.next;
      }
      flag ^= true;
      tail = tail.next;
    }
    if (left != null) {
      tail.next = left;
    } else {
      tail.next = right;
    }
    return dummy.next;
  }
}