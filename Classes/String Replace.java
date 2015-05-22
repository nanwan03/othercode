public class Solution {
  public String replace(String input, String s, String t) {
    if (input == null || input.length() == 0) {
      return input;
    }
    input = "#" + input + "#";
    String[] strs = input.split(s);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < strs.length; i++) {
      String str = strs[i];
      sb.append(str);
      if (i < strs.length - 1) {
    	  sb.append(t);
      }
    }
    sb.deleteCharAt(0);
    sb.deleteCharAt(sb.length()-1);
    String rst = sb.toString().substring(1);
    return sb.toString();
  }
}