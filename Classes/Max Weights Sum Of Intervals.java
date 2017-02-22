/**
 * class IntervalW {
 *   public int start;
 *   public int end;
 *   public int weight;
 *   public IntervalW(int start, int end, int weight) {
 *     this.start = start;
 *     this.end = end;
 *     this.weight = weight;
 *   }
 * }
 */
public class Solution {
  private class IntervalComparator implements Comparator<IntervalW> {
    public int compare(IntervalW a, IntervalW b) {
      return a.start - b.start;
    }
  }
  public int maxWeightSum(IntervalW[] intervals) {
    // Write your solution here.
    if (intervals == null || intervals.length == 0) {
      return 0;
    }
    Arrays.sort(intervals, new IntervalComparator());
    int maxEndTime = 0;
    for (IntervalW interval : intervals) {
      maxEndTime = Math.max(maxEndTime, interval.end);
    }
    int[] dp = new int[maxEndTime + 1];
    dp[intervals[0].end] = intervals[0].weight;
    for (int i = 1; i < intervals.length; i++) {
      int startTime = intervals[i].start;
      int endTime = intervals[i].end;
      int weight = intervals[i].weight;
      for (int j = 0; j <= startTime; j++) {
        dp[endTime] = Math.max(dp[j] + weight, dp[endTime]);
      }
    }
    int max = 0;
    for (int i : dp) {
      max = Math.max(max, i);
    }
    return max;
  }
}