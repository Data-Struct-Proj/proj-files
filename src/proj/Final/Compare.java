package end_proj;

import java.io.*;


public class Compare {
	String l1,l2;
	
	public Compare(String a1, String a2) throws IOException {
		l1=a1;
		l2=a2;
	}
	
	/*
	 * We Take the encoded file and the original file 
	 * The bits in the encoded file is counted and the ASCII bits of the original file 
	 * The size is compared..
	 */
	
	@SuppressWarnings({ "resource", "unused" })
	public void read_write_1() throws IOException {
		
		File br = new File(l1);
		BufferedReader br1 = new BufferedReader(new FileReader(new File(l2)));
		
		linklist l = new linklist();
		
		int r, r1;
		double c=0;
		
		
		while ((r1 = br1.read()) != -1) {
			c+=1;
		}
		System.out.println("Size is: " + br.length() / 1024.0 + " KiloBytes for Ascii");
		System.out.println("Size is: " + c *0.000125 + " KiloBytes for Huffman Compression");
		System.out.println("");
	}
	
	public boolean isAlpha(char s) {
		return Character.isLetter(s);
	}
	
	
	public static void main(String[] args) throws IOException {
	
		String ss = "/Users/rohith/Desktop/Case1.txt";
		String ss1 = "/Users/rohith/Desktop/proj_output/Case1_Encoded.txt";
		
		Compare c1 = new Compare(ss, ss1);
		c1.read_write_1();
		
	}
}
