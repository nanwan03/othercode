public class Solution {
  public int shiftPosition(int[] array) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return -1;
    }
    int left = 0;
    int right = array.length - 1;
    while (left + 1 < right && array[left] >= array[right]) {
      int mid = left + (right - left) / 2;
      if (array[left] < array[mid]) {
        left = mid + 1;
      } else if (array[mid] < array[right]) {
        right = mid;
      } else {
        left = mid;
      }
    }
    return array[left] < array[right] ? left : right;
  }
}