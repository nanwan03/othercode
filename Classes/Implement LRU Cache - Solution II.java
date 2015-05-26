public class Solution<K, V> {
  // limit is the max capacity of the cache
  int size;
  LinkedHashMap<K, V> cache;
  public Solution(int limit) {
    this.size = limit;
    cache = new LinkedHashMap<K, V>();
  }
  
  public void set(K key, V value) {
    if(cache.containsKey(key)) {
      cache.remove(key);
      cache.put(key, value);
      return;
    }
    if(cache.size()==size) { // find the least visited entry and remove
        cache.remove(cache.entrySet().iterator().next().getKey());
    }
    cache.put(key, value);
  }
  
  public V get(K key) {
    if(!cache.containsKey(key)) return null;
      V val = cache.remove(key);
      cache.put(key, val); // the feature of linkedhashmap
      return val;
  }
}