public class Solution {
  public String reverse(String input) {
    // Write your solution here.
    Set<Character> set = new HashSet<Character>();
    set.add('a');
    set.add('e');
    set.add('i');
    set.add('o');
    set.add('u');
    int left = 0;
    int right = input.length() - 1;
    while (left < right) {
      while (!set.contains(input.charAt(left)) && left < right) {
        left++;
      }
      while (!set.contains(input.charAt(right)) && left < right) {
        right--;
      }
      if (left < right) {
        input = swap(input, left++, right--);
      }
    }
    return input;
  }
  private String swap(String input, int left, int right) {
    char[] chars = input.toCharArray();
    char c = chars[left];
    chars[left] = chars[right];
    chars[right] = c;
    return new String(chars);
  }
}
