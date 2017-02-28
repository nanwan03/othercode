public class Solution {
  private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
  public int numOfTrees(int n) {
    // Write your solution here.
    if (map.containsKey(n)) {
        return map.get(n);
    }
    if(n==0 || n==1)
    {
        map.put(0, 1);
        map.put(1, 1);
        return 1;
    }
    int rst = 0;
    for(int i=1;i<=n;i++)
    {
        rst += numOfTrees(i-1)*numOfTrees(n-i);
    }
    map.put(n, rst);
    return rst;
  }
}
