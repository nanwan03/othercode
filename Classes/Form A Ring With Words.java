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
    List<String> items = new ArrayList<String>();
    return helper(items, deque, input.length);
  }
  private boolean helper(List<String> items, Deque<String> deque, int size) {
    if (items.size() == size) {
      return items.get(0).charAt(0) == items.get(size - 1).charAt(items.get(size - 1).length() - 1);
    }
    int length = deque.size();
    for (int i = 0; i < length; ++i) {
      String str = deque.pollFirst();
      if (items.isEmpty() || items.get(items.size() - 1).charAt(items.get(items.size() - 1).length() - 1) == str.charAt(0)) {
        items.add(str);
        if (helper(items, deque, size)) {
          return true;
        }
        items.remove(items.size() - 1);
      }
      deque.offerLast(str);
    }
    return false;
  }
}
