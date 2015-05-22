public class Solution {
  public long fibonacci(int K) {
    // Write your solution here.
    if (K <= 0) {
      return 0;
    }
    if (K <= 2) {
      return 1;
    }
    long temp1 = 1;
    long temp2 = 1;
    for (int i = 3; i <= K; i++) {
      if ((i & 0X01) == 1) {
        temp1 += temp2;
      } else {
        temp2 += temp1;
      }
    }
    return (K & 0X01) == 0 ? temp2 : temp1;
  }
}