
public class Solution {
  public int whiteObjects(int[][] matrix) {
    // write your solution here
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    int rst = 0;
    for (int i = 0; i < matrix.length; ++i) {
      for (int j = 0; j < matrix[i].length; ++j) {
        if (matrix[i][j] == 0) {
          rst++;
          mark(matrix, i, j);
        }
      }
    }
    return rst;
  }
  private void mark(int[][] matrix, int i, int j) {
    int row = matrix.length;
    int col = matrix[0].length;
    if (i < 0 || i >= row || j < 0 || j >= col || matrix[i][j] != 0) {
      return;
    }
    matrix[i][j] = 2;
    mark(matrix, i - 1, j);
    mark(matrix, i + 1, j);
    mark(matrix, i, j - 1);
    mark(matrix, i, j + 1);
  }
}
