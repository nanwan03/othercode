public class Solution {
  public List<Integer> common(int[] a, int[] b) {
    // write your solution here
    List<Integer> rst = new ArrayList<Integer>();
    if (a == null || a.length == 0 || b == null || b.length == 0) {
      return rst;
    }
    Set<Integer> set = new HashSet<Integer>();
    for (int i : a) {
      set.add(i);
    }
    for (int i : b) {
      if (!set.add(i)) {
        rst.add(i);
      }
    }
    return rst;
  }
}