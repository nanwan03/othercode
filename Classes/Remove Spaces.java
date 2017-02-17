public class Solution {
  public String removeSpaces(String input) {
    // Write your solution here.
    if (input == null || input.length() == 0) {
      return input;
    }
    input = input.trim();
    if (input.length() == 0) {
      return input;
    }
    String[] strs = input.split("\\s+");
    StringBuilder sb = new StringBuilder();
    for (String str : strs) {
      sb.append(str);
      sb.append(" ");
    }
    sb.setLength(sb.length() - 1);
    return sb.toString();
  }
}