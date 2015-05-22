public class Solution {
  public List<Integer> common(int[] a, int[] b, int[] c) {
    // write your solution here
    List<Integer> rst = new ArrayList<Integer>();
    if (a == null || b == null || c == null || a.length == 0 || b.length == 0 || c.length ==0) {
      return rst;
    }
    int aIndex = 0;
    int bIndex = 0;
    int cIndex = 0;
    while (aIndex < a.length && bIndex < b.length && cIndex < c.length) {
      if (a[aIndex] == b[bIndex] && b[bIndex] == c[cIndex]) {
        rst.add(a[aIndex]);
        aIndex++;
        bIndex++;
        cIndex++;
      } else {
        int minValue = a[aIndex];
        int flag = 0;
        if (b[bIndex] < minValue) {
          minValue = b[bIndex];
          flag = 1;
        }
        if (c[cIndex] < minValue) {
          minValue = c[cIndex];
          flag = 2;
        }
        if (flag == 0) {
          aIndex++;
        } else if (flag == 1) {
          bIndex++;
        } else {
          cIndex++;
        }
      }
    }
    return rst;
  }
}