public class Solution {
  public int[] search(int[][] matrix, int target) {
    // Write your solution here.
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return new int[] {-1, -1};
    }
    int row = matrix.length;
    int col = matrix[0].length;
    int left = 0;
    int right = row * col - 1;
    while (left + 1 < right) {
      int mid = (right - left) / 2 + left;
      if (matrix[mid / col][mid % col] == target) {
        return new int[]{mid / col, mid % col};
      } else if (matrix[mid / col][mid % col] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    if (matrix[left / col][left % col] == target) {
      return new int[]{left / col, left % col};
    } else if (matrix[right / col][right % col] == target) {
      return new int[]{right / col, right % col};
    } else {
      return new int[]{-1, -1};
    }
  }
}
