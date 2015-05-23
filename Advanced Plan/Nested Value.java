public class Solution {
  public int value(String input) {
    // Write your solution here
    if (input == null ||  input.length() == 0) {
      return 0;
    }
    int weight = 0;
    int rst = 0;
    for (char c : input.toCharArray()) {
      if (c == '{') {
        weight++;
      } else if (c == '}') {
        weight--;
      } else {
        rst += (c - '0') * weight;
      }
    }
    return rst;
  }
}