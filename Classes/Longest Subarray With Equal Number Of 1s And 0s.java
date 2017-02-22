public class Solution {
  public int longest(int[] array) {
    // Write your solution here.
    if (array == null || array.length == 0) {
      return 0;
    }
    int num0 = 0;
    int num1 = 0;
    int rst = 0;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < array.length; i++) {
      num0 += array[i] == 0 ? 1 : 0;
      num1 += array[i] == 1 ? 1 : 0;
      int diff = num0 - num1;
      if (diff == 0) {
        rst = Math.max(rst, i + 1);
      } else {
        if (!map.containsKey(diff)) {
          map.put(diff, i);
        } else {
          rst = Math.max(rst, i - map.get(diff));
        }
      }
    }
    return rst;
  }
}