/**
 * public class GraphNode {
 *   public int key;
 *   public List<GraphNode> neighbors;
 *   public GraphNode(int key) {
 *     this.key = key;
 *     this.neighbors = new ArrayList<GraphNode>();
 *   }
 * }
 */
public class Solution {
  public boolean isBipartite(List<GraphNode> graph) {
    // write your solution here
    if (graph == null || graph.size() == 0) {
      return true;
    }
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    Queue<GraphNode> queue = new LinkedList<GraphNode>();
    GraphNode start = graph.get(0);
    queue.offer(start);
    map.put(start.key, 0);
    int nextColor = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        GraphNode node = queue.poll();
        for (GraphNode neighbor : node.neighbors) {
          int value = neighbor.key;
          if (map.containsKey(value)) {
            if (map.get(value) != nextColor) {
              return false;
            }
          } else {
            queue.offer(neighbor);
            map.put(neighbor.key, nextColor);
          }
        }
      }
      nextColor ^= 1;
    }
    return true;
  }
}