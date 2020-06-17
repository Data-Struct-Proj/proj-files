package hash;

public class HashMap {
	
	class Data {
		int key;
		String value;
		
		public Data(int k,String v){
			key=k;
			value=v;
		}
		
		public boolean equals(Data that) {
			return (this.key==that.key);
		}
		
		public int hashCode() {
			return key;
		}
	};
	
	class Node{
		Data data;
		Node next,prev;
		
		public Node(Data d) {
			data = d;
			next=prev=null;
		}
	};
	
	Node[] map;
	
	public HashMap(int size) {
		map=new Node[size];
	}
	
	public int hash(Data n) {
		return n.hashCode() % map.length;
	}
	
	public void put(int k ,String v) {
		Data d = new Data (k,v);
		int h = hash(d);
		Node n = new Node(d);
		
		if (map[h]==null)
			map[h]=n;
		else {
			Node ptr = map[h];
			for(;ptr.next!=null;ptr=ptr.next); 
			ptr.next = n;
			n.prev=ptr;
		}
	}
	public String get(int k) {
		int h = k%map.length;
		
		Node ptr = map[h];
		while(ptr!=null && ptr.data.key!=k) {
			ptr = ptr.next;
		}
		return (ptr==null) ? null:ptr.data.value; //else is a colon,? is a then
	}
}
