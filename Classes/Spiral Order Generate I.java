public class Solution {
  public int[][] spiralGenerate(int n) {
    // Write your solution here.
    int[][] rst = new int[n][n];
    if (n == 0) {
      return rst;
    }
    int left = 0;
    int right = n - 1;
    int top = 0;
    int bottom = n - 1;
    traverseTopRight(rst, left, right, top, bottom, 1);
    return rst;
  }
  private void traverseTopRight(int[][] rst, int left, int right, int top, int bottom, int k) {
     for (int i = left; i <= right; ++i) {
      rst[top][i] = k++;
    }
    for (int i = top + 1; i <= bottom; ++i) {
      rst[i][right] = k++;
    }
    if (right > left && bottom > top) {
      traverseBottomLeft(rst, left, right - 1, top + 1, bottom, k);
    }
  }
  private void traverseBottomLeft(int[][] rst, int left, int right, int top, int bottom, int k) {
    for (int i = right; i >= left; --i) {
        rst[bottom][i] = k++;
    }
    for (int i = bottom - 1; i >= top; --i) {
        rst[i][left] = k++;
    }
    if (right > left && bottom > top) {
      traverseTopRight(rst, left + 1, right, top, bottom - 1, k);
    }
  }
}
