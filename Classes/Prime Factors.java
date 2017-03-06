public class Solution {
  public List<Integer> factors(int target) {
    // Write your solution here.
    List<Integer> rst = new ArrayList<Integer>();
    for (int i = 2; i <= target; ++i) {
      while (target % i == 0) {
        rst.add(i);
        target = target / i;
      }
    }
    return rst;
  }
}
