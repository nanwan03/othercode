public class Solution {
  public String shortest(String input, int k) {
    // Write your solution here.
    if (input == null || input.length() == 0) {
      return input;
    }
    int[] total = new int[256];
    int start = -1;
    int end = input.length();
    int type = 0;
    int left = 0;
    for (int i = 0; i < input.length(); ++i) {
      if (++total[input.charAt(i)] == 1) {
        type++;
      }
      if (type == k) {
        while (--total[input.charAt(left)] > 0) {
          left++;
        }
        if (i - left < end - start) {
          start = left;
          end = i;
        }
        left++;
        type--;
      }
    }
    return start == -1 ?  "" : input.substring(start, end + 1);
  }
}
