public class Solution {
  private Stack<Integer> stack;
  private Stack<Integer> minStack;
  public Solution() {
    // write your solution here
    stack = new Stack<Integer>();
    minStack = new Stack<Integer>();
  }
  
  public Integer pop() {
    if (stack.isEmpty()) {
      return null;
    }
    int temp = stack.pop();
    if (temp == minStack.peek()) {
      minStack.pop();
    }
    return temp;
  }
  
  public void push(int element) {
    stack.push(element);
    if (minStack.isEmpty() || element <= minStack.peek()) {
      minStack.push(element);
    }
  }
  
  public Integer top() {
    if (stack.isEmpty()) {
      return null;
    }
    return stack.peek();
  }
  
  public Integer min() {
    if (minStack.isEmpty()) {
      return null;
    }
    return minStack.peek();
  }
}