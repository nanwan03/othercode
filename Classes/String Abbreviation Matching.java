public class Solution {
  public boolean match(String input, String pattern) {
    // Write your solution here.
    if (pattern == null || pattern.length() == 0) {
      return true;
    }
    int inputIndex = 0;
    for (int i = 0; i < pattern.length(); i++) {
      if (Character.isLetter(pattern.charAt(i))) {
        if (input.charAt(inputIndex) != pattern.charAt(i)) {
          return false;
        }
        inputIndex++;
      } else {
        int num = pattern.charAt(i) - '0';
        while (i + 1 < pattern.length() && Character.isDigit(pattern.charAt(i + 1))) {
          num = num * 10 + (pattern.charAt(i + 1) - '0');
          i++;
        }
        while (num != 0) {
          inputIndex++;
          num--;
        }
      }
    }
    return inputIndex == input.length();
  }
}