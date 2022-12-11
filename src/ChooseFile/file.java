package ChooseFile;

import java.io.*;

public class file {

	public static void main(String args[]) throws IOException {
		File f = new File("src/week6/ReadFileFor.java");
		// java.io.File f = new java.io.File("source/x.javaÃ¢â‚¬Â�);
		System.out.println("getName: " + f.getName()); // x.java
		System.out.println("getPath: " + f.getPath()); // source/x.java
		System.out.println("getAbsolutePath: " + f.getAbsolutePath());
		// c:\source\x.java
		System.out.println("exists: " + f.exists()); // true
		System.out.println("isFile: " + f.isFile()); // true
		System.out.println("isDirectory: " + f.isDirectory()); // false
		System.out.println("canWrite: " + f.canWrite()); // true
		System.out.println("canRead: " + f.canRead()); // true
		System.out.println("length: " + f.length()); // 562 Bytes
	}

}

