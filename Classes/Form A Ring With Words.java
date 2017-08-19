public class Solution {
  public boolean formRing(String[] input) {
    // Write your solution here.
    if (input == null || input.length == 0) {
      return false;
    }
    Deque<String> deque = new LinkedList<String>();
    for (String str : input) {
      deque.offerFirst(str);
    }
    return helper(deque, "", "", 0, input.length);
  }
  private boolean helper(Deque<String> deque, String head, String prev, int size, int total) {
    if (size == total) {
      return prev.charAt(prev.length() - 1) == head.charAt(0);
    }
    for (int i = 0; i < deque.size(); ++i) {
      String str = deque.pollFirst();
      if (size == 0 || prev.charAt(prev.length() - 1) == str.charAt(0)) {
        if (helper(deque, size == 0 ? str : head, str, size + 1,total)) {
          return true;
        }
      }
      deque.offerLast(str);
    }
    return false;
  }
}
