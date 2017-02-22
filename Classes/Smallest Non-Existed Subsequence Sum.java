public class Solution {
  public int firstMissing(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return 1;
    }
    int sum = 0;
    for (int i : array) {
      if (sum < i - 1) {
        return i - 1;
      }
      sum += i;
    }
    return sum + 1;
  }
}