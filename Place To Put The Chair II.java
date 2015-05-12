public class Solution {
  static class Pair {
		int x;
		int y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
  public List<Integer> putChair(char[][] gym) {
    List<Integer> rst = new ArrayList<Integer>();
    if (gym == null || gym.length == 0) {
      return rst;
    }
    int row = gym.length;
    int col = gym[0].length;
  	int shortest = Integer.MAX_VALUE;
  	int x = 0;
  	int y = 0;
  	for (int i = 0 ; i < row; i++) {
  		for (int j = 0; j < col; j++) {
  			int cost = putChair(gym, i, j);
  			if (cost < shortest) {
  				shortest = cost;
  				x = i;
  				y = j;
  			}
  		}
  	}
  	rst.add(x);
  	rst.add(y);
  	return rst;
  }
  private int putChair(char[][] gym, int i, int j) {
		int row = gym.length;
		int col = gym[0].length;
		boolean[][] visited = new boolean[row][col];
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.offer(new Pair(i, j));
		visited[i][j] = true;
		int level = 0;
		int cost = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int ith = 0; ith < size; ith++) {
				Pair cur = queue.poll();
				if (gym[cur.x][cur.y] == 'E') {
					cost += level;
				}
				List<Pair> neighbors = getNeighbors(cur, gym, row, col);
				for (Pair neighbor : neighbors) {
					if (!visited[neighbor.x][neighbor.y]) {
						queue.add(neighbor);
						visited[neighbor.x][neighbor.y] = true;
					}
				}
			}
			level++;
		}
		return cost;
	}
	private List<Pair> getNeighbors(Pair cur, char[][] gym, int row, int col) {
		List<Pair> neighbors = new ArrayList<Pair>();
		if (cur.x + 1 < row) {
			neighbors.add(new Pair(cur.x + 1, cur.y));
		}
		if (cur.x - 1 >= 0) {
			neighbors.add(new Pair(cur.x - 1, cur.y));
		}
		if (cur.y + 1 < col) {
			neighbors.add(new Pair(cur.x, cur.y + 1));
		}
		if (cur.y - 1 >= 0) {
			neighbors.add(new Pair(cur.x, cur.y - 1));
		}
		return neighbors;
	}
}