package proj;
import java.io.*;
public class ReadFile {
	public boolean isAlpha(char s) {
		return Character.isLetter(s);
	}
	public char[] reading(String loc) throws IOException {
		      BufferedReader reader;
		      int count=0;
	          char[] a=new char[1000];
			
			  reader = new BufferedReader(new FileReader(loc));
		

			  int i ;

			  while((i =  reader.read())!=-1){
			  char ch = (char)i;
			  if(isAlpha(ch)) {
				   	a[count++]=Character.toLowerCase(ch);
			   				   }
			  }
		return a;	  
	}
public static void main(String[] args) throws IOException {
	ReadFile n = new ReadFile();
	String loc="C:\\Users\\srina\\Desktop\\trial.txt";
	n.reading(loc);
	
}


}
