public class Solution {
  public String decompress(String input) {
     // write your solution here
    if (input == null || input.length() == 0) {
      return input;
    }
    char[] chars = input.toCharArray();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      if (Character.isLetter(c)) {
        if (i < chars.length - 1) {
          char forward = chars[i + 1];
          if (Character.isLetter(forward)) {
            sb.append(c);
          } else if (Character.isDigit(forward)) {
            int temp = (int)(forward - '0');
            while (temp > 0) {
              sb.append(c);
              temp--;
            }
          }
        } else {
          sb.append(c);
        }
      }
    }
    return sb.toString();
  }
}