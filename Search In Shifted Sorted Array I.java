public class Solution {
  public int search(int[] array, int target) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return -1;
    }
    int left = 0;
    int right = array.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (array[left] < array[mid]) {
        if (array[left] <= target && target <= array[mid]) {
          right = mid;
        } else {
          left = mid;
        }
      } else {
        if (array[mid] <= target && target <= array[right]) {
          left = mid;
        } else {
          right = mid;
        }
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