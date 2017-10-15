public class Solution {
  public int[] interleave(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return array;
    }
    int next = -1;
    for (int i = 0; i < array.length; ++i) {
      if ((i % 2 == 0 && array[i] < 0) || (i % 2 == 1 && array[i] > 0)) {
        next = Math.max(next, i + 1);
        for (; next < array.length; ++next) {
          if (array[next] * array[i] < 0) {
            break;
          }
        }
        if (next < array.length) {
          rightShift(array, i++, next++);
        }
      }
    }
    return array;
  }
  private void rightShift(int[] array, int left, int right) {
    int temp = array[right];
    for (int i = right - 1; i >= left; --i) {
      array[i + 1] = array[i];
    }
    array[left] = temp;
  }
}
