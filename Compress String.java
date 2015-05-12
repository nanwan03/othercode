public class Solution {
  public String compress(String input) {
    // write your solution here
    if (input == null || input.length() == 0) {
      return input;
    }
    char[] chars = input.toCharArray();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < chars.length; i++) {
      int count = 1;
      while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
        count++;
        i++;
      }
      sb.append(chars[i]);
      if (count > 1) {
        sb.append(count);
      }
    }
    return sb.toString();
  }
}