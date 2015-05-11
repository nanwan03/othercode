public class Solution {
  public int[] kSmallest(int[] array, int k) {
    // Write your solution here
    if (array == null || array.length == 0 || k == 0) {
      return new int[0];
    }
    Queue<Integer> heap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
    for (int i = 0; i < array.length; i++) {
      if (i < k) {
        heap.offer(array[i]);
      } else {
        if (array[i] < heap.peek()) {
          heap.poll();
          heap.offer(array[i]);
        }
      }
    }
    int[] rst = new int[heap.size()];
    for (int i = rst.length - 1; i >= 0; i--) {
      rst[i] = heap.poll();
    }
    return rst;
  }
}