package end_proj;

public class MaxHeap {

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

	public Node[] heap;

	public int hSize;

	public MaxHeap(int size) {
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

	public void swap(int a, int b) {
		Node t = heap[a];
		heap[a] = heap[b];
		heap[b] = t;
	}

	public void insertN(Node e) {
		heap[++hSize] = e;

		int c = hSize;
		int p = parent(c);

		while (p >= 0 && c > 0) {
			if (heap[p].frq < heap[c].frq)
				swap(p, c);
			c = p;
			p = parent(c);
		}
	}

	public Node maxExtract() {
		Node max = heap[0];
		heap[0] = heap[hSize--];
		maxHeapify(0);

		return max;
	}

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

	public void print() {
		for (int i = 0; i < hSize / 2; i++) {
			System.out.print(" PARENT : " + heap[i].chr + ":" + heap[i].frq + " LEFT CHILD : " + heap[left(i)].chr + ":"
					+ heap[left(i)].frq + " RIGHT CHILD :" + heap[right(i)].chr + ":" + heap[right(i)].frq);
			System.out.println();
		}
	}

	// end_proj Node is a different thing so we use that here.
	public void fromNodeArray(end_proj.Read.Node[] a) {
		for (int i = 0; i < a.length; i++) {
			Node t = new Node(a[i].frq, a[i].chr);
			insertN(t);
		}

	}

	Node r = null;

	public Node[] algo(double d) {

		while (hSize > 0) {
			Node a = maxExtract();
			Node b = maxExtract();
			Node P = new Node(d / ((d / a.frq) + (d / b.frq)), (a.chr));
			// System.out.println(a.chr+" "+b.chr);
			P.left = a;
			P.right = b;
			r = P;
			insertN(P);
		}
		printCode(r, "");
		return heap;
	}

	BSTNode f = new BSTNode();

	public void printCode(Node root, String s) {

		if (root.left == null && root.right == null
				&& (Character.isLetter(root.chr) || root.chr == ' ' || root.chr == '\n')) {

			// c is the character in the node
			System.out.println(root.chr + ":" + s);
			f.insert(root.chr, s);
			return;
		}

		printCode(root.left, s + "0");
		printCode(root.right, s + "1");
	}

}
