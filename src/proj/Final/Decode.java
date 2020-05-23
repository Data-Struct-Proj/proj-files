package proj;
import java.io.*;

import end_proj.HuffmanMaxHeap.Node;

public class Decode {
        String Out;
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
  
    	
	public void decode(String S,end_proj.HuffmanMaxHeap.Node[] heap) {
		end_proj.HuffmanMaxHeap.Node current = heap[0];
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
 
    public void decodeFile(Node[] a) throws IOException {
    	 decode(read("/Users/rohith/Desktop/Output_Encoded.txt"),a);
 	     write("/Users/rohith/Desktop/Output_Decoded.txt");
    }
	public static void main(String[] args) throws IOException {
		Read n = new Read();
		String loc = "/Users/rohith/Desktop/trial.txt";
	    end_proj.HuffmanMaxHeap.Node[] a = n.Encode(loc);
	    Decode f = new Decode();
	    f.decodeFile(a);
	   

	}
}