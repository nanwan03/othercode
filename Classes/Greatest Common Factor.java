public class Solution {
  public int gcf(int a, int b) {
    // Write your solution here.
    if (a == 0 || b == 0) {
      return a + b;
    }
    while (a != 0 && b != 0) {
      int c = b;
      b = a % b;
      a = c;
    }
    return a + b;
  }
}
