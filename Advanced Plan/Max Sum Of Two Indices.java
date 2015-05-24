public class Solution {
  public int[] maxSum(int[] array) {
    // Write your solution here.
    if (array == null || array.length <= 1) {
      return new int[0];
    }
    if (array.length == 2) {
      return new int[]{0, 1};
    }
    int max = 0;
    int maxIndex = 0;
    for (int i = 0; i < array.length; ++i) {
      if (array[i] > max) {
        max = array[i];
        maxIndex = i;
      }
    }
    int maxSum = 0;
    int secondIndex = 0;
    for (int i = 0; i < array.length; ++i) {
      int temp = array[i] + max + (maxIndex >= i ? (maxIndex - i) : (i - maxIndex));
      if (temp > maxSum) {
        maxSum = temp;
        secondIndex = i;
      }
    }
    int[] rst = new int[2];
    rst[0] = Math.min(secondIndex, maxIndex);
    rst[1] = Math.max(secondIndex, maxIndex);
    return rst;
  }
}