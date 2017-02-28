public class Solution {
  public boolean isomorphic(String s, String t) {
    // Write your solution here.
    if (s.length() != t.length()) {
      return false;
    }
    int[] map = new int[26];
    boolean[] isused = new boolean[26];
    Arrays.fill(map, -1);
    for (int i = 0; i < s.length(); ++i) {
      char sch = s.charAt(i);
      char tch = t.charAt(i);
      if (map[sch - 'a'] == -1) {
        if (isused[tch - 'a']) {
          return false;
        }
        map[sch - 'a'] = tch - 'a';
        isused[tch - 'a'] = true;
      } else {
        if (map[sch - 'a'] != tch - 'a') {
          return false;
        }
      }
    }
    return true;
  }
}
