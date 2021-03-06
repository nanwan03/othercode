public class Solution {
  public List<String> validParentheses(int n) {
    // write your solution here
    List<String> rst = new ArrayList<String>();
    String items = new String();
    helper(rst, items, n, n);
    return rst;
  }
  private void helper(List<String> rst, String items, int leftNum, int rightNum) {
    if (leftNum == rightNum && leftNum == 0) {
      rst.add(items);
      return;
    }
    if (leftNum > 0) {
      helper(rst, items + "(", leftNum - 1, rightNum);
    }
    if (rightNum > leftNum && rightNum > 0) {
      helper(rst, items + ")", leftNum, rightNum - 1);
    }
  }
}