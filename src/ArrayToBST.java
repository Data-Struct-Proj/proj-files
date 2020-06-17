
public class ArrayToBST {
	class Node {
		int frq;
		char chr;
		int key;
		Node left, right;
		public Node(int f,char c) {
			frq=f;
			chr=c;
			Character c1 = Character.valueOf(c);
			key=c1.hashCode();
			left = right = null;
		}
	}
	Node root;
	public Node insert(char chr) {
		return root = insertReccursion(root, chr);
	}

	Node insertReccursion(Node root, char chr) {
		if (root == null) {
			root = new Node(1,chr);
			return root;
		}
		Character c1 = Character.valueOf(chr);
		int key=c1.hashCode();
		if (key < root.key)
			root.left = insertReccursion(root.left, chr);
		else
			root.right = insertReccursion(root.right, chr);
		return root;
	}
	public void inorder(char[] c) {
		inorderReccursion(root,c);
	}
	void inorderReccursion(Node root,char[] c) {
		if (root != null) {
			inorderReccursion(root.left,c);  
			root.frq=(int)(c.length/root.frq);
			System.out.print("\t"+root.chr+":"+root.frq);
			inorderReccursion(root.right,c);
		}
	}
    public Node search(Node root,char c) 
    { 
    	Character c1 = Character.valueOf(c);
        int key=c1.hashCode();
        while (root != null) { 
            if (key > root.key) 
                root = root.right; 
            else if (key < root.key) 
                root = root.left; 
            else
            {
            return root;
            }
        } 
        return null;
    }
	public boolean isEmpty()
	{
		return root==null;
	}	
	public void readArray(char[] c)
	{   Node temp;
		for(int i=0;i<c.length;i++)
	{  
		if(search(root,c[i])==null)
		{   
			temp=insert(c[i]);
		}
		else {
		 temp=search(root,c[i]);
		 temp.frq+=1;
		}
	} 
	}
	public static void main(String[] args)
	{
		char[] a= {'m','a','l','a','y','a','l','a','m'};
		ArrayToBST bst1=new ArrayToBST();
		bst1.readArray(a);
		bst1.inorder(a);
	}
}
