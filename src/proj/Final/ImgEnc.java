package end_proj;

import java.io.*;
import java.util.Base64;

public class ImgEnc {
	File a;
	String imagePath;
	public ImgEnc(String f)
	{
	 imagePath=f;
	 a = new File(f); 
	}
	
	@SuppressWarnings("resource")
	public String imgEncode() throws IOException {
		ImgEnc a=new ImgEnc(imagePath);
		String B64 = a.encoder();
		System.out.println("Base64ImageString = " + B64);
		System.out.println(B64.length());
		String l = "/Users/rohith/Desktop/proj_output/Image.txt";
		PrintStream ps = new PrintStream(new FileOutputStream(l));
 		ps.println(B64);
 		ps.close();
 		Read N = new Read(2);
 	    HuffmanMaxHeap.Node[] A = N.Encode(l); 
 	    Decode F = new Decode();
 	    F.decodeFile(A,N.loc());
 	    BufferedReader iterator = new BufferedReader(new FileReader("/Users/rohith/Desktop/proj_output/Image_Decoded.txt"));
 		int it,cc=0;
 		String c = "";
 		//Iterator loop
 		while ((it = iterator.read()) != -1) {
 			char ch1 = (char) it;
 				c+=ch1;	
 				cc++;
 		}
 	   
 	    File image = new File(imagePath);
 		double bytes = image.length();
 		System.out.println("Size is: " +bytes/1024.0+ " KiloBytes (Image)");
 		String s1 = "/Users/rohith/Desktop/proj_output/Image.txt";
		String s2 = "/Users/rohith/Desktop/proj_output/Image_Encoded.txt";
		Compare r = new Compare(s1, s2);
		r.read_write_1();
 		return c.substring(0, cc-2);
	}
	
	  public  String encoder() {
	    String base64Image = "";
	    File file = new File(imagePath);
	    try (FileInputStream imageInFile = new FileInputStream(file)) {
	      // Reading a Image file from file system
	      byte imageData[] = new byte[(int) file.length()];
	      imageInFile.read(imageData);
	      base64Image = Base64.getEncoder().encodeToString(imageData);
	    } catch (FileNotFoundException e) {
	      System.out.println("Image not found" + e);
	    } catch (IOException ioe) {
	      System.out.println("Exception while reading the Image " + ioe);
	    }
	    return base64Image;
	  }
	 
	  public void decoder(String base64Image, String pathFile) {
	    try (FileOutputStream imageOutFile = new FileOutputStream(pathFile)) {
	      // Converting a Base64 String into Image byte array
	      byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
	      imageOutFile.write(imageByteArray);
	    } catch (FileNotFoundException e) {
	      System.out.println("Image not found" + e);
	    } catch (IOException ioe) {
	      System.out.println("Exception while reading the Image " + ioe);
	    }
	  }
	  
		public static void main(String[] args) throws IOException {
		    String imagePath = "/Users/rohith/Desktop/12.jpg";
		    ImgEnc a=new ImgEnc(imagePath);
		    String c=a.imgEncode();
		    a.decoder(c, "/Users/rohith/Desktop/proj_output/Image_Dec.jpg");
		  }
		
		
		 
}
