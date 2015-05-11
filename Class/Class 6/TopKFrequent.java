import java.util.*;
import java.util.Map.*;
/**
 * Find the top k frequent words from a list of words.
 * 
 */
public class TopKFrequent {

	private static class WordFreq implements Comparable<WordFreq> {
		String word;
		long frequency;

		public WordFreq(String word, long frequency) {
			this.word = word;
			this.frequency = frequency;
		}
		
		@Override
		public String toString() {
			return word + ":" + frequency;
		}

		@Override
		public int compareTo(WordFreq another) {
			long diff = this.frequency - another.frequency;
			if (diff == 0) {
				return 0;
			} else if (diff < 0) {
				return -1;
			} else {
				return 1;
			}
		}
	}
	
	public List<WordFreq> topK(int k, List<String> words) {
		assert words != null;
		// construct the map between the words and their frequency.
		Map<String, Long> freqMap = frequencyMap(words);
		// from the frequency map construct the heap contains top K.
		Queue<WordFreq> freqHeap = frequencyHeap(k, freqMap);
		return topList(freqHeap);
	}
	
	private Map<String, Long> frequencyMap(List<String> words) {
		Map<String, Long> freqMap = new HashMap<String, Long>();
		for (String word : words) {
			if (!freqMap.containsKey(word)) {
				// if we have not seen the word before, count the frequency as 1.
				freqMap.put(word, 1L);
			} else {
				// if we have seen the word before, increment the frequency by 1.
				freqMap.put(word, freqMap.get(word) + 1L);
			}
		}
		return freqMap;
	}
	
	// construct the min heap containing the top k.
	private Queue<WordFreq> frequencyHeap(int k, Map<String, Long> freqMap) {
		List<WordFreq> heapifyCandidate = new ArrayList<WordFreq>(k);
		Queue<WordFreq> minHeap = null;
		int count = 0;
		for (Entry<String, Long> entry : freqMap.entrySet()) {
			if (count < k - 1) {
				// for the first k elements, add them to the list first
				heapifyCandidate.add(new WordFreq(entry.getKey(), entry.getValue()));
			} else if (count == k - 1) {
				// when there are k elements in the list,
				// use the list to construct the min heap.
				heapifyCandidate.add(new WordFreq(entry.getKey(), entry.getValue()));
				minHeap = new PriorityQueue<WordFreq>(heapifyCandidate);
			} else if (entry.getValue().longValue() > minHeap.peek().frequency) {
				// for the other elements, we need to compare it with the peek to determine
				// if they should be inserted into the heap.
				minHeap.poll();
				minHeap.offer(new WordFreq(entry.getKey(), entry.getValue()));
			}
			count++;
		}
		// if we do not even have k elements in the frequency map.
		if (freqMap.size() <= k) {
			minHeap = new PriorityQueue<WordFreq>(heapifyCandidate);
		}
		return minHeap;
	}
	
	private List<WordFreq> topList(Queue<WordFreq> freqHeap) {
		List<WordFreq> result = new ArrayList<WordFreq>();
		while(!freqHeap.isEmpty()) {
			result.add(freqHeap.poll());
		}
		return result;
	}
	
	
	
	public static void main(String[] args) {
		TopKFrequent solution = new TopKFrequent();
		
		int k = 3;
		List<String> words = Arrays.asList();
		System.out.println(solution.topK(k, words));
		
		words = Arrays.asList("a", "b", "a");
		System.out.println(solution.topK(k, words));
		
		words = Arrays.asList("a", "b", "c", "d", "c", "b", "a", "a", "b", "a");
		System.out.println(solution.topK(k, words));
	}
}
