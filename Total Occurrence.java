public class Solution {
  public int totalOccurrence(int[] array, int target) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return 0;
    }
    int left = 0;
    int right = array.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        right = mid;
      } else if (array[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    int leftIndex = -1;
    if (array[left] == target) {
      leftIndex = left;
    } else if (array[right] == target) {
      leftIndex = right;
    } else {
      return 0;
    }
    left = 0;
    right = array.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        left = mid;
      } else if (array[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    int rightIndex = -1;
    if (array[right] == target) {
      rightIndex = right;
    } else if (array[left] == target) {
      rightIndex = left;
    } else {
      return 0;
    }
    return rightIndex - leftIndex + 1;
  }
}