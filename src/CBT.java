package tree;

public class CBT {
	int[] a = new int[100];
	int size = 0;

	public boolean isEmpty() {
		return size == 0;
	}

	public int leftnode(int d) {
		int i = pos(d);
		if (2 * i + 1 <= size)
			return (a[2 * i + 1]);
		else
			return 0;
	}

	private int left(int i) {
		return (2 * i + 1);
	}

	public int rightnode(int d) {
		int i = pos(d);
		if (2 * i + 2 <= size)
			return (a[2 * i + 2]);
		else
			return 0;
	}

	private int right(int i) {
		return (2 * i + 2);
	}

	public void append(int d) {
		a[size++] = d;
		int p,temp;
		int rr = size-1;
		while(rr>0) {
			p=parent(rr);
			if(a[p]>a[rr]) {
				temp = a[p];
				a[p]=a[rr];
				a[rr]=temp;
			}
			rr=p;
		}
		
	}
	
	public void insert(int p , int d) {
		int[] b = new int[2*size];
		for (int ii =0;ii<p;ii++) b[ii]=a[ii];
		b[p]=d;
		for (int i=p+1;i<a.length;i++) b[i]=a[i];
		a=b;
	}

	public void delete() {
		if (isEmpty())
			System.out.println("Underflow");
		else
			size--;
	}

	public void delete(int p) {
		if (isEmpty())
			System.out.println("Underflow");
		else {
			int i = pos(p);
			for (int aa = i; aa < a.length - 1; aa++)
				a[aa] = a[aa + 1];
			a[a.length] = 0;
		}
	}

	public int parentnode(int d) {
		int i = pos(d);
		return (a[(i - 1) / 2]);
	}
	
	public int parent(int d) {
		return ((d - 1) / 2);
	}

	private int pos(int d) {
		int p = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == d)
				p = i;
			else
				continue;
		}
		return p;
	}

	private void inorderRecur(int r) {
		if (r >= size) {
			return;
		} else {
			inorderRecur(left(r));
			System.out.print(a[r] + " ");
			inorderRecur(right(r));
		}

	}

	public void inorder() {
		System.out.println("Inorder:");
		inorderRecur(0);
		System.out.println();
	}

	private void preorderRecur(int r) {
		if (r >= size) {
			return;
		} else {
			System.out.print(a[r] + " ");
			inorderRecur(left(r));
			inorderRecur(right(r));
		}

	}

	public void preorder() {
		System.out.println("Preorder:");
		preorderRecur(0);
		System.out.println();
	}

	private void postorderRecur(int r) {
		if (r >= size) {
			return;
		} else {

			inorderRecur(left(r));
			inorderRecur(right(r));
			System.out.print(a[r] + " ");
		}

	}

	public void postorder() {
		System.out.println("Postorder:");
		postorderRecur(0);
		System.out.println();
	}

	public static void main(String[] args) {
		CBT a = new CBT();
		a.append(5);
		a.append(7);
		a.append(6);
		a.append(2);
		a.append(10);
		a.append(20);
		a.append(15);
		a.append(1);
		a.preorder();
	}

	public void print() {
		// TODO Auto-generated method stub
		
	}
}
