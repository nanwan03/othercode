import java.util.*;

/**
 * How to find the k-th smallest value of f,
 * in the f(x,y,z) = 3^x  * 5^y * 7^z  (x > 0, y>0, z>0).
 */
public class KthSmallestProduct {

	public int kth(int K) {
		assert K > 0;
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(K);
		HashSet<Integer> visited = new HashSet<Integer>();
		minHeap.offer(3 * 5 * 7);
		visited.add(3 * 5 * 7);
		while (K > 1) {
			int current = minHeap.poll();
			if (visited.add(3 * current)) {
				minHeap.offer(3 * current);
			}
			if (visited.add(5 * current)) {
				minHeap.offer(5 * current);
			}
			if (visited.add(7 * current)) {
				minHeap.offer(7 * current);
			}
			K--;
		}
		return minHeap.peek();
	}
	
	public int kthI(int K) {
		assert K > 0;
		int seed = 3 * 5 * 7;
		Deque<Integer> three = new LinkedList<Integer>();
		Deque<Integer> five = new LinkedList<Integer>();
		Deque<Integer> seven = new LinkedList<Integer>();
		three.add(seed * 3);
		five.add(seed * 5);
		seven.add(seed * 7);
		int result = seed;
		while (K > 1) {
			if (three.peekFirst() < five.peekFirst()
					&& three.peekFirst() < seven.peekFirst()) {
				result = three.pollFirst();
				three.offerLast(result * 3);
				five.offerLast(result * 5);
				seven.offerLast(result * 7);
			} else if (five.peekFirst() < three.peekFirst()
					&& five.peekFirst() < seven.peekFirst()) {
				result = five.pollFirst();
				five.offerLast(result * 5);
				seven.offerLast(result * 7);
			} else {
				result = seven.pollFirst();
				seven.offerLast(result * 7);
			}
			K--;
		}
		return result;
	}
	
	public static void main(String[] args) {
		KthSmallestProduct solution = new KthSmallestProduct();
		
		int K = 1;
		System.out.println(solution.kth(K));
		System.out.println(solution.kthI(K));
		
		K = 5;
		System.out.println(solution.kth(K));
		System.out.println(solution.kthI(K));
		
		K = 10;
		System.out.println(solution.kth(K));
		System.out.println(solution.kthI(K));
	}
}