public class Solution {
  private Stack<Integer> stack1;
  private Stack<Integer> stack2;
  public Solution() {
    // write your solution here
    stack1 = new Stack<Integer>();
    stack2 = new Stack<Integer>();
  }
  
  public Integer poll() {
    Integer temp = peek();
    if (temp == null) {
      return null;
    } else {
      stack2.pop();
      return temp;
    }
  }
  
  public void offer(int element) {
    stack1.push(element);
  }
  
  public Integer peek() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
    return stack2.isEmpty() ? null : stack2.peek();
  }
  
  public int size() {
    return stack1.size() + stack2.size();
  }
  
  public boolean isEmpty() {
    return stack1.isEmpty() && stack2.isEmpty();
  }
}