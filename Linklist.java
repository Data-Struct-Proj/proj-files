package linklists;

public class Linklist {
	public class Node {
		int data;
		Node next;
	};
	Node start; 
 
	public void append(int data) {
		Node node = new Node(); 
		node.data = data;
		node.next = null;
		if (start == null) { 
			start = node;
		}
		else {
			Node n = start;
			while (n.next != null) {  
				n = n.next;
			}
			n.next = node;
		}
	}

	public void insert(int index, int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;

		if (index == 0) {
			node.next = start;
			start = node;
		} else {
			Node n = start;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			node.next = n.next;
			n.next = node;
		}
	}

	public void delete(int index) {
		if (index == 0) {
			start = start.next;
		} 
		else {
			Node n = start;
			Node n1 = null;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			n1 = n.next;
			n.next = n1.next;
			n1 = null;
		}
	}

	public void print() {
		Node node = start;

		while (node.next != null) {
			System.out.println(node.data);
			node = node.next;
		}
		System.out.println(node.data);
	}
	public static void main(String[] args) {

		Linklist list = new Linklist();
		list.append(1);
		list.append(4);
		list.append(2);
		list.append(1);
		list.append(3);
		list.append(6);
		list.append(8);
		list.print();
		System.out.println("");
		list.insert(2, 55);
		list.print();
		System.out.println("");
		list.delete(3);

		list.print();
	}
}
