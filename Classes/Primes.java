
public class Solution {
  public List<Integer> primes(int target) {
    // Write your solution here.
    List<Integer> rst = new ArrayList<Integer>();
    for (int i = 2; i <= target; ++i) {
      if (isPrime(i)) {
        rst.add(i);
      }
    }
    return rst;
  }
  private boolean isPrime(int target) {
    List<Integer> rst = new ArrayList<Integer>();
    for (int i = 2; i <= target; ++i) {
      while (target % i == 0) {
        rst.add(i);
        target /= i;
      }
    }
    return rst.size() == 1;
  }
}
