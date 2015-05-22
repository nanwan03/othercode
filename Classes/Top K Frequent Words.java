public class Solution {
  private class Node {
    String str;
    int freq;
    Node(String str, int freq) {
      this.str = str;
      this.freq = freq;
    }
  }
  private class NodeComparator implements Comparator<Node> {
    public int compare(Node a, Node b) {
      return a.freq - b.freq;
    }
  }
  public List<String> topKFrequent(List<String> combo, int k) {
    // write your solution here
    List<String> rst = new ArrayList<String>();
    if (combo == null || combo.size() == 0 || k == 0) {
      return rst;
    }
    Map<String, Integer> map = new HashMap<String, Integer>();
    for (String str : combo) {
      if (!map.containsKey(str)) {
        map.put(str, 1);
      } else {
        map.put(str, map.get(str) + 1);
      }
    }
    Queue<Node> heap = new PriorityQueue<Node>(k, new NodeComparator());
    int count = 0;
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      String key = entry.getKey();
      int value = entry.getValue();
      if (count < k) {
        heap.offer(new Node(key, value));
      } else if (value > heap.peek().freq) {
        heap.poll();
        heap.offer(new Node(key, value));
      }
      count++;
    }
    while (!heap.isEmpty()) {
      rst.add(heap.poll().str);
    }
    Collections.reverse(rst);
    return rst;
  }
}