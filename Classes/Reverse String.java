public class Solution {
  public String reverse(String input) {
    // Write your solution here.
    if (input == null || input.length() <= 1) {
      return input;
    }
    char[] c = input.toCharArray();
    reverse(c);
    return new String(c);
  }
  private void reverse(char[] chars) {
    int left = 0;
    int right = chars.length - 1;
    while (left < right) {
      swap(chars, left++, right--);
    }
  }
  private void swap(char[] chars, int i, int j) {
    char c = chars[i];
    chars[i] = chars[j];
    chars[j] = c;
  }
}