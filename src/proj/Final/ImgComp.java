package end_proj;

import java.io.*;
import java.util.Base64;

public class ImgComp {
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
		@SuppressWarnings("resource")
		public static void main(String[] args) throws IOException {
		    String imagePath = "/Users/rohith/Desktop/tr.jpg";
		    ImgComp a=new ImgComp(imagePath);
		    String B64 = a.encoder();
		    System.out.println("Base64ImageString = " + B64);
		    a.decoder(B64, "/Users/rohith/Desktop/tr_1.jpg");
		    System.out.println(B64.length());
		    String l = "/Users/rohith/Desktop/proj_output/Image.txt";
			PrintStream ps = new PrintStream(new FileOutputStream(l));
    		ps.println(B64);
    		ps.close();
    		Read N = new Read();
    	    HuffmanMaxHeap.Node[] A = N.Encode(l); 
    	    Decode F = new Decode();
    	    F.decodeFile(A,N.loc());
    	    BufferedReader iterator = new BufferedReader(new FileReader("/Users/rohith/Desktop/proj_output/Image_Decoded.txt"));
    		int it;
    		String c="";
    		//Iterator loop
    		while ((it = iterator.read()) != -1) {
    			char ch1 = (char) it;
    				c+=ch1;	
    		}
    		System.out.println(c);
    	    a.decoder(c, "/Users/rohith/Desktop/proj_output/Image_Dec.png");
		  }
		String imagePath;
		public ImgComp(String f)
		{
		 imagePath=f;
		}
		 
}
