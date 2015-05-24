public class Solution {
  public int longestBitonic(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return 0;
    }
    int[] lis = new int[array.length];
    int[] lds = new int[array.length];
    Arrays.fill(lis, 1);
    Arrays.fill(lds, 1);
    for (int i = 1; i < array.length; ++i) {
      for (int j = 0; j < i; ++j) {
        if (array[i] > array[j] && lis[i] < lis[j] + 1) {
          lis[i] = lis[j] + 1;
        }
      }
    }
    for (int i = array.length - 2; i >= 0; --i) {
      for (int j = array.length - 1; j > i; --j) {
        if (array[i] > array[j] && lds[i] < lds[j] + 1) {
          lds[i] = lds[j] + 1;
        }
      }
    }
    int max = lis[0] + lds[0] - 1;
    for (int i = 1; i < array.length; ++i) {
      max = Math.max(max, lis[i] + lds[i] - 1);
    }
    return max;
  }
}