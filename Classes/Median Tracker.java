public class Solution {
  private Queue<Integer> minHeap;
  private Queue<Integer> maxHeap;
  int count = 0;
  public Solution() {
    // add new fields and complete the constructor if necessary.
    minHeap = new PriorityQueue<Integer>();
    maxHeap = new PriorityQueue<Integer>(1000, Collections.reverseOrder());
    count = 0;
  }
  
  public int size() {
    return minHeap.size() + maxHeap.size();
  }
  public void read(int value) {
    // write your implementation here.
    count++;
    if (maxHeap.isEmpty() || value <= maxHeap.peek()) {
      maxHeap.offer(value);
    } else {
      minHeap.offer(value);
    }
    if (minHeap.size() > maxHeap.size()) {
      maxHeap.offer(minHeap.poll());
    }
    if (maxHeap.size() > minHeap.size() + 1) {
      minHeap.offer(maxHeap.poll());
    }
  }
  
  public Double median() {
    // write your implementation here.
    if (count == 0) {
      return null;
    }
    if (count % 2 == 0) {
      return (minHeap.peek() + maxHeap.peek()) / 2.0;
    } else {
      return (double)maxHeap.peek();
    }
  }
}