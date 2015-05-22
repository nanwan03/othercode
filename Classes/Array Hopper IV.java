public class Solution {
  private class Node {
    int index;
    List<Node> neighbors;
    Node(int index) {
      this.index = index;
      neighbors = new ArrayList<Node>();
    }
  }
  public int minJump(int[] array, int index) {
    // write your solution here
    if (array == null || array.length == 0) {
      return 0;
    }
    List<Node> graph = buildGraph(array);
    return BFS(graph, index, array.length - 1);
  }
  private List<Node> buildGraph(int[] array) {
    List<Node> graph = new ArrayList<Node>();
    for (int i = 0; i < array.length; i++) {
      graph.add(new Node(i));
    }
    for (int i = 0; i < array.length; i++) {
      Node node = graph.get(i);
      int step = array[i];
      for (int j = i - 1; j >= Math.max(i - step, 0); j--) {
        node.neighbors.add(graph.get(j));
      }
      for (int j = i + 1; j <= Math.min(i + step, array.length - 1); j++) {
        node.neighbors.add(graph.get(j));
      }
    }
    return graph;
  }
  private int BFS(List<Node> graph, int start, int target) {
    Queue<Node> queue = new LinkedList<Node>();
    Set<Integer> set = new HashSet<Integer>();
    Node startNode = graph.get(start);
    queue.offer(startNode);
    set.add(startNode.index);
    int step = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node node = queue.poll();
        if (node.index == target) {
          return step;
        }
        for (Node neighbor : node.neighbors) {
          if (neighbor.index == target) {
            return step + 1;
          }
          if (set.add(neighbor.index)) {
            queue.offer(neighbor);
          }
        }
      }
      step++;
    }
    return -1;
  }
}