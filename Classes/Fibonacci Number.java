public class Solution {
  public long fibonacci(int K) {
    // Write your solution here
    if (K <= 1) {
      return Math.max(K, 0);
    }
    long k1 = 0L;
    long k2 = 1L;
    for (int i = 2; i <= K; ++i) {
      if ((i & 0x01) == 0) {
        k1 += k2;
      } else {
        k2 += k1;
      }
    }
    return (K & 0x01) == 0? k1 : k2;
  }
}
