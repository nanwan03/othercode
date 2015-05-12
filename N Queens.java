public class Solution {
  public List<List<Integer>> nqueens(int n) {
    List<List<Integer>> rst = new ArrayList<List<Integer>>();
    if (n == 0) {
        return rst;
    }
    List<Integer> cols = new ArrayList<Integer>();
    search(n, cols, rst);
    return rst;
  }
  private void search(int n, List<Integer> cols, List<List<Integer>> rst) {
        if (n == cols.size()) {
            rst.add(new ArrayList<Integer>(cols));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(cols, i)) {
                cols.add(i);
                search(n, cols, rst);
                cols.remove(cols.size() - 1);
            }
        }
    }
    private boolean isValid(List<Integer> cols, int rowToPut) {
        int colSize = cols.size();
        for (int i = 0; i < colSize; i++) {
            if (rowToPut == cols.get(i) || Math.abs(rowToPut - cols.get(i)) == colSize - i) {
                return false;
            }
        }
        return true;
    }
}