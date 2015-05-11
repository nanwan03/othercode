import java.util.*;

class Node {
	
	// Each node in an undirected graph maintains a list of neighbors.
	public List<Node> neighbors;
	
	public Node() {
		neighbors = new ArrayList<Node>();
	}
	// Sample 1, the returned graph is represented by a list nodes.
	
	public static List<Node> sampleGraphOne() {
		Node nodeOne = new Node();
		Node nodeTwo = new Node();
		Node nodeThree = new Node();
		
		nodeOne.neighbors.add(nodeTwo);
		nodeOne.neighbors.add(nodeThree);
		nodeTwo.neighbors.add(nodeOne);
		nodeTwo.neighbors.add(nodeThree);
		nodeThree.neighbors.add(nodeOne);
		nodeThree.neighbors.add(nodeTwo);
		
		return Arrays.asList(new Node[] {nodeOne, nodeTwo, nodeThree});
	}
	
	
	public static List<Node> sampleGraphTwo() {
		Node nodeOne = new Node();
		Node nodeTwo = new Node();
		
		nodeOne.neighbors.add(nodeTwo);
		nodeTwo.neighbors.add(nodeOne);

		return Arrays.asList(new Node[] {nodeOne, nodeTwo});
	}
	
	
	public static List<Node> sampleGraphThree() {
		Node nodeOne = new Node();
		Node nodeTwo = new Node();
		Node nodeThree = new Node();
		Node nodeFour = new Node();
		
		nodeOne.neighbors.add(nodeTwo);
		nodeTwo.neighbors.add(nodeOne);
		nodeTwo.neighbors.add(nodeThree);
		nodeThree.neighbors.add(nodeTwo);
		nodeThree.neighbors.add(nodeFour);
		nodeFour.neighbors.add(nodeThree);

		return Arrays.asList(new Node[] {nodeOne, nodeTwo, nodeThree, nodeFour});
	}
	
	
	public static List<Node> sampleGraphFour() {
		Node nodeOne = new Node();
		Node nodeTwo = new Node();
		Node nodeThree = new Node();
		Node nodeFour = new Node();
		
		nodeOne.neighbors.add(nodeTwo);
		nodeTwo.neighbors.add(nodeOne);
		nodeThree.neighbors.add(nodeFour);
		nodeFour.neighbors.add(nodeThree);

		return Arrays.asList(new Node[] {nodeOne, nodeTwo, nodeThree, nodeFour});
	}
	
	
	public static List<Node> sampleGraphFive() {
		Node nodeOne = new Node();
		Node nodeTwo = new Node();
		Node nodeThree = new Node();
		Node nodeFour = new Node();
		
		nodeOne.neighbors.add(nodeTwo);
		nodeTwo.neighbors.add(nodeOne);
		nodeTwo.neighbors.add(nodeThree);
		nodeTwo.neighbors.add(nodeFour);
		nodeThree.neighbors.add(nodeFour);
		nodeThree.neighbors.add(nodeTwo);
		nodeFour.neighbors.add(nodeThree);
		nodeFour.neighbors.add(nodeTwo);

		return Arrays.asList(new Node[] {nodeOne, nodeTwo, nodeThree, nodeFour});
	}
}

/**
 * Check if an undirected graph is bipartite.
 * The graph will be represented by a List of Node.
 * Each Node maintains the list of neighbors of itself.
 *
 */
public class Bipartite {
	
	public boolean isBipartite(List<Node> graph) {
		assert graph != null;
		if (graph.isEmpty()) {
			return true;
		}
		// the HashMap has two purpose:
		// 1). only contains the visited nodes
		// 2). for each visited nodes, mark the group number(either 0 or 1).
		HashMap<Node, Integer> groups = new HashMap<Node, Integer>();
		// do BFS for each of the nodes,
		// if conflict is found for any of the nodes, the graph is not bipartite.
		for (Node node : graph) {
			if (!searchAndMark(node, groups)) {
				return false;
			}
		}
		return true;
		//return searchAndMark(graph.get(0), groups);
	}
	
	private boolean searchAndMark(Node node, HashMap<Node, Integer> groups) {
		// if the node is already visited, just return true.
		if (groups.containsKey(node)) {
			return true;
		}
		// BFS starting from the current node.
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(node);
		groups.put(node, 0);
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			int group = groups.get(current);
			int neighborGroup = group == 0 ? 1 : 0;
			for (Node neighbor : current.neighbors) {
				if (!groups.containsKey(neighbor)) {
					// if we enter this block, the neighbor has not been visited yet,
					// then we append this neighbor to the queue
// and mark the group for it.
					queue.offer(neighbor);
					groups.put(neighbor, neighborGroup);
				} else if (groups.get(neighbor).intValue() != neighborGroup) {
					// if we enter this block, we find a conflict.
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Bipartite solution = new Bipartite();
		
		System.out.println(solution.isBipartite(Node.sampleGraphOne()));
		System.out.println(solution.isBipartite(Node.sampleGraphTwo()));
		System.out.println(solution.isBipartite(Node.sampleGraphThree()));
		System.out.println(solution.isBipartite(Node.sampleGraphFour()));
		System.out.println(solution.isBipartite(Node.sampleGraphFive()));
	}
}
