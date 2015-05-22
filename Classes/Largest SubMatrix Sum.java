public class Solution {
  public int largest(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
    	return 0;
    }
    int larget = Integer.MIN_VALUE;
    for (int i = 0; i < matrix.length; i++) {
    	int[] temp = new int[matrix[i].length];
    	Arrays.fill(temp, 0);
    	for (int j = i; j < matrix.length; j++) {
    		addMatrix(temp, matrix[j]);
    		larget = Math.max(larget, getMax(temp));
    	}
    }
    return larget;
  }
  private void addMatrix(int[] temp, int[] matrix) {
	  for (int i = 0; i < temp.length; i++) {
		  temp[i] += matrix[i];
	  }
  }
  private int getMax(int[] temp) {
	  int tempMax = Integer.MIN_VALUE;
	  int max = Integer.MIN_VALUE;
	  for (int i : temp) {
		  tempMax = Math.max(0, tempMax) + i;
		  max = Math.max(max, tempMax);
	  }
	  return max;
  }
}