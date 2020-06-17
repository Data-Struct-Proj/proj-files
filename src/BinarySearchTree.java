package tree;

import java.util.*;

public class BinarySearchTree {
	public class Node {
		int data;
		Node l;
		Node r;

		public Node(int a) {
			data = a;
			l = r = null;
		}

		public boolean isLeaf() {
			return (r == null && l == null);
		}

	};

	Node root = null;

	public boolean isEmpty() {
		return (root == null);
	}

	private Node insertRecur(int e, Node r) {
		if (r == null) {
			r = new Node(e);
		} 
		else {
			if (e < r.data) {
				r.l = insertRecur(e, r.l);
			} else {
				r.r = insertRecur(e, r.r);

			}

		}
		return r;
	}

	public void insert(int e) {
		root = insertRecur(e, root);
	}

	private Node preorderRecur(Node r) {
		if (r == null) {
			{}//System.out.print('-');
		} else {
			System.out.print(r.data+" ");
			preorderRecur(r.l);
			preorderRecur(r.r);
		}
		return r;
	}

	public void preorder() {
		System.out.println("Preorder:");
		preorderRecur(root);
		System.out.println();
	}
	
	private Node postorderRecur(Node r) {
		if (r == null) {
			{}//System.out.print('-');
		} else {
			postorderRecur(r.l);
			postorderRecur(r.r);
			System.out.print(r.data+" ");
		}
		return r;
	}

	public void postorder() {
		System.out.println("Postorder:");
		postorderRecur(root);
		System.out.println();
	}
	
	private Node inorderRecur(Node r) {
		if (r == null) {
			{}//System.out.print('-');
		} else {
			
			inorderRecur(r.l);
			System.out.print(r.data+ " ");
			inorderRecur(r.r);
			
		}
		return r;
	}

	public void inorder() {
		System.out.println("Inorder:");
		inorderRecur(root);
		System.out.println();
	}
	public void deleteKey(int key) { 
	        root = deleteRec(root, key); 
	    } 
	 
	private Node deleteRec(Node root, int key)  { 
	        if (root == null) {
	        	return root; 
	        }
	  

	        if (key < root.data) 
	            root.l = deleteRec(root.l, key); 
	        else if (key > root.data) 
	            root.r = deleteRec(root.r, key); 
	  
	        else
	        { 
	          
	            if (root.l == null) 
	                return root.r; 
	            else if (root.r == null) 
	                return root.l; 
	            root.data = minValue(root.r); 
	            root.r = deleteRec(root.r, root.data); 
	        } 
	  
	        return root; 
	    } 
	  
	    int minValue(Node root) 
	    { 
	        int minv = root.data; 
	        while (root.l != null) 
	        { 
	            minv = root.l.data; 
	            root = root.l; 
	        } 
	        return minv; 
	    } 
	    public void find(int a) {
	    	root=findrec(a,root);
	    }
	    private Node findrec(int a,Node rr) {
	    	
	    	if (rr == null) { 
	    		System.out.println("Not found"); 
	    		return rr; 
	    	}
	    	
	    	else if ( a==rr.data) {
	    		return rr;
	    	}
	    	else if(a>rr.data) {
	    		rr.r=findrec(a,rr.r);
	    	}
	    	else if(a<rr.data) {
	    		rr.l=findrec(a,rr.l);
	    	}
	    	System.out.println("Found"); 
	    	return rr;
	    }
	    
	    
	    public void BreadthFirstTraversal() {
	    	Queue <Node> l = new LinkedList<Node>();
	    	l.add(root);
	    	while(!l.isEmpty()) {
	    		Node n=l.remove();
	    		System.out.print(n.data+" ");
	    		if(n.l!=null) {
	    			l.add(n.l);
	    		}
	    	    if(n.r!=null){
	    			l.add(n.r);
	    		}
	    	}
	    	System.out.println();
    		
	    	}
	    

	public static void main(String[] args) {
		BinarySearchTree s = new BinarySearchTree();
		s.insert(10);
		s.insert(15);
		s.insert(5);
		s.insert(17);
		s.insert(3);
		s.insert(13);
		s.insert(7);
		s.insert(2);
		s.insert(4);
		s.insert(12);
		s.insert(14);
		s.insert(18);
		s.inorder();
		s.preorder();
		s.postorder();
		//s.deleteKey(10);
		//s.insert(10);
		s.preorder();
		s.BreadthFirstTraversal();
		s.find(180);

	}
}
