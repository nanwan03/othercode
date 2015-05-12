public class Solution {
  public boolean exist(int[] a, int[] b, int[] c, int target) {
    for (int i : a) {
      boolean flag = existSum(b, c, target - i);
      if (flag) {
        return true;
      }
    }
    return false;
  }
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