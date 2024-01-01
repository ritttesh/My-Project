package Practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class FileReadnWrite {
	public static void main(String[] args) throws IOException {
		Reader infile=new FileReader("readfrom.txt");
		Writer outfile=new FileWriter("writeto.txt");
		
		int i=infile.read();
		
		while(i!=-1) {
			outfile.write(i);
			i=infile.read();
		}
		
	}

}
