public class Solution {
  public int largest(int[][] matrix) {
    // write your solution here
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    int row = matrix.length;
    int col = matrix[0].length;
    return merge(longestUpLeft(matrix, row, col), longestDownRight(matrix, row, col));
  }
  private int[][] longestUpLeft(int[][] matrix, int row, int col) {
    int[][] longestUp = new int[row][col];
    int[][] longestLeft = new int[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (matrix[i][j] == 1) {
          longestUp[i][j] = getNum(i - 1, j, longestUp) + 1;
          longestLeft[i][j] = getNum(i, j - 1, longestLeft) + 1;
        }
      }
    }
    merge(longestUp, longestLeft);
    return longestUp;
  }
  private int[][] longestDownRight(int[][] matrix, int row, int col) {
    int[][] longestDown = new int[row][col];
    int[][] longestRight = new int[row][col];
    for (int i = row - 1; i >= 0; i--) {
      for (int j = col - 1; j >= 0; j--) {
        if (matrix[i][j] == 1) {
          longestDown[i][j] = getNum(i + 1, j, longestDown) + 1;
          longestRight[i][j] = getNum(i, j + 1, longestRight) + 1;
        }
      }
    }
    merge(longestDown, longestRight);
    return longestDown;
  }
  private int getNum(int i, int j, int[][] longest) {
    if (i < 0 || i >= longest.length) {
      return 0;
    }
    if (j < 0 || j >= longest[0].length) {
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