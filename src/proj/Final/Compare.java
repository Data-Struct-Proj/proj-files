package end_proj;

import java.io.*;
/* The objective is to read a file convert it into ASCII values and export it 
 * then display the size it takes to store it in ASCII form,load the hashfile we got using Huffman
 * and compare size
 * 8 bits = 1 byte and each ASCII is 8 bit so no of characters on the original file will be no of bytes
 * for the hashfile we created count the no of characters in the string then divide by 8 to get the bytes
 * Instead of using a array use linkedlist
 * And we need to load two files the output in ascii form and the output we generated so write a function to create a 
 * ASCII file first.
*/
public class Compare {
	char[]F1;
	char[]F2;
	public Compare(String l1,String l2) {
		//l1 is the first file loc and l2 is the second
		// call read() twice here with l1 and l1
	}
	public boolean isAlpha(char s) {
		return Character.isLetter(s)|| s == ' ' || s == '\n';
	}
	public char[] read(String loc) throws IOException {
	
	}
	// create a function to return the file size in bytes.
	// If possible come up with methods to compare hash values. (Group discussion)
	
public static void main(String[] args) {
	System.out.println("\n".hashCode());
}
}
