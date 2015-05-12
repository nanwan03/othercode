public class Solution {
  public List<Integer> majority(int[] array, int k) {
    // write your solution here
    List<Integer> rst = new ArrayList<Integer>();
    int expect = array.length / k;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i : array) {
      if (map.containsKey(i)) {
        map.put(i, map.get(i) + 1);
      } else {
          map.put(i, 1);
        }
    }
    for (int i : map.keySet()) {
      if (map.get(i) > expect) {
        rst.add(i);
      }
    }
    return rst;
  }
}