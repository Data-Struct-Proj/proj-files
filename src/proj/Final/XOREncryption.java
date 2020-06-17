package end_proj;

class XOREncryption 
{ 

 static String encryptDecrypt(String inputString) 
 { 
     // Define XOR key 
     // Any character value will work 
     String xorKey = "AnirudH"; 

     String outputString = ""; 

     int len = inputString.length(); 

     for (int i = 0; i < len; i++)  
     { 
         outputString = outputString +  
         Character.toString((char) (inputString.charAt(i) ^ xorKey.charAt(i%xorKey.length()))); 
     } 

     System.out.println(outputString); 
     return outputString; 
 } 

 // Driver code 
 public static void main(String[] args) throws Exception 
 { 
     String sampleString = "101101010011001001011111000101100011"; 
     String a = encryptDecrypt(sampleString);
     encryptDecrypt(a);
 } 
} 