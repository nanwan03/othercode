public class Solution {
  public boolean allUnique(String word) {
    // write your solution here
    if (word == null || word.length() == 0) {
      return true;
    }
    int bitmask = 0;
    for (int i = 0; i < word.length(); i++) {
      char temp = word.charAt(i);
      if ((bitmask >> (temp % 32) & 1) != 0) {
        return false;
      }
      bitmask |= 1 << (temp % 32);
    }
    return true;
  }
}