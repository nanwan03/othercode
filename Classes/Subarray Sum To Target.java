public class Solution {
  public boolean sumToTarget(int[] array, int target) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return false;
    }
    Set<Integer> set = new HashSet<Integer>();
    int sum = 0;
    for (int i : array) {
      sum += i;
      if (sum == target) {
        return true;
      } else {
        if (set.contains(sum - target)) {
          return true;
        }
        set.add(sum);
      }
    }
    return false;
  }
}