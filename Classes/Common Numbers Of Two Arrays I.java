public class Solution {
  public List<Integer> common(List<Integer> a, List<Integer> b) {
    // write your solution here
    List<Integer> rst = new ArrayList<Integer>();
    if (a == null || a.size() == 0 || b == null || b.size() == 0) {
      return rst;
    }
    List<Integer> setList = a.size() > b.size() ? a : b;
    List<Integer> traverseList = a.size() <= b.size() ? a : b;
    Collections.sort(traverseList);
    Set<Integer> set = new HashSet<Integer>();
    for (int i : setList) {
      set.add(i);
    }
    for (int i : traverseList) {
      if (!set.add(i)) {
        rst.add(i);
      }
    }
    return rst;
  }
}
