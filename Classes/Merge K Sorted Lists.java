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
  public ListNode merge(List<ListNode> listOfLists) {
    // write your solution here
    if (listOfLists == null || listOfLists.size() == 0) {
      return null;
    }
    int end = listOfLists.size();
    while (end > 1) {
      int mid = (end + 1) / 2;
      for (int i = 0; i < end / 2; i++) {
        listOfLists.set(i, merge(listOfLists.get(i), listOfLists.get(mid + i)));
      }
      end = mid;
    }
    return listOfLists.get(0);
  }
  private ListNode merge(ListNode left, ListNode right) {
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    while (left != null && right != null) {
      if (left.value < right.value) {
        tail.next = left;
        left = left.next;
      } else {
        tail.next = right;
        right = right.next;
      }
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