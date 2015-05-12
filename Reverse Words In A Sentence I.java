public class Solution {
  /*
  *  try to convert the string to char array,
  *  and do it in place.
  */
  public String reverseWords(String input) {
    // write your solution here
    if (input == null || input.length() == 0) {
      return input;
    }
    input = input.trim();
    if (input.length() == 0) {
      return input;
    }
    char[] chars = input.toCharArray();
    reverse(chars, 0, chars.length - 1);
    int left = 0;
    for (int i = 0; i < chars.length; i++) {
      while (i < chars.length && chars[i] != ' ') {
        i++;
      }
      reverse(chars, left, i - 1);
      left = i + 1;
      while (left < chars.length && chars[left] ==' ') {
        left++;
      }
    }
    return new String(chars);
  }
  private void reverse(char[] chars, int left, int right) {
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