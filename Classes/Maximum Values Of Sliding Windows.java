public class Solution {
  public List<Integer> maxWindows(int[] array, int k) {
    List<Integer> rst = new ArrayList<Integer>();
    if (array == null || array.length == 0) {
    	return rst;
    }
    Deque<Integer> deque = new LinkedList<Integer>();
    for (int i = 0; i < array.length; i++) {
    	while (!deque.isEmpty() && array[deque.peekFirst()] <= array[i]) {
    		deque.pollFirst();
    	}
    	deque.offerFirst(i);
    	while (!deque.isEmpty() && deque.peekLast() <= i - k) {
    		deque.pollLast();
    	}
    	if (i >= k - 1) {
    		rst.add(array[deque.peekLast()]);
    	}
    }
    return rst;
  }
}