public class Solution {
  public boolean allUnique(String word) {
    // write your solution here
    if (word == null || word.length() == 0) {
      return true;
    }
    int[] bitvec = new int[256 / 32];
    for (char c : word.toCharArray()) {
      if (((bitvec[c / 32] >> (c % 32)) & 1) == 1) {
        return false;
      }
      bitvec[c / 32] |= 1 << (c % 32);
    }
    return true;
  }
}