
public class Solution {
  public List<Integer> putChair(char[][] gym) {
    // write your solution here
    List<Integer> rst = new ArrayList<Integer>();
    if (gym == null || gym.length == 0 || gym[0].length == 0) {
      return rst;
    }
    List<Integer> sumx = new ArrayList<Integer>();
    List<Integer> sumy = new ArrayList<Integer>();
    List<Integer> x = new ArrayList<Integer>();
    List<Integer> y = new ArrayList<Integer>();
    for (int i = 0; i < gym.length; ++i) {
      for (int j = 0; j < gym[0].length; ++j) {
        if (gym[i][j] == 'E') {
          x.add(i);
          y.add(j);
        }
      }
    }
    Collections.sort(x);
    Collections.sort(y);
    sumx.add(0);
    sumy.add(0);
    for (int i = 1; i <= x.size(); ++i) {
      sumx.add(sumx.get(i - 1) + x.get(i - 1));
      sumy.add(sumy.get(i - 1) + y.get(i - 1));
    }
    int sum = Integer.MAX_VALUE;
    int rstX = -1;
    int rstY = -1;
    for (int i = 0; i < gym.length; ++i) {
      for (int j = 0; j < gym[0].length; ++j) {
        int costX = getCost(x, sumx, i);
        int costY = getCost(y, sumy, j);
        if (costX + costY < sum) {
          sum = costX + costY;
          rstX = i;
          rstY = j;
        }
      }
    }
    rst.add(rstX);
    rst.add(rstY);
    return rst;
  }
  private int getCost(List<Integer> list, List<Integer> sum, int pos) {
    if (list.size() == 0) {
      return 0;
    }
    int size = list.size();
    int index = getInsertPos(list, pos);
    return sum.get(size) - sum.get(index) - pos * (size - index) + index * pos - sum.get(index);
  }
  private int getInsertPos(List<Integer> list, int pos) {
    int left = 0;
    int right = list.size() - 1;
    while (left + 1 < right) {
      int mid = (left + right) / 2;
      if (list.get(mid) == pos) {
        right = mid;
      } else if (list.get(mid) < pos) {
        left = mid;
      } else {
        right = mid;
      }
    }
    if (list.get(left) >= pos) {
      return left;
    } else if (list.get(right) >= pos) {
      return right;
    } else {
      return right + 1;
    }
  }
}
