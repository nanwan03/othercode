public class Solution {
  public String reverseWords(String input) {
    // write your solution here
	  if (input == null) {
          return null;
      }
	  input = input.trim();
      if (input.length() <= 1) {
          return input;
      }
      input = reverse(input);
      String[] words = input.split("\\s+");
      String rst = words.length > 0? reverse(words[0]) : "";
      for (int i = 1; i < words.length; ++i) {
          rst += " " + reverse(words[i]);
      }
      return rst;
  }
  private String reverse(String s) {
      if (s == null) {
          return null;
      }
      char[] chars = s.toCharArray();
      for (int i = 0; i < chars.length / 2; ++i) {
          swap(chars, i, chars.length - 1 - i);
      }
      return new String(chars);
  }
  private void swap(char[] chars, int i, int j) {
      char c = chars[i];
      chars[i] = chars[j];
      chars[j] = c;
  }
}
