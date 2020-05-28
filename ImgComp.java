package ImgCmp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
		public static void main(String[] args) {
		    String imagePath = "C:\\Users\\User\\Desktop\\Sample.jpg";
		    ImgComp a=new ImgComp(imagePath);
		    String B64 = a.encoder();
		    System.out.println("Base64ImageString = " + B64);
		    a.decoder(B64, "C:\\Users\\User\\Desktop\\decoderimage.jpg");
		    System.out.println(B64.length());
		  }
		String imagePath;
		public ImgComp(String f)
		{
		 imagePath=f;
		}
		 
}