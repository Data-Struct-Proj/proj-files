package proj;
public class MaxHeap  {
	
	class Node {
		int frq;
		char chr;
		int key;
		Node left, right;

		public Node(int f, char c) {
			frq = f;
			chr = c;
			Character c1 = Character.valueOf(c);
			key = c1.hashCode();
			left = right = null;
		}
	};
	
	private Node[] heap;

	private int hSize;
	
	public MaxHeap(int size) {
		heap = new Node[size];
		hSize = -1;
	}
	
	// Parent node ...
	public int parent(int i) { return (i-1)/2; }
	// Left child ...
	public int left(int i) { return 2*i + 1; }
	// Right child...
	public int right(int i) {  return 2*i + 2; }
	// Data at node i ...
	public int data(int i) { return heap[i].frq; }
	
	public void swap(int a, int b) {
		Node t = heap[a]; 
		heap[a] = heap[b];
		heap[b] = t;
	}
	
	
	public void insertN(Node e) {
		heap[++hSize] = e;
		
		int c = hSize;
		int p = parent(c);
		
		while(p >= 0 && c > 0) {
			if(heap[p].frq < heap[c].frq)
				swap(p,c);
			c = p;
			p = parent(c);	
		}
	}
	public void insert(int d,char cc) {
		Node e = new Node(d,cc);
		heap[++hSize] = e;
		
		int c = hSize;
		int p = parent(c);
		
		while(p >= 0 && c > 0) {
			if(heap[p].frq < heap[c].frq)
				swap(p,c);
			c = p;
			p = parent(c);	
		}
	}
	

	public Node maxExtract() {
		Node root=heap[0];
		Node max = root;
		
		root = heap[hSize--];
		maxHeapify(0);
		
		return max;
	}

	
	private void maxHeapify(int n) {
		int l = left(n);
		int r = right(n);
		
		Node large = heap[n];
		int sIndex = n;
		
		// Checking the left child ...
		if(large.frq < heap[l].frq) {
			large = heap[l];
			sIndex = l;
		}
		// Checking the right child...
		if(large.frq < heap[r].frq) {
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

	public void print() 
    { 
        for (int i = 0; i < hSize/2; i++) { 
            System.out.print(" PARENT : " + heap[i].chr+":"+heap[i].frq + " LEFT CHILD : " + 
                      heap[left(i)].chr+":"+heap[left(i)].frq + " RIGHT CHILD :" + heap[right(i)].chr+":"+heap[right(i)].frq); 
            System.out.println(); 
        } 
    }
	
	public void inorder(int root) {
		if(root > hSize) return;
		
		inorder(left(root));
		System.out.print(data(root) +" ");
		inorder(right(root));	
		
	}
	//end_proj Node is a different thing so we use that here.
	public void fromNodeArray(end_proj.Encode.Node[] a) {
		for(int i=0;i<a.length;i++) {
			Node t = new Node(a[i].frq,a[i].chr);
			insertN(t);
		}
		
	}
	
public static void main(String[] args) throws Exception {
		
		MaxHeap maxHeap = new MaxHeap(15);
		
		    maxHeap.insert(5,'a'); 
	        maxHeap.insert(3,'b'); 
	        maxHeap.insert(17,'c'); 
	        maxHeap.insert(10,'d'); 
	        maxHeap.insert(84,'e'); 
	        maxHeap.insert(19,'f'); 
	        maxHeap.insert(6,'g'); 
	        maxHeap.insert(22,'h'); 
	        maxHeap.insert(9,'i');
	        maxHeap.print(); 
	}
}


