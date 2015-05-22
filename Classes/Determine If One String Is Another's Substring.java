public class Solution {
  public int strstr(String large, String small) {
    // write your solution here
    if (small.length() == 0) {
      return 0;
    }
    for (int i = 0; i <= large.length() - small.length(); i++) {
      int j = 0;
      for (j = 0; j < small.length(); j++) {
        if (large.charAt(i + j) != small.charAt(j)) {
          break;
        }
      }
      if (j == small.length()) {
        return i;
      }
    }
    return -1;
  }
}