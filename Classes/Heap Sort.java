public class Solution {
  public int[] heapsort(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return array;
    }
    int size = array.length;
    for (int i = size / 2 - 1; i >= 0; --i) {
      adjust(array, i, size);
    }
    for (int i = size - 1; i >= 0; --i) {
      swap(array, 0, i);
      size--;
      adjust(array, 0, size);
    }
    return array;
  }
  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
  private void adjust(int[] array, int i, int size) {
    while (i < size / 2) {
      int max = i;
      int left = i * 2 + 1;
      int right = i * 2 + 2;
      if (left < size && array[left] > array[max]) {
        max = left;
      }
      if (right < size && array[right] > array[max]) {
        max = right;
      }
      if (max == i) {
        return;
      }
      swap(array, i, max);
      i = max;
    }
  }
}
