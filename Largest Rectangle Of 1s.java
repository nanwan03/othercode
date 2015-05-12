public class Solution {
  public int largest(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
    	return 0;
    }
    int[][] height = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
    	for (int j = 0; j < matrix[0].length; j++) {
    	  if (matrix[i][j] == 0) {
    	    height[i][j] = 0;
    	  } else {
    			height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
    		}
    	}
    }
    int max = 0;
    for (int i = 0; i < matrix.length; i++) {
    	max = Math.max(max, getMax(height[i]));
    }
    return max;
  }
  private int getMax(int[] height) {
	  if (height == null || height.length == 0) {
		  return 0;
	  }
	  int max = 0;
	  Stack<Integer> stack = new Stack<Integer>();
	  for (int i = 0; i <= height.length; i++) {
		  int cur = i == height.length ? 0 : height[i];
		  while (!stack.isEmpty() && cur <= height[stack.peek()]) {
			  int h = height[stack.pop()];
			  int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			  max = Math.max(max, h * w);
		  }
		  stack.push(i);
	  }
	  return max;
  }
}