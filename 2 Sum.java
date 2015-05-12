public class Solution {
  public boolean existSum(int[] array, int target) {
    if (array == null || array.length == 0) {
      return false;
    }
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < array.length; i++) {
      map.put(array[i], i);
    }
    for (int i = 0; i < array.length; i++) {
      if (map.containsKey(target - array[i]) && map.get(target - array[i]) != i) {
        return true;
      }
    }
    return false;
  }
}