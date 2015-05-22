public class Solution {
  public List<String> permutations(String set) {
    // write your solution here
    List<String> rst = new ArrayList<String>();
    if (set == null) {
      return rst;
    }
    char[] chars = set.toCharArray();
    helper(rst, chars, 0);
    return rst;
  }
  private void helper(List<String> rst, char[] chars, int pos) {
    if (pos == chars.length) {
      rst.add(new String(chars));
      return;
    }
    for (int i = pos; i < chars.length; i++) {
      swap(chars, i, pos);
      helper(rst, chars, pos + 1);
      swap(chars, i, pos);
    }
  }
  private void swap(char[] chars, int i, int j) {
    char c = chars[i];
    chars[i] = chars[j];
    chars[j] = c;
  }
}