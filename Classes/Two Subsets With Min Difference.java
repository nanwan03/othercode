public class Solution {
  public int minDifference(int[] array) {
    // Write your solution here.
    List<List<Integer>> rst = new ArrayList<List<Integer>>();
    if (array == null || array.length == 0) {
        return 0;
    }
    Arrays.sort(array);
    List<Integer> items = new ArrayList<Integer>();
    helper(rst, items, array, 0);
    int sum = 0;
    int min = Integer.MAX_VALUE;
    for (int i : array) {
      sum += i;
    }
    for (List<Integer> list : rst) {
      if (list.size() == array.length / 2) {
        int temp = 0;
        for (int i : list) {
          temp += i;
        }
        min = Math.min(min, Math.abs(temp - (sum - temp)));
      }
    }
    return min;
  }
  private void helper(List<List<Integer>> rst, List<Integer> items, int[] num, int pos) {
      rst.add(new ArrayList<Integer>(items));
      for (int i = pos; i < num.length; i++) {
          if (i > pos && num[i] == num[i - 1]) {
              continue;
          }
          items.add(num[i]);
          helper(rst, items, num, i + 1);
          items.remove(items.size() - 1);
      }
  }
}