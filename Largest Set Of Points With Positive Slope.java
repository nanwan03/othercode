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
  public int largest(Point[] points) {
    assert points != null && points.length >= 1;
		Arrays.sort(points, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				if (p1.x == p2.x) {
					return p1.y - p2.y;
				} else {
					return p1.x - p2.x;
				}
			}
		});
		int[] maxSet = new int[points.length];
		int result = 0;
		for (int i = 0; i < points.length; i++) {
			maxSet[i] = 1;
			for (int j = 0; j < i; j++) {
				if (points[j].x < points[i].x && points[j].y < points[i].y) {
					maxSet[i] = Math.max(maxSet[i], 1 + maxSet[j]);
				}
				result = Math.max(result, maxSet[i]);
			}
		}
		return result > 1 ? result : 0;
  }
}