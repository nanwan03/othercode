public class Solution {
  public long power(int a, int b) {
    // Write your solution here
    if (b == 0) {
      return 1;
    }
    int k = b / 2;
    long t1 = power(a, k);
    long t2 = ((b & 0x01) == 1) ? (long)a : (long)1;
    return t1 * t1 * t2;
  }
}