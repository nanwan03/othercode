/*
* class Point {
*   public int x;
*   public int y;
*   public Point(int x, int y) {
*     this.x = x;
*     this.y = y;
*   }
* }
*/
public class Solution {
  public int most(Point[] points) {
    if (points == null || points.length == 0) {
      return 0;
    }
		Map<Double, Integer> slopes = new HashMap<Double, Integer>();
		int result = 0;
		for (int i = 0; i < points.length; i++) {
			slopes.clear();
			int same = 1;
			int sameX = 0;
			int maxPoints = 0;
			for (int j = 0; j < points.length; j++) {
				if (i == j) {
					continue;
				} else if (points[i].x == points[j].x && points[i].y == points[j].y) {
					same++;
				} else if (points[i].x == points[j].x) {
					sameX++;
				} else {
					double slope = (double) (points[i].y - points[j].y) / (points[i].x - points[j].x);
					if (!slopes.containsKey(slope)) {
						slopes.put(slope, 0);
					}
					slopes.put(slope, slopes.get(slope) + 1);
					maxPoints = Math.max(slopes.get(slope), maxPoints);
				}
			}
			result = Math.max(result, Math.max(sameX, maxPoints) + same);
		}
		return result;
  }
}