package jobsearch;

import java.util.Comparator;
import java.util.PriorityQueue;

public class QueueWithHeap {
	
	private class HeapEntry{
		int rank;
		int value;
		
		HeapEntry(int r, int v) {
			this.rank = r;
			this.value = v;
		}
		
	}
	
	private class CompareEntry implements Comparator<HeapEntry> {

		@Override
		public int compare(HeapEntry o1, HeapEntry o2) {
			// TODO Auto-generated method stub
			return Integer.compare(o2.rank, o1.rank);
		}
		
	}

	PriorityQueue<HeapEntry> heap;
	static int timestamp = 0;
	
	QueueWithHeap() {
		heap = new PriorityQueue<HeapEntry>(new CompareEntry());
	}
	
	public void addEntry(int value) {
		heap.add(new HeapEntry(timestamp++, value));
	}
	
	public int poll() {
		if(heap.isEmpty()) return -1;
		HeapEntry h = heap.poll();
		return h.value;
	}
	
	public boolean isEmpty() {
		return heap.isEmpty();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueWithHeap h = new QueueWithHeap();
		
		h.addEntry(4);
		h.addEntry(6);
		h.addEntry(7);
		
		while(!h.isEmpty()){
			System.out.println(h.poll());
		}
		
	}

}
