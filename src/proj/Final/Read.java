package end_proj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Read {
    /*
     * c is the length of the char[] or the no of char in the text file
     * count is the pointer variable of the char[]
     * i is the pointer variable of Node Array.
     */
	
	int count;
	int c = 0;
	int i=0;
	static int choice;
    String e;
	Node[] cc = new Node[80];
	public HuffmanMaxHeap.Node[] h;
	
	public Read(int a) {
	choice = a;
	}

	// A function is created to check for alphabets and specified special Chars...
	public static boolean isAllowed(char s) {
		if(choice ==0) return Character.isLetter(s);
		
		else if (choice==1) {
		return Character.isLetter(s)|| s == ' ' || s == '\n' ||Character.isDigit(s);
		}
		else return true;
	}
	
	public boolean isAlpha(char s) {
		return Character.isLetter(s);
	}

	/*
	 * A function to read the original file char by char and stores 
	 * every char in a char[] array
	 * We used an iterator and a reader ; 
	 * An iterator to count the no. of char which makes it easy to initialise the char[]
	 */
	
	@SuppressWarnings("resource")
	public char[] read(String loc) throws IOException {
		BufferedReader reader, iterator;

		reader = new BufferedReader(new FileReader(loc));
		iterator = new BufferedReader(new FileReader(loc));

		int r, it;
		//Iterator loop
		while ((it = iterator.read()) != -1) {
			char ch1 = (char) it;
			if (isAllowed(ch1) ) {
				c++;
			}
		}
		//Initialising the array using the iterator..
		char[] a = new char[c];
		
		//Reader loop
		while ((r = reader.read()) != -1) {
			char ch = (char) r;
			if (isAllowed(ch)) {
				a[count++] = ch;
			}
		}
		return a;
	}
	//We create a sub-class Node, for initializing a BST that stores the char,frequency of the char and the hashCode value of the char
	class Node {
		double frq;
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
	//Root element of the BST
	Node root;

	// The recursive insert id called to insert the Node object in the BST
	public Node insert(char chr) {
		return root = insertReccursion(root, chr);
	}

	private Node insertReccursion(Node root, char chr) {
		if (root == null) {
			root = new Node(1, chr);
			return root;
		}
		Character c1 = Character.valueOf(chr);
		int key = c1.hashCode();
		if (key < root.key)
			root.left = insertReccursion(root.left, chr);
		else
			root.right = insertReccursion(root.right, chr);
		return root;
	}
	
	/*A function to call inorderRecurrsion starring from the root node.
	 * This traversal will be used to display the char and its frequency in the text file.
	 */
	public void inorder() {
		inorderReccursion(root);
	}

	private void inorderReccursion(Node root) {
		if (root != null) {
			inorderReccursion(root.left);
			root.frq = count / root.frq;
			System.out.print(root.chr + ":" + root.frq + " ");
			inorderReccursion(root.right);
		}
	}
	
	/*
	 * Since the Huffman Algorithm neccesitates the removal of minimum frequency from the Data Structure and form further trees.
	 * Since we are using a Max heap and we need a min value we developed a method to invert the max values to min and vice-versa.
	 */
	
	private Node[] traverse(Node root) {
		if (root != null) {
			traverse(root.left);
			root.frq = (count / root.frq);
			cc[i++] = root;
			traverse(root.right);
		}
		return cc;
	}

	/* We are initially creating a char[] cc with size 28 (all alphabets , spaces and new line) but in case not all 
	 * indices are used we diminish the char[] to the required length to avoid Null-Pointer error.
	 */
	public Node[] convertToArray() {
		Node[] temp = traverse(root);
		Node[] a = new Node[i];
		for (int j = 0; j < i; j++)
			a[j] = temp[j];
		return a;
	}

	
	//Creating a function to recursively iterate and find min and max values in the BST
	public double max() {
		return maxValue(root);
	}

	public double min() {
		return minValue(root);
	}

	private double maxValue(Node node) {
		/* loop down to find the rightmost leaf */
		Node current = node;
		while (current.right != null)
			current = current.right;

		return (current.frq);
	}

	private double minValue(Node node) {
		/* loop down to find the rightmost leaf */
		Node current = node;
		while (current.left != null)
			current = current.left;

		return (current.frq);
	}

	//This function returns a Node for traversal and searching for a specific char using its hashCode
	public Node search(Node root, char c) {
		Character c1 = Character.valueOf(c);
		int key = c1.hashCode();
		while (root != null) {
			if (key > root.key)
				root = root.right;
			else if (key < root.key)
				root = root.left;
			else {
				return root;
			}
		}
		return null;
	}

	public boolean isEmpty() {
		return root == null;
	}
	
	/*
	 * After creating a char[] array which is not a set , to avoid repetitions and count the frequency of the char each time 
	 * it occurs in the char[] 
	 * the output is a BST Set of Nodes with char,hashCode of char and frequency.
	 */
	
	public void readArray(char[] c) {
		Node temp;
		for (int i = 0; i < count; i++) {
			if (search(root, c[i]) == null) {
				temp = insert(c[i]);
			} else {
				temp = search(root, c[i]);
				temp.frq += 1;
			}
		}
	}
	
	/* A function to all all the above defined function in a progressive way..
	 * The BST built is broken down to a Node[] which consists of char,hashCode of char and frequency.
	 */
	
	public Node[] fromBSTtoNodeArray(String a) throws IOException {
		readArray(read(a));
		return convertToArray();
	}
	
	/*
	 * Another class called HuffmanMaxHeap is called which will abide by the rules of a MaxHeap customised
	 * to the Huffman Algorithm.
	 * The Node array created in the above step will be converted to a HuffmanMaxHeap.
	 */
	
	public HuffmanMaxHeap fromNodeArraytoMaxHeap(Node[] a) {
		HuffmanMaxHeap A = new HuffmanMaxHeap(a.length);
		A.fromNodeArray(a);
		return A;
	}
	
	@SuppressWarnings("static-access")
	public HuffmanMaxHeap.Node[] Encode(String loc) throws IOException {
		Node[] a = fromBSTtoNodeArray(loc);
		HuffmanMaxHeap A = fromNodeArraytoMaxHeap(a);
		/* The further steps will be explained in the other classes */
		h = A.algo(count);
		
		BSTNode f = A.f;
		StringBuffer loc1 = new StringBuffer(loc);
        loc1.reverse();
        StringBuffer aa = new StringBuffer(loc1.substring(4,loc1.indexOf("/")));
        aa.reverse();
        e=aa.toString();
        
		f.encode(read(loc), "/Users/rohith/Desktop/proj_output/"+e+"_Encoded.txt");
		return h;
	}
	
	public String loc() {
		return e;
	}
	
	public BSTNode want_BST() {
		return HuffmanMaxHeap.want_BST();
	}
}

 