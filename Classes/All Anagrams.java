public class Solution {
  private int getHash(int[] count) {
    int rst = 0;
    for (int i : count) {
      rst = rst * 31 + i;
    }
    return rst;
  }
  List<Integer> allAnagrams(String s, String l) {
    List<Integer> rst = new ArrayList<Integer>();
    if (s == null || s.length() == 0 || l == null || l.length() == 0) {
      return rst;
    }
    int[] count = new int[26];
    for (char c : s.toCharArray()) {
      count[c - 'a']++;
    }
    int hashCode = getHash(count);
    for (int i = 0; i <= l.length() - s.length(); i++) {
      int[] temp = new int[26];
      for (int j = 0; j < s.length(); j++) {
        temp[l.charAt(i + j) - 'a']++;
      }
      if (getHash(temp) == hashCode) {
        rst.add(i);
      }
    }
    return rst;
  }
}