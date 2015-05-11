import java.util.*;
/**
 * Repeatedly de-duplicate adjacent repeated letters.
 * Example:
 * abbbaz --> aaz --> z
 */
public class RepeatedDedup {

	public String repeatedDedup(String input) {
		assert input != null;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < input.length(); i++) {
			if (stack.isEmpty() || input.charAt(i) != stack.peek()) {
				stack.push(input.charAt(i));
			} else {
				while (i + 1 < input.length() && input.charAt(i + 1) == stack.peek()) {
					i++;
				}
				stack.pop();
			}
		}
		StringBuilder builder = new StringBuilder();
		while (!stack.isEmpty()) {
			builder.append(stack.pop());
		}
		return builder.reverse().toString();
	}

	public static void main(String[] args) {
		RepeatedDedup solution = new RepeatedDedup();
		
		String input = "";
		System.out.println(solution.repeatedDedup(input));
		
		input = "abc";
		System.out.println(solution.repeatedDedup(input));

		input = "abbccbaaazx";
		System.out.println(solution.repeatedDedup(input));

		input = "abbacddada";
		System.out.println(solution.repeatedDedup(input));
	}
}
