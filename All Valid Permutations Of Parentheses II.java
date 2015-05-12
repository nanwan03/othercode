public class Solution {
  public static final char[] PARENS = {'(', ')', '[', ']', '{', '}'};
  public List<String> validParentheses(int l, int m, int n) {
    List<String> rst = new ArrayList<String>();
    StringBuilder sb = new StringBuilder();
    Stack<Character> stack = new Stack<Character>();
    int[] remains = new int[]{l, l, m, m, n, n};
    int length = 2 * (l + m + n);
    helper(rst, sb, stack, remains, length);
    return rst;
  }
  private void helper(List<String> rst, StringBuilder sb, Stack<Character> stack, int[] remains, int length) {
    if (sb.length() == length) {
      rst.add(sb.toString());
      return;
    }
    for (int i = 0; i < PARENS.length; i++) {
      if (remains[i] > 0) {
        if (i % 2 == 0) {
          sb.append(PARENS[i]);
          stack.push(PARENS[i]);
          remains[i]--;
          helper(rst, sb, stack, remains, length);
          remains[i]++;
          stack.pop();
          sb.deleteCharAt(sb.length() - 1);
        } else if (!stack.isEmpty() && stack.peek() == PARENS[i - 1]) {
          sb.append(PARENS[i]);
          stack.pop();
          remains[i]--;
          helper(rst, sb, stack, remains, length);
          remains[i]++;
          stack.push(PARENS[i - 1]);
          sb.deleteCharAt(sb.length() - 1);
        }
      }
    }
  }
}