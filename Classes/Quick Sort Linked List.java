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
  public ListNode quickSort(ListNode head) {
    // write your solution here
    if (head == null || head.next == null) {
      return head;
    }
    int length = getLength(head);
    Random r = new Random();
    int pivotIndex = r.nextInt(length);
    ListNode pivot = getPivot(head, pivotIndex);
    int val = pivot.value;
    ListNode lessDummy = new ListNode(0);
    ListNode lessTail = lessDummy;
    ListNode equalDummy = new ListNode(0);
    ListNode equalTail = equalDummy;
    ListNode greatDummy = new ListNode(0);
    ListNode greatTail = greatDummy;
    while (head != null) {
      if (head.value < val) {
        lessTail.next = head;
        lessTail = lessTail.next;
      } else if (head.value == val) {
        equalTail.next = head;
        equalTail = equalTail.next;
      } else {
        greatTail.next = head;
        greatTail = greatTail.next;
      }
      head = head.next;
    }
    lessTail.next = null;
    equalTail.next = null;
    greatTail.next = null;
    lessDummy.next = quickSort(lessDummy.next);
    greatDummy.next = quickSort(greatDummy.next);
    equalTail.next = greatDummy.next;
    if (lessDummy.next == null) {
      return equalDummy.next;
    } else {
      ListNode cur = lessDummy.next;
      while (cur.next != null) {
        cur = cur.next;
      }
      cur.next = equalDummy.next;
      return lessDummy.next;
    }
  }
  private int getLength(ListNode head) {
    int length = 0;
    while (head != null) {
      length++;
      head = head.next;
    }
    return length;
  }
  private ListNode getPivot(ListNode head, int pivotIndex) {
    int length = 0;
    while (length != pivotIndex) {
      head = head.next;
      length++;
    }
    return head;
  }
}