public class Solution {
  public int kth(int k) {
    // write your code here
        if (k < 4) {
            return k;
        }
        Queue<Integer> heap = new PriorityQueue<Integer>();
        heap.offer(2);
        heap.offer(3);
        Set<Integer> set = new HashSet<Integer>();
        set.add(2);
        set.add(3);
        k--;
        while (k > 1) {
            int cur = heap.poll();
            if (set.add(cur * 2)) {
                heap.offer(cur * 2);
            }
            if (set.add(cur * 3)) {
                heap.offer(cur * 3);
            } 
            k--;
        }
        return heap.peek();
  }
}