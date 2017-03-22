public class Solution {
  public int minDifference(int[] array) {
    // Write your solution here.
    int sum = 0;
    for (int i : array) {
      sum += i;
    }
    Arrays.sort(array);
    return helper(array, sum, 0, 0, 0);
  }
  private int helper(int[] array, int sum, int partialSum, int index, int size) {
    if (size == array.length / 2) {
      return Math.abs(partialSum - (sum - partialSum));
    }
    int min = Integer.MAX_VALUE;
    for (int i = index; i < array.length; ++i) {
      if (i > index && array[i] == array[i - 1]) {
        continue;
      }
      partialSum += array[i];
      size++;
      min = Math.min(min, helper(array, sum, partialSum, i + 1, size));
      size--;
      partialSum -= array[i];
    }
    return min;
  }
}
