public class Solution {
  public int largest(int[] array) {
    // write your solution here
    if (array == null || array.length == 0) {
      return 0;
    }
    Stack<Integer> stack = new Stack<Integer>();
    int max = 0;
    for (int i = 0; i <= array.length; i++) {
      int cur = i == array.length ? 0 : array[i];
      while (!stack.isEmpty() && cur <= array[stack.peek()]) {
        int h = array[stack.pop()];
        int w = stack.isEmpty() ? i : i - stack.peek() - 1;
        max = Math.max(max, h * w);
      }
      stack.push(i);
    }
    return max;
  }
}