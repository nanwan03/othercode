/*
* class GraphNode {
*   public int key;
*   public List<GraphNode> neighbors;
*   public GraphNode(int key) {
*     this.key = key;
*     this.neighbors = new ArrayList<GraphNode>();
*   }
* }
*/
public class Solution {
  public List<GraphNode> copy(List<GraphNode> graph) {
    if (graph == null || graph.size() == 0) {
        return graph;
    }
    Queue<GraphNode> nodes = new LinkedList<GraphNode>();
    Map<GraphNode, GraphNode> map = new HashMap<GraphNode, GraphNode>();
    for (GraphNode node : graph) {
      if (!map.containsKey(node)) {
        nodes.offer(node);
        map.put(node, new GraphNode(node.key));
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                GraphNode oldNode = nodes.poll();
                GraphNode newNode = map.get(oldNode);
                for (int j = 0; j < oldNode.neighbors.size(); j++) {
                    GraphNode neighbor = oldNode.neighbors.get(j);
                    if (!map.containsKey(neighbor)) {
                        map.put(neighbor, new GraphNode(neighbor.key));
                        nodes.offer(neighbor);
                    }
                    newNode.neighbors.add(map.get(neighbor));
                }
            }
        }
      }
    }
    List<GraphNode> rst = new ArrayList<GraphNode>();
    for (GraphNode node : graph) {
      rst.add(map.get(node));
    }
    return rst;
  }
}