package end_proj;
import java.math.BigInteger; 
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException; 

  
public class SHA_1 { 
    public static String encryptThisString(String input) 
    { 
        try { 
           
            MessageDigest md = MessageDigest.getInstance("SHA-1"); 
  
            byte[] messageDigest = md.digest(input.getBytes()); 

            BigInteger no = new BigInteger(1, messageDigest); 
  
            String hashtext = no.toString(16); 

            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 

            return hashtext; 
        } 

        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 
    static boolean compare(String a,String b) {
    	return(encryptThisString(a)==encryptThisString(b));
    }
  
    // Driver code 
    public static void main(String args[]) 
    { 
  
        String s1 = "0000111110100101";
        String s2 = "1010111111110000";
        System.out.println(compare(s1,s2)); 
  
    } 
} 

