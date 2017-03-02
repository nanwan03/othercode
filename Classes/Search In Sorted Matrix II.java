public class Solution {
  public int[] search(int[][] matrix, int target) {
    // Write your solution here.
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{-1, -1};
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int rIndex = 0;
        int cIndex = col - 1;
        while (rIndex < row && cIndex >= 0) {
            int tmp = matrix[rIndex][cIndex];
            if (tmp == target) {
                return new int[]{rIndex, cIndex};
            } else if (tmp < target) {
                rIndex++;
            } else {
                cIndex--;
            }
        }
        return new int[]{-1, -1};
  }
}
