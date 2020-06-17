package end_proj;

public class HuffmanMaxHeap {

	//Creating a sub-Class Node for the HuffmanMaxHeap
	class Node {
		double frq;
		char chr;
		int key;
		Node left, right;

		public Node(double f, char c) {
			frq = f;
			chr = c;
			Character c1 = Character.valueOf(c);
			key = c1.hashCode();
			left = right = null;
		}
	};
	
	// We initialise a new array of Node and its size..
	public Node[] heap;

	public int hSize;

	public HuffmanMaxHeap(int size) {
		heap = new Node[size];
		hSize = -1;
	}

	// Parent node ...
	public int parent(int i) {
		return (i - 1) / 2;
	}

	// Left child ...
	public int left(int i) {
		return 2 * i + 1;
	}

	// Right child...
	public int right(int i) {
		return 2 * i + 2;
	}

	// Data at node i ...
	public double data(int i) {
		return heap[i].frq;
	}

	//A Nodal-Swap function to swap the nodes at the given two indices..
	public void swap(int a, int b) {
		Node t = heap[a];
		heap[a] = heap[b];
		heap[b] = t;
	}

	//Insertion of Node in the MaxHeap 
	public void insertN(Node e) {
		heap[++hSize] = e;

		int c = hSize;
		int p = parent(c);

		while (p >= 0 && c > 0) {
			if (data(p)< data(c))
				swap(p, c);
			c = p;
			p = parent(c);
		}
	}

	//This function returns the Node consisting of the highest frequency using maxHeapify
	public Node maxExtract() {
		Node max = heap[0];
		heap[0] = heap[hSize--];
		maxHeapify(0);

		return max;
	}


    /*
    * A recursive function starting from the root iterates through the heap to 
    * find the max Frequency then rearranges the whole heap and return the max value root.
    */
	
	private void maxHeapify(int n) {
		int l = left(n);
		int r = right(n);

		Node large = heap[n];
		int sIndex = n;

		// Checking the left child ...
		if (l < hSize + 1 && large.frq < heap[l].frq) {
			large = heap[l];
			sIndex = l;
		}
		// Checking the right child...
		if (r < hSize + 1 && large.frq < heap[r].frq) {
			large = heap[r];
			sIndex = r;
		}

		if (sIndex != n && sIndex <= hSize) {
			swap(n, sIndex);
			maxHeapify(sIndex);
		}

	}

	public boolean isEmpty() {
		return hSize == -1;
	}

	//A test function to check the parents and their children
	public void print() {
		for (int i = 0; i < hSize / 2; i++) {
			System.out.print(" PARENT : " + heap[i].chr + ":" + heap[i].frq + " LEFT CHILD : " + heap[left(i)].chr + ":"
					+ heap[left(i)].frq + " RIGHT CHILD :" + heap[right(i)].chr + ":" + heap[right(i)].frq);
			System.out.println();
		}
	}

	/* This function calls the Node array created
	 * in the Read class and converts it into MaxHeap using the insertN..
	 */
	public void fromNodeArray(Read.Node[] a) {
		for (int i = 0; i < a.length; i++) {
			Node t = new Node(a[i].frq, a[i].chr);
			insertN(t);
		}

	}

	Node r = null;
	/*
	 * The algorithm is implemented here
	 * The max values from the heap are extracted 2 at a time
	 * These Node will be clubbed together to form a tree 
	 * with a new Root node as the sum of frequencies of the children
	 * and then the rootNode of tree will be put back in the max heap.
	 * This process occurs until only one element remains in the MaxHeap which will be the root of the Huffman Tree
	 */
			

	public Node[] algo(double d) {

		while (hSize > 0) {
			Node a = maxExtract();
			Node b = maxExtract();
			/* The Inversion method has to be re-applied while creating the root node */
			Node P = new Node(d / ((d / a.frq) + (d / b.frq)), '~');
			P.left = a;
			P.right = b;
			r = P;
			insertN(P);
		}
		printCode(r, "");
		System.out.println(" ");
		return heap;
	}
	
	public boolean isLeaf(Node root) {
		return root.left == null && root.right == null;
	}

	// The reason for creating a static tree is so that it can be called in the main Encode function in the Read Class..
	static BSTNode f = new BSTNode();
	
	/*
	 * While creating the parent root nodes the frq will be the sum of the children and chr will be '-'
	 * Hence to print the Huffman Code of the Charector in the BST we iterate through all the roots until we reach
	 * a leaf node.
	 * 
	 * printCode is a recursive function which stores the char and huffman code in a BST for ease in decoding..
	 * while we traverse left "0" is added to the huffman code and "1" for right..
	 * 					 34
	 * 			(0)   /     \  (1)
	 * 				23      g:1
	 * 		(0)	   /  \  (1)
	 * 			f:00  e:01
	 */
	public void printCode(Node root, String s) {

		if (isLeaf(root) && Read.isAllowed(root.chr)) {
			System.out.println(root.chr + ":" + s);
			f.insert(root.chr, s);
			return;
		}

		printCode(root.left, s + "0");
		printCode(root.right, s + "1");
		
	}
	public static BSTNode want_BST() {
		return f;
	}

}
