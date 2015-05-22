public class Solution {
  /*
  *  try to convert the string to char array,
  *  and do it in place.
  */
  public String deDup(String input) {
    // write your solution here
    if (input == null || input.length() == 0) {
      return input;
    }
    char[] chars = input.toCharArray();
    StringBuilder sb = new StringBuilder();
    sb.append(chars[0]);
    for (int i = 1; i < chars.length; i++) {
      if (chars[i] != chars[i - 1]) {
        sb.append(chars[i]);
      }
    }
    return sb.toString();
  } 
}