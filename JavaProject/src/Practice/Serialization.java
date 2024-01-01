package Practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class student implements Serializable{
	int id;
	String fname,lname,group;
	
	student(int id,String fname,String lname){
		this.id=id;
		this.fname=fname;
		this.lname=lname;
	}
	public String toString(Object obj) {
		student st=(student)obj;
		return st.fname+st.lname;
	}
	
}
public class Serialization {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		student s=new student(10,"ritesh","ranjan");
		// convert state of an object  to a byte stream 
		File file=new File("C:\\Users\\pritesh.ranjan\\Documents\\sample.txt");
		FileOutputStream filestream=new FileOutputStream(file);
		ObjectOutputStream objstream=new ObjectOutputStream(filestream);
		objstream.writeObject(s);
		objstream.flush();
		filestream.close();
		
		//deserialization
		FileInputStream inFile = new FileInputStream(file);
		ObjectInputStream objStream = new ObjectInputStream(inFile);
		 
// Read an object from the file stream(byte stream can be reverted back into a copy of the object)
		student st = (student) objStream.readObject();
		 
		// Rest of the code
		 
		objStream.close();
		inFile.close();
		
		System.out.println(s.toString(st));
	}

}
