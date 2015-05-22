public class Solution {
  public String rightShift(String input, int n) {
    // Write your solution here.
	  if (input == null || input.length() == 0) {
		  return input;
	  }
	  n %= input.length();
	  char[] chars = input.toCharArray();
	  reverse(chars, 0, input.length() - 1);
	  reverse(chars, 0, n - 1);
	  reverse(chars, n, input.length() - 1);
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