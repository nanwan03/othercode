public class Solution {
  private class Triple {
		int v1;
		int v2;
		int v3;
		Triple(int v1, int v2, int v3) {
			this.v1 = v1;
			this.v2 = v2;
			this.v3 = v3;
		}
		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (!(obj instanceof Triple)) {
				return false;
			}
			Triple another = (Triple) obj;
			return this.v1 == another.v1 && this.v2 == another.v2
					&& this.v3 == another.v3;
		}
		
		@Override
		public int hashCode() {
			return v1 * 31 * 31 + v2 * 31 + v3;
		}
	}

  public List<Integer> closest(final int[] a1, final int[] a2, final int[] a3, int K) {
    assert a1 != null && a2 != null && a3 != null;
		assert a1.length > 0 && a2.length > 0 && a3.length > 0;
		assert K >= 1 && K <= a1.length * a2.length * a3.length;
		PriorityQueue<Triple> minHeap = new PriorityQueue<Triple>(K,
			new Comparator<Triple>() {
				@Override
				public int compare(Triple t1, Triple t2) {
					int d1 = distance(a1[t1.v1], a2[t1.v2], a3[t1.v3]);
					int d2 = distance(a1[t2.v1], a2[t2.v2], a3[t2.v3]);
					if (d1 == d2) {
						return 0;
					} else if (d1 < d2) {
						return -1;
					} else {
						return 1;
					}
				}
			});
		HashSet<Triple> visited = new HashSet<Triple>();
		Triple seed = new Triple(0, 0, 0);
		minHeap.offer(seed);
		visited.add(seed);
		while (K > 1) {
			Triple current = minHeap.poll();
			List<Triple> neighbors = getNeighbors(current, a1, a2, a3);
			for (Triple neighbor : neighbors) {
				if (visited.add(neighbor)) {
					minHeap.offer(neighbor);
				}
			}
			K--;
		}
		Triple result = minHeap.poll();
		List<Integer> rst = new ArrayList<Integer>();
		rst.add(a1[result.v1]);
		rst.add(a2[result.v2]);
		rst.add(a3[result.v3]);
		return rst;
  }
  private List<Triple> getNeighbors(Triple current, int[] a1, int[] a2, int[] a3) {
		List<Triple> neighbors = new ArrayList<Triple>();
		if (current.v1 + 1 < a1.length) {
			neighbors.add(new Triple(current.v1 + 1, current.v2, current.v3));
		}
		if (current.v2 + 1 < a2.length) {
			neighbors.add(new Triple(current.v1, current.v2 + 1, current.v3));
		}
		if (current.v3 + 1 < a3.length) {
			neighbors.add(new Triple(current.v1, current.v2, current.v3 + 1));		
		}
		return neighbors;
	}

	private int distance(int x, int y, int z) {
		return x * x + y * y + z * z;
	}
}