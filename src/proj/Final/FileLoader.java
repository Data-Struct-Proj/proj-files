package end_proj;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;


public class FileLoader {
	String loc,loc_1,img;
	public void Encode_Decode() throws IOException {
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		File file = chooser.getSelectedFile();
		loc=file.getPath();
		System.out.println("You have selected: " + loc);
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
		System.out.println("0 - Only Characters");
		System.out.println("1 - Characters Numbers and Spaces");
		System.out.println("2 - All Inputs");
		System.out.println("Choose : ");
		String str= sc.nextLine();
		int i=Integer.parseInt(str);
		Read n = new Read(i);
		long startTime = System.currentTimeMillis();
		System.out.println("");
		System.out.println("Huffman Code :");
		System.out.println("");
		HuffmanMaxHeap.Node[] a = n.Encode(loc); 
	    System.out.println(("Runtime for Encoding : " + (System.currentTimeMillis() - startTime)+ " ms"));
	    long startTime_1 = System.currentTimeMillis();
	    Decode f = new Decode();
	    f.decodeFile(a,n.loc());
	    System.out.println(("Runtime for Decoding : " + (System.currentTimeMillis() - startTime_1)+ " ms"));
	}
	public void Compare() throws IOException {
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		File file = chooser.getSelectedFile();
		loc_1=file.getPath();
		System.out.println("You have selected: " + loc_1);
		Compare c = new Compare(loc, loc_1);
		c.read_write_1();
	}
	public void ImgEnc() throws IOException {
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		File file = chooser.getSelectedFile();
		img=file.getPath();
		System.out.println("You have selected: " + img);
		ImgEnc a=new ImgEnc(img);
	    String c=a.imgEncode();
	    a.decoder(c, "/Users/rohith/Desktop/proj_output/Image_Dec.jpg");
	}
	@SuppressWarnings("resource")
	public void Sel() throws IOException {
		System.out.println("Choose : \n 1-Encoding_Decoding \n 2-Image_Encryption");
		Scanner sc= new Scanner(System.in);
		String str= sc.nextLine();
		int i=Integer.parseInt(str);
		if(i==1) {
			Encode_Decode();
			Compare();
		}
		else if (i==2) ImgEnc();
		else {
			System.out.println("Error!");
			Sel();
		}
		
	}
	public static void main(String[] args) throws IOException {
		FileLoader a = new FileLoader();
		a.Sel();
	}
}
