
public class Solution {
  public List<Integer> common(List<Integer> A, List<Integer> B) {
    //write your solution here
    List<Integer> rst = new ArrayList<Integer>();
    if (A == null || A.size() == 0 || B == null || B.size() == 0) {
      return rst;
    }
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i : A) {
      if (!map.containsKey(i)) {
        map.put(i, 1);
      } else {
        map.put(i, map.get(i) + 1);
      }
    }
    for (int i : B) {
      if (map.containsKey(i) && map.get(i) > 0) {
        rst.add(i);
        map.put(i, map.get(i) - 1);
      }
    }
    Collections.sort(rst);
    return rst;
  }
}
