import java.util.*;

/**
 * Maximum value of sliding window with size K.
 */
public class KSlidingWindowMax {

	public void slidingWindowMax(int[] array, int K) {
		assert array != null && array.length >= K && K > 0 & K == array.length;
		Deque<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < array.length; i++) {
			while (!deque.isEmpty() && array[deque.peekFirst()] <= array[i]) {
				deque.pollFirst();
			}
			deque.offerFirst(i);
			while (!deque.isEmpty() && deque.peekLast() <= i - K) {
				deque.pollLast();
			}
			System.out.print(array[deque.peekLast()] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		KSlidingWindowMax solution = new KSlidingWindowMax();
		
		int[] array = {2, 1, 3, 5, 4, 6, 9, 8, 2, 1, 1};
		solution.slidingWindowMax(array, 3);
		solution.slidingWindowMax(array, 4);
	}
}
