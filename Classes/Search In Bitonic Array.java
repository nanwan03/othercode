public class Solution {
  public int search(int[] array, int target) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return -1;
    }
    int turningPointIndex = findMax(array, 0, array.length - 1);
    int left = binarySearch(array, 0, turningPointIndex, target);
    if (left != -1) {
      return left;
    }
    int right = binarySearchReverse(array, turningPointIndex, array.length - 1, target);
    return right;
  }
  private int findMax(int[] array, int left, int right) {
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (array[mid - 1] < array[mid] && array[mid + 1] < array[mid]) {
        return mid;
      } else if (array[mid - 1] < array[mid] && array[mid] < array[mid + 1]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    if (array[left] < array[right]) {
      return right;
    }
    return left;
  }
  private int binarySearch(int[] array, int left, int right, int target) {
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
    }
    return -1;
  }
  private int binarySearchReverse(int[] array, int left, int right, int target) {
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] < target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    if (array[left] == target) {
      return left;
    } else if (array[right] == target) {
      return right;
    }
    return -1;
  }
}