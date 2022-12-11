package ChooseFile;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class fileReader {

	public static void main(String[] args) throws IOException {
		Reader reader = null;
		try {
			reader = new FileReader("files/InputStreamExample.txt");
			int data;
			while ((data = reader.read()) != -1) {
				System.out.println("char ==> " + (char) data);
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}
}
