public class Solution {
  private class Node {
    char c;
    Node prev;
    Node next;
    Node(char c) {
      this.c = c;
      this.prev = null;
      this.next = null;
    }
  }
  Node head = new Node('#');
  Node tail = new Node('#');
  Map<Character, Node> map;
  public Solution() {
    // Initialize the class.
    head.next = tail;
    tail.prev = head;
    map = new HashMap<Character, Node>();
  }
  
  public void read(char ch) {
    // Implement this method here.
    if (map.containsKey(ch)) {
      if (map.get(ch) != null) {
        Node node = map.get(ch);
        map.put(ch, null);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
      }
      return;
    } else {
      Node newNode = new Node(ch);
      newNode.next = tail;
      newNode.prev = tail.prev;
      tail.prev.next = newNode;
      tail.prev = newNode;
      map.put(ch, newNode);
    }
  }
  
  public Character firstNonRepeating() {
    // Implement this method here.
    return head.next == tail ? null : head.next.c;
  }
}
