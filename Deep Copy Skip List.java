/**
 * class SkipListNode {
 *   public int value;
 *   public SkipListNode next;
 *   public SkipListNode forward;
 *   public SkipListNode(int value) {
 *     this.value = value;
 *   }
 * }
 */
public class Solution {
  public SkipListNode copy(SkipListNode head) {
    if (head == null) {
            return head;
        }
    copyNext(head);
    copyRandom(head);
    return splitList(head);
  }
  private void copyNext(SkipListNode head) {
    while (head != null) {
        SkipListNode newHead = new SkipListNode(head.value);
        newHead.next = head.next;
        head.next = newHead;
        head = head.next.next;
    }
  }
  private void copyRandom(SkipListNode head) {
    while (head != null) {
        if (head.forward != null) {
            head.next.forward = head.forward.next;
         }
        head = head.next.next;
    }
  }
  private SkipListNode splitList(SkipListNode head) {
    SkipListNode dummy = new SkipListNode(0);
    dummy.next = head.next;
    while (head != null) {
        SkipListNode newHead = head.next;
        head.next = head.next.next;
        head = head.next;
        if (newHead.next != null) {
             newHead.next = newHead.next.next;
        }
    }
    return dummy.next;
  }
}