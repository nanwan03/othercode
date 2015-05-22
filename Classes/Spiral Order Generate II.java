public class Solution {
  public int[][] spiralGenerate(int m, int n) {
    int[][] rst = new int[m][n];
    if (m == 0 || n == 0) {
      return rst;
    }
    int left = 0;
    int right = n - 1;
    int top = 0;
    int bottom = m - 1;
    int k = 1;
    while (left < right && top < bottom) {
      for (int i = left; i < right; i++) {
        rst[top][i] = k++;
      }
      for (int i = top; i < bottom; i++) {
        rst[i][right] = k++;
      }
      for (int i = right; i > left; i--) {
        rst[bottom][i] = k++;
      }
      for (int i = bottom; i > top; i--) {
        rst[i][left] = k++;
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
        rst[i][left] = k++;
      }
    } else {
      for (int i = left; i <= right; i++) {
        rst[top][i] = k++;
      }
    }
    return rst;
  }
}