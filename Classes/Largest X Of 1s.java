public class Solution {
  public int largest(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
    	return 0;
    }
    int row = matrix.length;
    int col = matrix[0].length;
    return merge(longestLeftUp(matrix, row, col), longestDownRight(matrix, row, col));
  }
  private int[][] longestLeftUp(int[][] matrix, int row, int col) {
	  int[][] longestLeft = new int[row][col];
	  int[][] longestUp = new int[row][col];
	  for (int sum = 0; sum <= row + col - 2; sum++) {
		  for (int i = Math.min(sum, row - 1); i >= Math.max(0, sum - col + 1); i--) {
			  int j = sum - i;
			  if (matrix[i][j] == 1) {
				  longestLeft[i][j] = getNum(i - 1, j - 1, longestLeft) + 1;
				  longestUp[i][j] = getNum(i + 1, j - 1, longestUp) + 1;
			  }
		  }
	  }
	  merge(longestLeft, longestUp);
	  return longestLeft;
  }
  private int[][] longestDownRight(int[][] matrix, int row, int col) {
	  int[][] longestDown = new int[row][col];
	  int[][] longestRight = new int[row][col];
	  for (int sum = row + col - 2; sum >= 0; sum--) {
		  for (int i = Math.max(0, sum - col + 1); i <= Math.min(sum, row - 1); i++) {
			  int j = sum - i;
			  if (matrix[i][j] == 1) {
				  longestDown[i][j] = getNum(i - 1, j + 1, longestDown) + 1;
				  longestRight[i][j] = getNum(i + 1, j + 1, longestRight) + 1;
			  }
		  }
	  }
	  merge(longestDown, longestRight);
	  return longestDown;
  }
  private int getNum(int i, int j, int[][] longest) {
	  if (i < 0 || i >= longest.length || j < 0 || j >= longest[0].length) {
		  return 0;
	  }
	  return longest[i][j];
  }
  private int merge(int[][] matrix1, int[][] matrix2) {
	  int rst = 0;
	  for (int i = 0; i < matrix1.length; i++) {
		  for (int j = 0; j < matrix1[0].length; j++) {
			  matrix1[i][j] = Math.min(matrix1[i][j], matrix2[i][j]);
			  rst = Math.max(rst, matrix1[i][j]);
		  }
	  }
	  return rst;
  }
}