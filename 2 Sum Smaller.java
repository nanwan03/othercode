public class Solution {
  public int smallerPairs(int[] array, int target) {
    // write your solution here
    if (array == null || array.length == 0) {
      return 0;
    }
    Arrays.sort(array);
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int count = 0;
    for (int i = 0; i < array.length && array[i] < target; i++) {
      if (target - array[i] <= array[i]) {
        break;
      }
      if (!map.containsKey(array[i])) {
        map.put(array[i], binarysearch(array, target - array[i]));
      }
      count = count + (map.get(array[i]) - i);
    }
    return count;
  }
  private int binarysearch(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        right = mid - 1;
      } else if (array[mid] < target) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    if (array[right] < target) {
      return right;
    } else {
      return left;
    }
  }
}