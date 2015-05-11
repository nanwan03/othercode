public class Solution {
  public List<List<Integer>> combinations(int target, int[] coins) {
    List<List<Integer>> rst = new ArrayList<List<Integer>>();
    if (coins == null || coins.length == 0) {
      return rst;
    }
    List<Integer> items = new ArrayList<Integer>();
    helper(rst, items, target, coins, 0);
    return rst;
  }
  private void helper(List<List<Integer>> rst, List<Integer> items, int target, int[] coins, int pos) {
    if (pos == coins.length - 1) {
      if (target % coins[pos] == 0) {
        int num = target / coins[pos];
        items.add(num);
        rst.add(new ArrayList<Integer>(items));
        items.remove(items.size() - 1);
      }
      return;
    }
    int maxNum = target / coins[pos];
    for (int i = 0; i <= maxNum; i++) {
      items.add(i);
      helper(rst, items, target - i * coins[pos], coins, pos + 1);
      items.remove(items.size() - 1);
    }
  }
}