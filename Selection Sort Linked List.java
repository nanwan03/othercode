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
  public ListNode selectionSort(ListNode head) {
    if (head == null || head.next == null) {
    	return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    head = dummy;
    while (head != null) {
    	ListNode cur = head;
    	ListNode min = head;
    	while (cur != null && cur.next != null) {
    		if (cur.next.value < min.next.value) {
    			min = cur;
    		}
    		cur = cur.next;
    	}
    	if (min != head) {
    		ListNode temp = min.next;
    		min.next = temp.next;
    		temp.next = head.next;
    		head.next = temp;
    	}
    	head = head.next;
    }
    return dummy.next;
  }
}