package end_proj;

import end_proj.MaxHeap.Node;

public class Huffman {
	MaxHeap A = new MaxHeap(30);
public Huffman(MaxHeap a) {
	A=a;
	}

void algo() {
	Node root =null;
	while(A.hSize>1) {
		Node a = A.maxExtract();
		Node b = A.maxExtract();
		
		MaxHeap.Node P = new MaxHeap.Node(a.frq+b.frq,'-');
	}
}
	public static void main(String[] args) {
		
	}
}

