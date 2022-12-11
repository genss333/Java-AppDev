package ChooseFile;

import java.io.*;

public class FileDirectory {

	public static void main(String args[]) {
		String dir = ".";
		File d = new File(dir);
		String n[] = d.list();
		System.out.println(n.length);
		for (int i = 0; i < n.length; i++) {
			File f = new File(dir + "/" + n[i]);
			System.out.println(i + ":" + n[i] +  ", Size = " + f.length());
		}
	}
}
