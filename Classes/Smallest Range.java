public class Solution {
  class Node implements Comparable<Node>{
	  public int value;
	  public int array;
	  public int index;
	  Node(int value, int array, int index) {
		  this.value = value;
		  this.array = array;
		  this.index = index;
	  }
	  @Override
	  public int compareTo(Node a) {
		  return this.value - a.value;
	  }
  }
  public int[] smallestRange(int[][] arrays) {
    // Write your solution here.
    if (arrays == null || arrays.length == 0) {
  		return new int[2];
  	}
  	int[] rst = new int[2];
  	int k = arrays.length;
  	int min = Integer.MAX_VALUE;
  	int max = Integer.MIN_VALUE;
  	Queue<Node> heap = new PriorityQueue<Node>(k);
  	for (int i = 0; i < k; ++i) {
  		min = Math.min(min, arrays[i][0]);
  		max = Math.max(max, arrays[i][0]);
  		Node node = new Node(arrays[i][0], i, 0);
  		heap.offer(node);
  	}
  	int minRst = min;
  	int maxRst = max;
  	while (!heap.isEmpty()) {
  		Node node = heap.poll();
  		int array = node.array;
  		int index = node.index; 
  		if(index == arrays[array].length - 1) {
  			break;
  		}
  		int nextValue = arrays[array][index + 1];
  		Node nextNode = new Node(nextValue, array, index + 1);
  		heap.offer(nextNode);
  		min = heap.peek().value;
  		max = Math.max(max, nextValue);
  		if (max - min < maxRst - minRst) {
  			maxRst = max;
  			minRst = min;
  		}
  	}
  	rst[0] = minRst;
  	rst[1] = maxRst;
    return rst;
  }
}
