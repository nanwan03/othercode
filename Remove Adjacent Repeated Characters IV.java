public class Solution {
  /*
  *  try to convert the string to char array,
  *  and do it in place.
  */
  public String deDup(String input) {
    // write your solution here
    if (input == null || input.length() < 2) {
      return input;
    }
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < input.length(); i++) {
      if (stack.isEmpty() || input.charAt(i) != stack.peek()) {
        stack.push(input.charAt(i));
      } else {
        while (i < input.length() - 1 && input.charAt(i + 1) == stack.peek()) {
          i++;
        }
        stack.pop();
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    return sb.reverse().toString();
  }
}