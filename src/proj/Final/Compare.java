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
	public void read_write() throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(new File(l1)));

		BufferedReader br1 = new BufferedReader(new FileReader(new File(l2)));
		
		linklist l = new linklist();
		
		int r, r1;
		double c=0;
		
		while ((r = br.read()) != -1) {
			c+=1;
		}
		
		while ((r1 = br1.read()) != -1) {
			l.append(r1);
		}
		System.out.println("Size is: " + c / 1024.0 + " KiloBytes for Ascii");
		System.out.println("Size is: " + l.com_bits() / 1024.0 + " KiloBytes for Huffman Compression");
		System.out.println("");
	}
	
	public boolean isAlpha(char s) {
		return Character.isLetter(s);
	}
	
	@SuppressWarnings("resource")
	public void rel(String loc1,String loc2) throws IOException {
		 Read n = new Read();
		 n.Encode(loc1);
		 BSTNode aa = n.want_BST();
		 BufferedReader br = new BufferedReader(new FileReader(new File(loc2)));
		 BufferedReader br1 = new BufferedReader(new FileReader(new File(loc1)));
		 int r,r1;
		 String c1="",c2="",tt="";
			while ((r = br.read()) != -1) {
				if(aa.search(aa.root,(char)r)!=null && isAlpha((char)r)) c1+=aa.search(aa.root,(char)r);	
				else c1+='0';
			}
			while ((r1 = br1.read()) != -1) {
				if(aa.search(aa.root,(char)r1)!=null && isAlpha((char)r1)) c2+=aa.search(aa.root,(char)r1);	
				else c2+='0';
			}
			System.out.println(c2.charAt(32));
			for(int i=0;i<c1.length();i++) {
			tt+= (char) (c1.charAt(i)^c2.charAt(i));
			}
			System.out.println(tt);
	}
	
	public static void main(String[] args) throws IOException {
		String s1 = "/Users/rohith/Desktop/Case1_Encoded.txt";
		String s2 = "/Users/rohith/Desktop/Case1.txt";
		Compare c = new Compare(s1, s2);
		c.read_write();
		
	}
}
