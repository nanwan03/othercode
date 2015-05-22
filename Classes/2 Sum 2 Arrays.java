public class Solution {
  public boolean existSum(int[] a, int[] b, int target) {
    // write your solution here
    Set<Integer> set = new HashSet<Integer>();
    for (int i : a) {
      set.add(i);
    }
    for (int i : b) {
      if (set.contains(target - i)) {
        return true;
      }
    }
    return false;
  }
}