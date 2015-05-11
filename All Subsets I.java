public class Solution {
  public List<String> subSets(String set) {
    // write your solution here
    List<String> rst = new ArrayList<String>();
    if (set == null) {
      return rst;
    }
    String items = new String();
    helper(rst, items, set, 0);
    return rst;
  }
  private void helper(List<String> rst, String items, String set, int pos) {
    rst.add(items);
    for (int i = pos; i < set.length(); i++) {
      helper(rst, items + set.charAt(i), set, i + 1);
    }
  }
}