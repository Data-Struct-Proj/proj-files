package end_proj;
import java.io.*;

import end_proj.HuffmanMaxHeap.Node;

public class Decode {
	/*
	 * We load the encoded file using the MaxHeap (BST) we will traverse left if the char is 0 and right is the char is 1.
	 * When we rech the root leaf we will print the char in the node.
	 */
        String Out;
        //The read function will read the encoded file and store it as a String 
    	public String read(String loc) throws IOException {
    		String a="";
    		BufferedReader br = new BufferedReader(new FileReader(loc));
    		String nextLine = br.readLine();
    		
    		while (nextLine!=null) {
    			a+=nextLine;   
    			nextLine = br.readLine();
    		}
    		br.close();
    		return a;
    	}
    	
    	public void write(String loc) throws FileNotFoundException {   //when the file is not available it throws file not found exception 
    		PrintStream ps = new PrintStream(new FileOutputStream(loc));
    		ps.println(Out);
    		ps.close();
    	}
  
    /*
     * We load the encoded String in the decode and Use the MaxHeap created in the encoding process..
     * We traverse right if 1 and left if 0
     * The output will be a String which will be stored in a global variable.	
     */
	public void decode(String S,HuffmanMaxHeap.Node[] heap) {
		HuffmanMaxHeap.Node current = heap[0];
		String o ="";
		
	    while (!S.isEmpty()){
	    if (S.charAt(0) == '1'){
	    	current = current.right;
	    	S = S.substring(1);
	    }
	    else {
	    	current = current.left;
	    	S = S.substring(1);
	    }
	    if (current.left == null && current.right == null){
	    	o+=current.chr;
	  		current = heap[0];
	  	}
	  }
	     Out=o;
	}
 
    // We call the above functions ..
    public void decodeFile(Node[] a,String e) throws IOException {
    	 decode(read("/Users/rohith/Desktop/proj_output/"+e+"_Encoded.txt"),a);
 	     write("/Users/rohith/Desktop/proj_output/"+e+"_Decoded.txt");
    }


	public static void main(String[] args) throws IOException {
		Read n = new Read(0);
	    long startTime = System.currentTimeMillis();
		String l = "/Users/rohith/Desktop/Case1.txt";
		System.out.println("Huffman Codes : ");
	    HuffmanMaxHeap.Node[] a = n.Encode(l); 
	    System.out.println(("Runtime for Encoding : " + (System.currentTimeMillis() - startTime)+ " ms"));
	    long startTime_1 = System.currentTimeMillis();
	    
	    Decode f = new Decode();
	    f.decodeFile(a,n.loc());
	    System.out.println(("Runtime for Decoding : " + (System.currentTimeMillis() - startTime_1)+ " ms"));
	    

	}
}