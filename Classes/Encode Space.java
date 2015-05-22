public class Solution {
  /*
  *  try to convert the string to char array,
  *  and do it in place.
  */
  public String encode(String input) {
    // write your solution here
    if (input == null || input.length() == 0) {
      return input;
    }
    StringBuilder sb = new StringBuilder();
    for (char c : input.toCharArray()) {
      if (c != ' ') {
        sb.append(c);
      } else {
        sb.append("20%");
      }
    }
    return sb.toString();
  }
}