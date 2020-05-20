package end_proj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Encode2 {
    int count = 0;
	int i=0;
	Node[] cc=new Node[100];
	public boolean isAlpha(char s) {
		return Character.isLetter(s);
	}
	
	@SuppressWarnings("resource")
	public char[] read(String loc) throws IOException {
		BufferedReader reader;
		char[] a = new char[1000];
		reader = new BufferedReader(new FileReader(loc));
		int i;
		while ((i = reader.read()) != -1) {
			char ch = (char) i;
			if (isAlpha(ch)) {
				a[count++] = Character.toLowerCase(ch);
			}
		}
		return a;
	}

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
	}

    Node root;

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

	public Node[] convertToArray()
	{
		
		Node[] temp=traverse(root);
		Node[]a = new Node[i];
		for(int j=0;j<i;j++) a[j]=temp[j];
		return a;
	}
	
	private Node[] traverse(Node root) {
		if (root != null) {
			traverse(root.left);
			root.frq = count / root.frq;
			cc[i++]=root;
			traverse(root.right);
		}
		return cc;
	}

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

	public static void main(String[] args) throws IOException {
		Encode2 n = new Encode2();
		String loc = "/Users/rohith/Desktop/trial.txt";
		n.readArray(n.read(loc));
		//n.inorder();
		Node[] a=n.convertToArray();
        for(int ii=0;ii<a.length;ii++)
        {
        	System.out.print(a[ii].chr);
        }
        
	}

}