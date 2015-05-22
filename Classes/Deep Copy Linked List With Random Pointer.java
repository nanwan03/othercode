/**
 * class RandomListNode {
 *   public int value;
 *   public RandomListNode next;
 *   public RandomListNode random;
 *   public RandomListNode(int value) {
 *     this.value = value;
 *   }
 * }
 */
public class Solution {
  public RandomListNode copy(RandomListNode head) {
    if (head == null) {
            return head;
        }
    copyNext(head);
    copyRandom(head);
    return splitList(head);
  }
  private void copyNext(RandomListNode head) {
    while (head != null) {
        RandomListNode newHead = new RandomListNode(head.value);
        newHead.next = head.next;
        head.next = newHead;
        head = head.next.next;
    }
  }
  private void copyRandom(RandomListNode head) {
    while (head != null) {
        if (head.random != null) {
            head.next.random = head.random.next;
         }
        head = head.next.next;
    }
  }
  private RandomListNode splitList(RandomListNode head) {
    RandomListNode dummy = new RandomListNode(0);
    dummy.next = head.next;
    while (head != null) {
        RandomListNode newHead = head.next;
        head.next = head.next.next;
        head = head.next;
        if (newHead.next != null) {
             newHead.next = newHead.next.next;
        }
    }
    return dummy.next;
  }
}