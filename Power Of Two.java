public class Solution {
  public boolean isPowerOfTwo(int number) {
    // write your solution here
    if (number <= 0) {
      return false;
    }
    
    return (number & (number - 1)) == 0;
  }
}