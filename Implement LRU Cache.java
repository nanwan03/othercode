public class Solution<K, V> {
  // limit is the max capacity of the cache
  private class Node {
    K key;
    V value;
    Node prev;
    Node next;
    Node() {
      this.key = null;
      this.value = null;
      this.prev = null;
      this.next = null;
    }
    Node (K key, V value) {
      this.key = key;
      this.value = value;
      this.prev = null;
      this.next = null;
    }
  }
  private int size;
  private Node head = new Node();
  private Node tail = new Node();
  private Map<K, Node> map = new HashMap<K, Node>();
  public Solution(int limit) {
    this.size = limit;
    head.next = tail;
    tail.prev = head;
  }
  
  public void set(K key, V value) {
    if (get(key) != null) {
      map.get(key).value = value;
      return;
    }
    if (map.size() == this.size) {
      map.remove(head.next.key);
      head.next = head.next.next;
      head.next.prev = head;
    }
    Node insert = new Node(key, value);
    map.put(key, insert);
    moveToTail(insert);
  }
  
  public V get(K key) {
    if (!map.containsKey(key)) {
      return null;
    }
    Node node = map.get(key);
    node.next.prev = node.prev;
    node.prev.next = node.next;
    moveToTail(node);
    return node.value;
  }
  private void moveToTail(Node node) {
    node.next = tail;
    node.prev = tail.prev;
    node.next.prev = node;
    node.prev.next = node;
  }
}