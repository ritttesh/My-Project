package Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream {
	public static void main(String[] args) {

	}

	public void readFile() throws IOException {
		// Create an stream instance with the file to read as input
		FileInputStream inFile = new FileInputStream("CandidateNames.txt");
		
		// Read the first byte
		int i = inFile.read();
		
		// Keep reading till end of file
		while (i != -1) {
			System.out.print((char)i);
			// Read the next byte
			i = inFile.read();
		}
		 
		// Close the stream to release resources held by it
		inFile.close();
	}

	public void writeFile() throws IOException {
		// Create a stream instance to write to a file
		FileOutputStream outFile = new FileOutputStream("CandidateNames.txt"); 
		
		String data = "Ahalya Bhairav Chitra Dushyant Eshwari Falgun Gargi Hiren";
		// Convert string to byte array
		byte bArray[] = data.getBytes();

		// Write bytes into the file with overloaded method which takes a byte array
		outFile.write(bArray);   

		// Close the stream to release resources held by it
		outFile.close();                                                      

	}
}
