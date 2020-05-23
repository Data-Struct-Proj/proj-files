package projects;

import java.io.*;
public class Compare {	
	public Compare(String l1,String l2) throws IOException {
		File f=new File(l1);    
	    FileReader fr=new FileReader(f);  
	    BufferedReader br=new BufferedReader(fr);
	    File f1=new File(l2);     
	    FileReader fr1=new FileReader(f1);  
	    BufferedReader br1=new BufferedReader(fr1);
	    linklist lin = new linklist();
	    linklist lin1 = new linklist();
	    int r,r1;
	    BufferedWriter g =new BufferedWriter(new FileWriter("C:\\Users\\srina\\Desktop\\taylor.txt")) ;

	    while ((r = br.read()) != -1) {
	    	
	        lin.append(r);
	        g.write((int)r);
	}
	    g.close();
	    lin.store();
	    while ((r1 = br1.read()) != -1) {
	        lin1.append(r1);
	        
	}
	    System.out.println("Size is:"+lin.com()+" bytes for Ascii");
	    System.out.println("Size is:"+lin1.com1()+" bytes for Huffman");
	    
	}
	
		
	
public static void main(String[] args) throws IOException {
	String s1="C:\\Users\\srina\\Desktop\\test.txt";
	String s2="C:\\Users\\srina\\Desktop\\trial.txt";
	Compare c=new Compare(s1,s2);//System.out.println("\n".hashCode());
}
}
