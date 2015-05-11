public class Solution {
  public List<Integer> common(int[] A, int[] B) {
    // write your solution here
    List<Integer> rst = new ArrayList<Integer>();
    int startA = 0;
    int startB = 0;
    while (startA < A.length && startB < B.length) {
      if (A[startA] == B[startB]) {
        rst.add(A[startA]);
        startA++;
        startB++;
      } else if (A[startA] < B[startB]) {
        startA++;
      } else {
        startB++;
      }
    }
    return rst;
  }
}