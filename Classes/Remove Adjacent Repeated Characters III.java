public class Solution {
  /*
  *  try to convert the string to char array,
  *  and do it in place.
  */
  public String deDup(String input) {
    // write your solution here
    if (input == null || input.length() < 2) {
      return input;
    }
    StringBuilder sb = new StringBuilder();
    char[] chars = input.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      int count = 1;
      while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
        count++;
        i++;
      }
      if (count == 1) {
        sb.append(chars[i]);
      }
    }
    return sb.toString();
  }
}