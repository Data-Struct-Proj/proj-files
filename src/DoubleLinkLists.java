package linklists;

public class DoubleLinkLists  {
	public class Node {
		int data;
		Node next;
		Node prev;
		public Node(int a) {
			data=a;
			next=null;
			last=null;
		}
	};
	Node start=null;
	Node last=null;
	int size=0;
	public void append(int d) {
		Node a = new Node(d);
		if (start==null) {
			start=last=a;
			size++;
		}
		else {
			Node s = start;
			while(s.next!=null) {
				s=s.next;
			}
			s.next=a;
			a.prev=s;
			a.prev=null;
			size++;
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
	
	public void insert(int pos,int d) {
		Node s = new Node(d);
		
		if(start==null) {
			start=last=s;
		}
		else {
			Node r = start;
			for(int i=0;i<pos-2;i++) {
					r=r.next;
			}
			s.next=r.next;
			r.next.prev=s;
			s.prev=r;
			r.next=s;
			
		}
		size++;
	}
	public void pandn(int r) {
		Node s=start;
		for (int i =0;i<size;i++) {
		
			if(s.data==r) {
				
				if(s.prev==null) {
					System.out.println("Previous :null Next :"+s.next.data);
					break;         
				}
				else if(s.next==null) {
					System.out.println("Previous:"+s.prev.data+" Next:null");
					break;
				}
				else
				System.out.println("Previous:"+s.prev.data+" Next:"+s.next.data);
			}
			s=s.next;
		}
	}
		public void delete(int pos) {
			Node n = start;
			for (int i=0;i<pos-2;i++) {
				n=n.next;
			}
			n.next=n.next.next;
			n.next.prev=n;
		}
			
		
	public static void main(String[] args) {
		DoubleLinkLists dl = new DoubleLinkLists();
		dl.append(4);
		dl.append(5);
		dl.append(8);
		dl.append(2);
		dl.append(67);
		dl.print();
		System.out.println(" ");
		dl.insert(2,9);
		dl.print();
		System.out.println(" ");
		dl.pandn(5);
		System.out.println(" ");
		dl.delete(3);
		dl.print();
		System.out.println(" ");
		dl.pandn(4);
	}
	
}
