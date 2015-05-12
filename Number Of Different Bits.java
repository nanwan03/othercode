public class Solution {
  public int diffBits(int a, int b) {
    // write your solution here
    int xor = a ^ b;
    int count = 0;
    while (xor != 0) {
      count += (xor & 1);
      xor >>>= 1;
    }
    return count;
  }
}