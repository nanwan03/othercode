public class Solution {
  List<Integer> allAnagrams(String s, String l) {
    // Write your solution here.
    List<Integer> rst = new ArrayList<Integer>();
    if (s == null || l == null || s.length() == 0 || l.length() == 0) {
      return rst;
    }
    int[] map = new int[256];
    for (char c : s.toCharArray()) {
      map[c]++;
    }
    int left = 0;
    int right = 0;
    int count = s.length();
    while (right < l.length()) {
      if (--map[l.charAt(right++)] >= 0) {
        count--;
      }
      if (count == 0) {
        rst.add(left);
      }
      if (right - left == s.length()) {
        if (++map[l.charAt(left++)] >= 1) {
          count++;
        }
      }
    }
    return rst;
  }
}
