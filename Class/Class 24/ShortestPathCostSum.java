import java.util.*;

/**
 * Given a gym with k equipments, and some obstacles.
 * Let¡¯s say we bought a chair and wanted to put this chair into the gym
 * such that the sum of the shortest path cost from the chair to the k equipments is minimal.
 * 
 * Assumption:
 * 1). The cost from one cell to any of its neighbors(up/down/left/right) is 1.
 * 2). 'E' denotes an equipment, 'O' denotes an obstacle.
 */
public class ShortestPathCostSum {

	static class Pair {
		int x;
		int y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return x + " " + y;
		}
	}
	// Assumption:
	// gym is N * N.
	// 1). The cost from one cell to any of its neighbors(up/down/left/right) is 1.
	// 2). 'E' denotes an equipment, 'O' denotes an obstacle.
	// 3). The chair can not be put on equipment or obstacle.
	public Pair shortestPathCostSum(char[][] gym) {
		assert gym != null;
		int len = gym.length;
		int[][] costSum = new int[len][len];
		Pair result = null;
		for (int i = 0 ; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (gym[i][j] == 'E') {
					if (!addCost(gym, costSum, i, j)) {
						return null;
					}
				}
			}
		}
		for (int i = 0; i < len; i++) {
			for (int j = 0; j< len; j++) {
				if (gym[i][j] != 'O' && gym[i][j] != 'E') {
					if (result == null) {
						result = new Pair(i, j);
					} else if (costSum[i][j] < costSum[result.x][result.y]) {
						result.x = i;
						result.y = j;
					}
				}
			}
		}
		return result;
	}
	private boolean addCost(char[][] gym, int[][] costSum, int i, int j) {
		int len = gym.length;
		boolean[][] visited = new boolean[len][len];
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.offer(new Pair(i, j));
		visited[i][j] = true;
		int cost = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int ith = 0; ith < size; ith++) {
				Pair cur = queue.poll();
				costSum[cur.x][cur.y] += cost;
				List<Pair> neighbors = getNeighbors(cur, gym, len);
				for (Pair neighbor : neighbors) {
					if (!visited[neighbor.x][neighbor.y]) {
						queue.add(neighbor);
						visited[neighbor.x][neighbor.y] = true;
					}
				}
			}
			cost++;
		}
		for (int x = 0; x < len; x++) {
			for (int y = 0; y < len; y++) {
				if (gym[x][y] == 'E' && !visited[x][y]) {
					return false;
				}
			}
		}
		return true;
	}
	private List<Pair> getNeighbors(Pair cur, char[][] gym, int len) {
		List<Pair> neighbors = new ArrayList<Pair>();
		if (cur.x + 1 < len && gym[cur.x + 1][cur.y] != 'O') {
			neighbors.add(new Pair(cur.x + 1, cur.y));
		}
		if (cur.x - 1 >= 0 && gym[cur.x - 1][cur.y] != 'O') {
			neighbors.add(new Pair(cur.x - 1, cur.y));
		}
		if (cur.y + 1 < len && gym[cur.x][cur.y + 1] != 'O') {
			neighbors.add(new Pair(cur.x, cur.y + 1));
		}
		if (cur.y - 1 >= 0 && gym[cur.x][cur.y - 1] != 'O') {
			neighbors.add(new Pair(cur.x, cur.y - 1));
		}
		return neighbors;
	}
	
	public static void main(String[] args) {
		ShortestPathCostSum solution = new ShortestPathCostSum();
		
		char[][] gym = {
				{'O', 'E', ' ', ' '},
				{' ', ' ', ' ', 'E'},
				{'E', 'O', 'O', ' '},
				{' ', 'E', ' ', 'E'}
		};
		System.out.println(solution.shortestPathCostSum(gym));
	}
}
