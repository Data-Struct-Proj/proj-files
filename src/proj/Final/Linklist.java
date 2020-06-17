package end_proj;

public class linklist {
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
	
	public double com_bits(){
		double count=0;
		for(Node p = start; p!= null; p = p.next) { 
			count+=1;	
	}
		return count/8;
	}
	public void print() {
		Node node = start;

		while (node.next != null) {
			System.out.println(node.data);
			node = node.next;
		}
		System.out.println(node.data);
	}

}
