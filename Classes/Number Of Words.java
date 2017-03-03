public class Solution {
  public int numOfWords(String input) {
    // Write your solution here.
    if (input == null || input.length() == 0) {
      return 0;
    }
    input = input.trim();
    char[] chars = input.toCharArray();
    int count = 0;
    int index = 0;
    while (index < chars.length) {
      if ((chars[index] <= 'z' && chars[index] >= 'a')
          || (chars[index] <= 'Z' && chars[index] >= 'A')) {
        count++;
        while (index < chars.length &&
                ((chars[index] <= 'z' && chars[index] >= 'a') || (chars[index] <= 'Z' && chars[index] >= 'A'))) {
          index++;
        }
      } else {
        index++;
      }
    }
    return count;
  }
}
