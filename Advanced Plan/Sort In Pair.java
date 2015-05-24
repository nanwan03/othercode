public class Solution {
  public void sortInPair(int[] array) {
    // Write your solution here.
    if (array == null || array.length <= 1) {
      return;
    }
    Arrays.sort(array);
    if (array.length % 2 == 0) {
      swapInPair(array, 1, array.length - 2);
    } else {
      swapInPair(array, 1, array.length - 1);
    }
  }
  private void swapInPair(int[] array, int left, int right) {
    for (int i = left; i < right; i = i + 2) {
      swap(array, left, left + 1);
    }
  }
  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}