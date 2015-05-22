public class Solution {
  public List<String> subSets(String set) {
    // write your solution here
    List<String> rst = new ArrayList<String>();
    if (set == null) {
      return rst;
    }
    char[] chars = set.toCharArray();
    Arrays.sort(chars);
    String items = new String();
    helper(rst, items, chars, 0);
    return rst;
  }
  private void helper(List<String> rst, String items, char[] chars, int pos) {
    rst.add(items);
    Set<Character> hashset = new HashSet<Character>();
    for (int i = pos; i < chars.length; i++) {
      char c = chars[i];
      if (hashset.add(c)) {
        helper(rst, items + c, chars, i + 1);
      }
    }
  }
}