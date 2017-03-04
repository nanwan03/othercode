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
  public ListNode reverseAlternate(ListNode head) {
    // Write your solution here.
    if (head == null || head.next == null) {
      return head;
    }
    ListNode oddDummy = new ListNode(0);
    ListNode oddHead = oddDummy;
    ListNode evenDummy = new ListNode(0);
    ListNode evenHead = evenDummy;
    int flag = 1;
    while (head != null) {
      if (flag == 1) {
        oddHead.next = head;
        oddHead = oddHead.next;
      } else {
        evenHead.next = head;
        evenHead = evenHead.next;
      }
      flag ^= 1;
      head = head.next;
    }
    evenHead.next = null;
    ListNode tail = reverse(evenDummy.next);
    oddHead.next = tail;
    return oddDummy.next;
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