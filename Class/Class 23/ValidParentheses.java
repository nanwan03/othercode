import java.util.*;

/**
 * Print out all valid permutations of l {}, m [], n ().
 */
public class ValidParentheses {
	
	public static final char[] PARENS = {'{', '}', '[', ']', '(', ')'};
	
	public void validParentheses(int l, int m, int n) {
		assert l >= 0 && m >= 0 && n >= 0;
		StringBuilder temp = new StringBuilder();
		Deque<Character> stack = new LinkedList<Character>();
		validHelper(new int[] {l, l, m, m, n, n}, temp,
				2 * l + 2 * m + 2 * n, stack);
	}

	private void validHelper(int[] remain, StringBuilder temp,
			int targetLength, Deque<Character> stack) {
		if (temp.length() == targetLength) {
			System.out.println(temp);
			return;
		}
		for (int i = 0; i < 6; i++) {
			if (remain[i] > 0) {
				if (i % 2 == 0) {
					temp.append(PARENS[i]);
					remain[i]--;
					stack.offerFirst(PARENS[i]);
					validHelper(remain, temp, targetLength, stack);
					stack.pollFirst();
					remain[i]++;
					temp.deleteCharAt(temp.length() - 1);
				} else if (!stack.isEmpty() && stack.peekFirst() == PARENS[i - 1]) {
					temp.append(PARENS[i]);
					remain[i]--;
					stack.pollFirst();
					validHelper(remain, temp, targetLength, stack);
					stack.offerFirst(PARENS[i - 1]);
					remain[i]++;
					temp.deleteCharAt(temp.length() - 1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		ValidParentheses solution = new ValidParentheses();
		
		int l = 1;
		int m = 2;
		int n = 3;
		solution.validParentheses(l, m, n);
	}
}
