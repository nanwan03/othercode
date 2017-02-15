public class Solution {
  private Stack<Integer> stack;
  private Stack<Integer> minStack;
  public Solution() {
    // write your solution here
    stack = new Stack<Integer>();
    minStack = new Stack<Integer>();
  }
  
  public int pop() {
    if (stack.isEmpty()) {
      return -1;
    }
    Integer tmp = stack.pop();
    return tmp == minStack.peek() ? minStack.pop() : tmp;
  }
  
  public void push(int element) {
    stack.push(element);
    if (minStack.isEmpty() || element <= minStack.peek()) {
      minStack.push(element);
    }
  }
  
  public int top() {
    if (stack.isEmpty()) {
      return -1;
    }
    return stack.peek();
  }
  
  public int min() {
    if (minStack.isEmpty()) {
      return -1;
    }
    return minStack.peek();
  }
}
