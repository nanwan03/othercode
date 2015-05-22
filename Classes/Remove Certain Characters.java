public class Solution {
  public String remove(String input, String t) {
    // Write your solution here.
    if (input == null || input.length() == 0 || t == null || t.length() == 0) {
      return input;
    }
    Set<Character> set = new HashSet<Character>();
    for (char c : t.toCharArray()) {
      set.add(c);
    }
    StringBuilder sb = new StringBuilder();
    for (char c : input.toCharArray()) {
      if (!set.contains(c)) {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}