public class Solution {
  public int majority(int[] array) {
    // write your solution here
    int count = 0;
    int candidate = 0;
    for (int i : array) {
      if (count == 0) {
        count = 1;
        candidate = i;
      } else if (candidate == i) {
        count++;
      } else {
        count--;
      }
    }
    return candidate;
  }
}