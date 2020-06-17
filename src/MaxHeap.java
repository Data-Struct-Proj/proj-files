package tree;

public class MaxHeap  {

	// Array the implements the CBT...	
	private int[] heap;
	// number of values in the array
	private int hSize;
	
	public MaxHeap(int size) {
		heap = new int[size];
		hSize = -1;
	}
	
	// Parent node ...
	public int parent(int i) { return (i-1)/2; }
	// Left child ...
	public int left(int i) { return 2*i + 1; }
	// Right child...
	public int right(int i) {  return 2*i + 2; }
	// Data at node i ...
	public int data(int i) { return heap[i]; }
	
	public void swap(int a, int b) {
		int t = heap[a]; 
		heap[a] = heap[b];
		heap[b] = t;
	}
	
	
	public void insert(int e) {
		heap[++hSize] = e;
		
		int c = hSize;
		int p = parent(c);
		
		// Bottom up Heapification ...
		// Bubble up Heapify ...
		
		while(p >= 0 && c > 0) {
			if(heap[p] < heap[c])
				swap(p,c);
			c = p;
			p = parent(c);	
		}
	}

	public int minExtract() {
		int max = heap[0];
		
		heap[0] = heap[hSize--];
		maxHeapify(0);
		
		return max;
	}

	
	private void maxHeapify(int n) {
		int l = left(n);
		int r = right(n);
		
		int large = heap[n];
		int sIndex = n;
		
		// Checking the left child ...
		if(large < heap[l]) {
			large = heap[l];
			sIndex = l;
		}
		// Checking the right child...
		if(large < heap[r]) {
			large = heap[r];
			sIndex = r;
		}
		
		if(sIndex != n  && sIndex <= hSize) {
			swap(n,sIndex);
			maxHeapify(sIndex);
		}

	}

	public boolean isEmpty() {
		return hSize==-1;
	}

	public void print() {
		System.out.println();
		for(int j =0; j<=hSize; j++) {
			System.out.print(heap[j] + " ");
		}
	}
	
	public void inorder(int root) {
		if(root > hSize) return;
		
		inorder(left(root));
		System.out.print(data(root) +" ");
		inorder(right(root));	
		
	}
	
	public void sort() {
		System.out.println();
		while (hSize >=0)
			System.out.print(minExtract()+ " ");
	}
	
	
public static void main(String[] args) throws Exception {
		
		MaxHeap t = new MaxHeap(15);
		
		t.insert(8);
		t.insert(5);
		t.insert(3);
		
		//t.print();
		
		t.insert(12);
		t.insert(14);
		t.insert(7);
		t.insert(9);
		
		//t.print();
		
		t.insert(1);
		t.insert(6);
		
		t.print();
		
		t.sort();
	}
}


