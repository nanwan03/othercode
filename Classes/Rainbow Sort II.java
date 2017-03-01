public class Solution {
  public int[] rainbowSortII(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return array;
    }
    int start = 0;
    for (int i = 0; i <= 3; ++i) {
      start = sort(array, start, i);
    }
    return array;
  }
  private int sort(int[] array, int start, int target) {
    int left = start;
    int right = array.length - 1;
    int cur = left;
    while (cur <= right) {
      if (array[cur] < target) {
        swap(array, cur++, left++);
      } else if (array[cur] == target) {
        cur++;
      } else {
        swap(array, cur, right--);
      }
    }
    return left;
  }
  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}