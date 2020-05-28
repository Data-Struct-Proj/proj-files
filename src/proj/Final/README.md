			            End-Sem-DataStructures-Proj
Authors :
* Aaditya Jain
* Anirudh Bhaskar
* C S Ayush Kumar
* Rohith Ramakrishnan
* Srinath Murali

					   The Objective : 

Preprocess a text file (allow only alphabets to remain, filter all other characters from each line), then tokenise it (to a list of words) and store it in an array of characters. Create an alphabet BST that stores a Key-Value pair of characters in this array (from the file) and its count; read the file, one character at a time and insert it to the BST along with a count value, with the character as the key (decides the ordering in the BST). The first occurrence inserts the new node for that character with count as one, successive duplicate occurrences locates this node and increments the count by one. Once the entire file is done this way, we start populating a Heap with the characters but this time with the count as the key. THIS SHOULD BE A MAX HEAP. The root of the heap also contains an index 1(binary), the left child is 10 and right child is 11. This will continue down the entire heap and the binary indexing is done based on the number of times a character (alphabet) occurs; the more times It occurs the smaller should be its index value, thus saving on file size. Encode the file by replacing the ASCII character by the binary value string. Once we have this heap we must be able to also decode to get the original file back.

				        The Implementation :

* A Text File is read character by character and stored in a character Array.
* A Binary Search Tree is generated and the character array is fed in as the input.
* As the characters repeat the BST's Nodes will increment the frequency of the character 
* When the char is read we will search the whole BST and if the char exists we increment otherwise we create a new 	    node for this char.
* We create a Node Array to store the Frequency and the Character.
* Using a MaxHeap we Implement the Huffman Algorithm and store the corresponding result in another BST.
* For DeCoding, the compressed file is given as the input along with the BST.
* The corresponding encoded/compressed file is retrieved without any loss other than special characters.

					Data-Structures-Used :
					
 *  Binary Search Tree
 *  Node Array 
 *  LinkedLists
 *  MaxHeap
 *  Arrays
					
						Result:
						
We loaded a text file (Case1.txt) containing texts from Wikipedia which include various Special Charecters and Numbers.
Size of the Original File is: 18.7802734375 KiloBytes for Ascii
Size of the Compressed/Encoded File is: 0.5770263671875 KiloBytes for Huffman Compression
