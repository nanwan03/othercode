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
    ListNode dummy = head;
    ListNode newNode = head.next;
    head.next = head.next.next;
    head = head.next;
    ListNode curNewNode = newNode;
    
    while (head != null && head.next != null) {
      newNode.next = head.next;
      newNode = newNode.next;
      
      head.next = head.next.next;
      head = head.next;
    }
    ListNode tail = findTail(dummy);
    newNode.next = null;
    
    ListNode anotherHead = reverse(curNewNode);
    tail.next = anotherHead;
    return dummy;
  }
  
  private ListNode findTail(ListNode head) {
	  while (head.next != null) {
		  head = head.next;
	  }
	  return head;
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