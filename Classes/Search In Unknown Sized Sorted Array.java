/*
*  interface Dictionary {
*    public Integer get(int index);
*  }
*/

public class Solution {
  public int search(Dictionary dict, int target) {
    // Write your solution here
    if (dict == null) {
      return -1;
    }
    int left = 0;
    int right = 0;
    while (dict.get(right) != null && dict.get(right) < target) {
      left = right;
      right = right * 2 + 1;
    }
    if (dict.get(right) != null && dict.get(right) == target) {
      return right;
    }
    return binarySearch(dict, left, right, target);
  }
  private int binarySearch(Dictionary dict, int left, int right, int target) {
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (dict.get(mid) == null) {
        right = mid -1;
      } else if (dict.get(mid) == target) {
        return mid;
      } else if (dict.get(mid) < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    if (dict.get(left) != null && dict.get(left) == target) {
      return left;
    } else if (dict.get(right) != null && dict.get(right) == target) {
      return right;
    } else {
      return -1;
    }
  }
}