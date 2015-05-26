public class Solution {
  private static class Entry {
		int xIndex;
		int yIndex;
		int value;
		
		public Entry(int xIndex, int yIndex, int value) {
			this.xIndex = xIndex;
			this.yIndex = yIndex;
			this.value = value;
		}
		// this method needs to be overridden to be used by HashSet.
		// we need to guarantee two things:
		// 1). for any equal Entry objects, their hashCode should be same.
		// 2). provide as less conflicts as possible for not equal objects.
		@Override
		public int hashCode() {
			return xIndex * 101 + yIndex;
		}
		
		// this method needs to be overridden to be used by HashSet.
		// if two Entry objects have the same xIndex and yIndex,
		// we think them equal.
		@Override
		public boolean equals(Object obj) {
		  if (obj == null || !(obj instanceof Entry)) {
		    return false;
		  }
		  if (obj == this) {
		    return true;
		  }
		  Entry entry = (Entry)obj;
		  return entry.xIndex == this.xIndex && entry.yIndex == this.yIndex;
		}
	}

  private class EntryComparator implements Comparator<Entry> {
    public int compare(Entry a, Entry b) {
      return a.value - b.value;
    }
  }
	public int kthSmallest(final int[][] matrix, int k) {
		if (matrix == null || matrix.length == 0 || k == 0) {
		  return 0;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		Queue<Entry> minHeap = new PriorityQueue<Entry>(k, new EntryComparator());
		Set<Entry> visited = new HashSet<Entry>();
		
		int result = Integer.MIN_VALUE;
		Entry start = new Entry(0, 0, matrix[0][0]);
		minHeap.offer(start);
		visited.add(start);
		while (k > 0) {
			Entry current = minHeap.poll();
      result = current.value;
      
			if (current.xIndex + 1 < row) {
				Entry right = new Entry(current.xIndex + 1, current.yIndex,
						matrix[current.xIndex + 1][current.yIndex]);
				if (!visited.contains(right)) {
					minHeap.offer(right);
					visited.add(right);
				}
			}
			if (current.yIndex + 1 < col) {
				Entry down = new Entry(current.xIndex, current.yIndex + 1,
						matrix[current.xIndex][current.yIndex + 1]);
				if (!visited.contains(down)) {
					minHeap.offer(down);
					visited.add(down);
				}
			}
			k--;
		}
		return result;
	}
}