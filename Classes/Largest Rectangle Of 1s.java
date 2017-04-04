
public class Solution {
  public int largest(int[][] matrix) {
    // write your solution here
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    int row = matrix.length;
    int col = matrix[0].length;
    int[] height = new int[col];
    int max = 0;
    for (int i = 0; i < row; ++i) {
      for (int j = 0; j < col; ++j) {
       if (matrix[i][j] == 0) {
         height[j] = 0;
       } else {
         height[j] = 1 + height[j];
       }
      }
      max = Math.max(max, getMax(height));
    }
    return max;
  }
  private int getMax(int[] height) {
    Stack<Integer> stack = new Stack<Integer>();
    int max = 0;
    for (int i = 0; i <= height.length; ++i) {
      int cur = i == height.length ? 0 : height[i];
      while (!stack.isEmpty() && cur <= height[stack.peek()]) {
        int h  = height[stack.pop()];
        int w = stack.isEmpty() ? i : i - stack.peek() - 1;
        max = Math.max(max, h * w);
      }
      stack.push(i);
    }
    return max;
  }
}
