public class Solution {
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int last = -1;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                last = Math.max(last, map.get(c));
            }
            map.put(c, i);
            max = Math.max(max, i - last);
        }
        return max;
  }
}