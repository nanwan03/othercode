public class Solution {
  public int[] dedup(int[] array) {
    if (array == null || array.length == 0) {
    	return array;
    }
    Stack<Integer> stack = new Stack<Integer>();
    for (int i = 0; i < array.length; i++) {
    	if (stack.isEmpty() || stack.peek() != array[i]) { 
    		stack.push(array[i]);
    	} else {
    		while (i + 1 < array.length && array[i] == array[i + 1]) {
    			i++;
    		}
    		stack.pop();
    	}
    }
    int size = stack.size();
    int[] rst = new int[size];
    while (!stack.isEmpty()) {
    	rst[--size] = stack.pop();
    }
    return rst;
  }
}