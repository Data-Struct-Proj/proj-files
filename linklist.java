package projects;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class linklist {

	class Node {
		int data;
		Node next;

	public Node(int d) { 
			data = d;
			next = null;
		}
	}

	Node start = null;
	Node last = null;

	public void append(int x) { 
		if (start == null) { 
			start = last = new Node(x);
			
		}
		else { 
			last.next = new Node(x);
			last = last.next;
		}
	}



	public boolean isEmpty() { 
		return (start == null);
	}

	public int com(){
		int count=0;
		for(Node p = start; p!= null; p = p.next) { 
			
			if(p.data==32||p.data==10||p.data>=65&&p.data<=90||p.data>=97&&p.data<=122) {
				count=(count+1);	
		}
		
	}
		
		return count;
	}
	public float com1(){
		float count=0;
		for(Node p = start; p!= null; p = p.next) { 
			
					count=(count+1);	
		
		
	}
		count=count/8;
		return count;
	}
	public void store() throws IOException {
		 BufferedWriter g =new BufferedWriter(new FileWriter("C:\\Users\\srina\\Desktop\\taylorswift.txt")) ;
		for(Node p = start; p!= null; p = p.next) {
	    g.write(p.data);
		}
		g.close();
	}

	public static void main(String [] args) { 
		linklist lin = new linklist();
		
	}
}