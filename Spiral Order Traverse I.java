public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    // write your solution here
    List<Integer> rst = new ArrayList<Integer>();
    if (matrix == null || matrix.length == 0) {
      return rst;
    }
    int row = matrix.length;
    int col = matrix[0].length;
    int left = 0;
    int right = col - 1;
    int top = 0;
    int bottom = row - 1;
    while (left < right && top < bottom) {
      for (int i = left; i < right; i++) {
        rst.add(matrix[top][i]);
      }
      for (int i = top; i < bottom; i++) {
        rst.add(matrix[i][right]);
      }
      for (int i = right; i > left; i--) {
        rst.add(matrix[bottom][i]);
      }
      for (int i = bottom; i > top; i--) {
        rst.add(matrix[i][left]);
      }
      left++;
      right--;
      top++;
      bottom--;
    }
    if (left > right || top > bottom) {
      return rst;
    }
    if (left == right) {
      for (int i = top; i <= bottom; i++) {
        rst.add(matrix[i][left]);
      }
    } else {
      for (int i = left; i <= right; i++) {
        rst.add(matrix[top][i]);
      }
    }
    return rst;
  }
}