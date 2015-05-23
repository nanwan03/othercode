public class Solution {
  public int[] twoDiff(int[] array, int target) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return null;
    }
    int[] rst = new int[2];
    for (int i = 0; i < array.length; i++) {
      int index = -1;
      if (target >= 0) {
        index = binarySearch(array, i + 1, target + array[i]);
      } else {
        index = binarySearch(array, i + 1, array[i] - target);
      }
      if (index != -1) {
        rst[0] = target >= 0 ? i : index;
        rst[1] = target >= 0 ? index : i;
        return rst;
      }
    }
    return new int[0];
  }
  private int binarySearch(int[] array, int left, int target) {
    if (left >= array.length) {
      return -1;
    }
    int right = array.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    if (array[left] == target) {
      return left;
    } else if (array[right] == target) {
      return right;
    } else {
      return -1;
    }
  }
}