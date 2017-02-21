public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    // Write your solution here.
    List<Integer> rst = new ArrayList<Integer>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return rst;
    }
    int row = matrix.length;
    int col = matrix[0].length;
    int left = 0;
    int right = col - 1;
    int top = 0;
    int bottom = row - 1;
    traverseTopRight(rst, matrix, left, right, top, bottom);
    return rst;
  }
  private void traverseTopRight(List<Integer> rst, int[][] matrix, int left, int right, int top, int bottom) {
    for (int i = left; i <= right; ++i) {
      rst.add(matrix[top][i]);
    }
    for (int i = top + 1; i <= bottom; ++i) {
      rst.add(matrix[i][right]);
    }
    if (right > left && bottom > top) {
      traverseBottomLeft(rst, matrix, left, right - 1, top + 1, bottom);
    }
  }
  private void traverseBottomLeft(List<Integer> rst, int[][] matrix, int left, int right, int top, int bottom) {
    for (int i = right; i >= left; --i) {
        rst.add(matrix[bottom][i]);
    }
    for (int i = bottom - 1; i >= top; --i) {
      rst.add(matrix[i][left]);
    }
    if (right > left && bottom > top) {
      traverseTopRight(rst, matrix, left + 1, right, top, bottom - 1);
    }
  }
}
