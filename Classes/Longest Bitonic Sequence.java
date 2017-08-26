
public class Solution {
  public int longestBitonic(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return 0;
    }
    int size = array.length;
    int[] left = new int[size];
    int[] right = new int[size];
    int[] dpL = new int[size];
    int[] dpR = new int[size];
    int rstL = 0;
    int rstR = 0;
    for (int i = 0; i < array.length; ++i) {
      int index = helper(dpL, 0, rstL, array[i]);
      dpL[index] = array[i];
      if (index == rstL) {
        rstL++;
      }
      left[i] = rstL;
      
      index = helper(dpR, 0, rstR, array[size - 1 - i]);
      dpR[index] = array[size - 1 - i];
      if (index == rstR) {
        rstR++;
      }
      right[size - 1 - i] = rstR;
    }
    int rst = 0;
    for (int i = 0; i < size; ++i) {
      rst = Math.max(rst, left[i] + right[i] - 1);
    }
    return rst;
  }
  private int helper(int[] array, int left, int right, int target) {
    if (right == 0) {
      return 0;
    }
    right--;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        right = mid;
      } else if (array[mid] < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    if (array[left] >= target) {
      return left;
    } else if (array[right] >= target) {
      return right;
    } else {
      return right + 1;
    }
  }
}
