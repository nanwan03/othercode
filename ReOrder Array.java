public class Solution {
  public int[] reorder(int[] array) {
    if (array == null || array.length == 0) {
      return array;
    }
    int size = array.length;
    if (size % 2 == 0) {
      reorder(array, 0, size - 1);
    } else {
      reorder(array, 0, size - 2);
    }
    return array;
  }
  private void reorder(int[] array, int left, int right) {
    int length = right - left + 1;
    if (length <= 2) {
      return;
    }
    int leftLength = length / 4 * 2;
    int leftMid = left + length / 4;
    int leftEnd = left + leftLength - 1;
    rightShift(array, leftMid, leftMid + length / 2 - 1, length / 4);
    reorder(array, left, leftEnd);
    reorder(array, leftEnd + 1, right);
  }
  private void rightShift(int[] array, int left, int right, int shift) {
    reverse(array, right - shift + 1, right);
    reverse(array, left, right - shift);
    reverse(array, left, right);
  }
  private void reverse(int[] array, int left, int right) {
    while (left < right) {
      swap(array, left++, right--);
    }
  }
  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}