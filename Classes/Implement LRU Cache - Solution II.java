public class Solution<K, V> {
  // limit is the max capacity of the cache
  int size;
  Map<K, V> cache;
  public Solution(int limit) {
    this.size = limit;
    cache = new LinkedHashMap<K, V>();
  }
  
  public void set(K key, V value) {
    if (cache.size() == size) {
      cache.remove(cache.entrySet().iterator().next().getKey());
    }
    if (cache.containsKey(key)) {
      cache.remove(key);
    }
    cache.put(key,value);
  }
  
  public V get(K key) {
    if (!cache.containsKey(key)) {
      return null;
    }
    V value = cache.remove(key);
    cache.put(key, value);
    return value;
  }
}
